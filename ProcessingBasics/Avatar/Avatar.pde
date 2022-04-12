void avatar(int x, int y){
  fill(255,0,0);
  ellipse(x, y - 300, 100, 150);
  fill(255,255,0);
  circle(x,y, 500);
  fill(0,0,0);
  circle(x - 100, y - 100, 100);
  circle(x + 100, y - 100, 100);
  fill(255,0,0);
  ellipse(x,y + 100,60,150);
  fill(255,165,0);
  ellipse(x, y, 300, 150);

 
}


int x,y;
  int MODE;
  void setup(){
           size(800,800);
           MODE = 1;
           x = width/2;
           y = height/2;
  }
  void draw(){
           background(255);
           x = change(x);
           y = change(y);
           avatar(x,y);
            avatar(mouseX,mouseY);
  }
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change each by +1, 0, or -1 randomly
     mode 3: change by +1 each, but if they hit the end of the screen ,
           wrap back around to the other end of the screen
    */

    switch(MODE){
     case 1:
       return (int) random(800);
     case 2:
     int val = (int) random(3) - 1;
       return value + val;
     case 3:
     if (x >= 650 || y >= 650) {
       x = 150;
       y = 150;
     }
       return value + 1;
     default:
       return 0;
    }
  }
  
  void mouseClicked () {
    println("MODE: " + MODE);
    if (MODE > 2) {
      MODE = 1;
    } else {
    MODE ++;
    }
    println("X-coordinate: " + x);
    println("Y-coordinate: " + y);
  }
  
  /*
  void mouseMoved () {
    avatar(mouseX,mouseY);
  }
  */
  
  
  
  /*
void setup(){
  size(800, 800);
  avatar(400,400);

}
*/
