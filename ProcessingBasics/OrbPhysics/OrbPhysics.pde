
    ArrayList<Orb>orbList;
    Orb center;
    int mode;
    void setup() {
      size(1000, 800);
      orbList = new ArrayList<Orb>();
      center = new Orb(width/2.0, height/2.0,0,0,20);
      mode = 0;

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
      background(255);
      center.display();
      for (Orb o : orbList) {
        o.move();
        o.display();
        if (mode == 0) {
          fill(0);
          text("Mode: Gravity", 10, 60);
        } else {
          fill(0);
          text("Mode: Orbit", 10, 60);
          o.attract(center);
        }
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
        if (mode == 0) {
        mode ++;
        } else {
          mode --;
        }
        
      }
    }
