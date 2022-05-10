  public class OrbNode {
  float x, y;
  float dx, dy;
  float radius;
  color c;
  OrbNode next, prev;
  public OrbNode() {  }
  public OrbNode(float x_, float y_) {
    this(x_, y_, 0.0, 0.0, 50.0);
  }
  public OrbNode(float x_, float y_, float dx_, float dy_, float radius_ ) {
    x = x_;
    y = y_;
    dx = dx_;
    dy = dy_;
    radius = radius_;
    c = color(random(255), random(255), random(255), 200);
  }
   /**
  *complete this method
  */
  void display() {
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    //If next or previous exist, draw lines to them! (aim for slightly off center)
    /*you write this part*/
    if (this.prev != null) {
      //change this
      line(this.x - 5, this.y + 5, this.prev.x + 5, this.prev.y - 5);
    }
    
    if (this.next != null) {
      line(this.x + 5, this.y - 5, this.next.x - 5, this.next.y + 5);
    }
    
  }

  /**
  *complete this method
  */
  void move() {
    //have prev and next apply spring force to this node;
    /*you write this part*/
      next.attractSpring(this);
   
      prev.attractSpring(this);
    
    //apply velocity to position
    x+=dx;
    y+=dy;
    //apply gravity
    dy+=0.35;
  }
  
  void attractSpring (OrbNode other) {
       line(x,y,other.x,other.y);
      float d = dist(x,y,other.x,other.y);
      float force = d - SPRING_LENGTH;
      dx += SPRING_CONSTANT * (force * (other.x - x))/ d;
      dx *= SPRING_DAMPEN;
      dy += SPRING_CONSTANT * (force * (other.y - y))/ d;
      dy *= SPRING_DAMPEN;
    }
}

public class FixedOrbNode extends OrbNode{
   void move() {
   }
   FixedOrbNode(float x_, float y_) {
    x = x_;
    y = y_;
    radius = 30;
    c = color(0);
  }
}
