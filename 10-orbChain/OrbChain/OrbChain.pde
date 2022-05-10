
      final static int SPRING = 2;
       static float SPRING_LENGTH = 50;
       static float SPRING_DAMPEN = 0.990;
       static float SPRING_CONSTANT = 0.015;
       static float GRAVITY = 0.35;
      final static int MODE = SPRING;
      OrbList orbs;
      void setup() {
        size(1000, 800);
        orbs = new OrbList();
      }
      void mouseClicked() {
        orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
      }
      
      void draw() {
        background(255);
        orbs.processAll();
        orbs.display();
      }
      
      void keyPressed() {
        if (key == 49) {
          SPRING_CONSTANT *= 1.05;
        }
        
        if (key == 50) {
          SPRING_CONSTANT *= 0.95;
        }
        if (key == 51) {
          SPRING_DAMPEN *= 1.05;
        }
        if (key == 52) {
          SPRING_DAMPEN *= 0.95;
        }
        if (key == 53) {
          SPRING_LENGTH *= 1.05;
        }
        if (key == 54) {
          SPRING_LENGTH *= 0.95;
        }
        if (key == 55) {
          GRAVITY *= 1.05;
        }
        if (key == 56) {
          GRAVITY *= 0.95;
        }
      }
    
