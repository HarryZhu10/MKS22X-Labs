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
        ellipse(x, y, 2 * radius, 2 * radius);
        line(x,y, x + 5 * xSpeed, y + 5 * ySpeed);
      }

      void move(){
        //PART 2
        //change the x based on the xSpeed
        //change the y based on the ySpeed
        
        //PART 3
        //Change the speed when you collide with the end of the screen (all 4 sides)
        
        if (gravity) {
          ySpeed += 0.15;
        } 
        
        x += xSpeed;
        y += ySpeed;
        
        if (mode == GRAVITY) {
          bounce();
        } else if (mode == ORBIT) {
          attract(center);
        } else if (mode == SPRING) {
          attractSpring(center);
        }

        
      }
      
      
      void attract (Orb other) {
        float d = dist(x,y,other.x,other.y);
        if (d > 0.0001) {
        xSpeed += 20 * ( (other.x - x)) / (d*d );
        ySpeed += 20 * ( (other.y - y)) / (d*d ); 
        }
      }
      
      void bounce () {
        if ( x <= 0 || x >= width) {
          xSpeed = -1 * xSpeed;
        }
        if (y <= 0 || y >= height) {
          ySpeed = -1 * ySpeed;
        }
      }
      
      
     void attractSpring (Orb other) {
       line(x,y,other.x,other.y);
      float d = dist(x,y,other.x,other.y);
      float force = d - SPRING_LENGTH;
      xSpeed += SPRING_CONSTANT * (force * (other.x - x))/ d;
      xSpeed *= SPRING_DAMPEN;
      ySpeed += SPRING_CONSTANT * (force * (other.y - y))/ d;
      ySpeed *= SPRING_DAMPEN;
    }
    }
    
