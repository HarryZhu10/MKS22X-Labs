
    ArrayList<Orb>orbList;
    Orb center;
    int mode;
    boolean gravity;
    boolean background;
    int GRAVITY = 0;
    int ORBIT = 1;
    int SPRING = 2;
    int SPRING_LENGTH = 100;
    float SPRING_DAMPEN = 0.995;
    float SPRING_CONSTANT = 0.005;
    
    void setup() {
      size(1000, 800);
      orbList = new ArrayList<Orb>();
      center = new Orb(width/2.0, height/2.0,0,0,20);
      mode = 0;
      gravity = true;
      background = true;
      
    }
    void mouseClicked() {
      //add a new Orb to the orbList, constructed as follows:
      //The x and y positions are the same as the mouse
      //the size should be between [20.0,70.0)
      //the dx and dy should be [-3.0,3.0)
      Orb ball = new Orb(mouseX, mouseY, 5, 0, 20);
      orbList.add(ball);
    }
    void draw() {
      
         if (background) {
          background(255);
          fill(0);
          text("Background is on", 20, 100);
        } else {
          fill(255);
          noStroke();
          rect(0,0, 120, 100);
          stroke(0);
          fill(0);
          text("Background is off", 20, 100);
        }
      
         if (gravity) {
          fill(0);
          text("Gravity is on", 20, 80);
        } else {
          fill(0);
          text("Gravity is off", 20, 80);
        }
        

        
         if (mode == GRAVITY) {
          fill(0);
          text("Mode: GRAVITY", 20, 60);
        } else if (mode == ORBIT) {
          fill(0);
          text("Mode: ORBIT", 20, 60);
        } else if (mode == SPRING) {
          fill(0);
          text("Mode: SPRING", 20, 60);
        }

      center.display();
      for (Orb o : orbList) {
        o.move();
        o.display();
      }
      fill(0);
      text(frameRate,20,20);
      text(orbList.size(),20,40);
    }
    
    
    void keyPressed() {
      if (keyCode == 8) {
        orbList.clear();
      }

      if (keyCode == 32) {
        if (mode < 2) {
        mode ++;
        } else {
          mode = 0;
        }
        
      }
      
      if (key == 103) {
        gravity = !gravity;
      }
      
      if (key == 98) {
        background = !background;
      }
    }
