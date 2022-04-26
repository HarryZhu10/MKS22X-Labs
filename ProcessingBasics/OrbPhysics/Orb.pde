 public class Orb{
      float x,y;
      float xSpeed,ySpeed;
      float radius;
      color c;
      
      public Orb(float x_,float y_,float xSpeed_, float ySpeed_, float radius_ ){
        x = x_;
        y = y_;
        xSpeed = xSpeed_;
        ySpeed = ySpeed_;
        radius = radius_;
        //random color... why not.
        c = color(random(255),random(255),random(255));
      }


      void display(){
        //Part 1:
        //draw a ellipse at the x,y position, with the correct radius.
        //make sure it is the correct color
        fill(c);
        ellipse(x, y, radius, radius);
        line(x,y, x + 5 * xSpeed, y + 5 * ySpeed);
      }

      void move(){
        //PART 2
        //change the x based on the xSpeed
        //change the y based on the ySpeed
        
        //PART 3
        //Change the speed when you collide with the end of the screen (all 4 sides)
        ySpeed += 0.15;
        x += xSpeed;
        y += ySpeed;
        
        if ( x <= 0 || x >= width || y <= 0 || y >= height) {
          xSpeed = -1 * xSpeed;
          ySpeed = -1 * ySpeed;
        }
        
      }
      
      
      void attract (Orb other) {
        x += xSpeed;
        y += ySpeed;
        double d = dist(x,y,other.x,other.y);
        if (d > 0.0001) {
        xSpeed += 20 * ( (other.x - x)) / (d*d );
        ySpeed += 20 * ( (other.y - y)) / (d*d ); 
        }
      }
    }
