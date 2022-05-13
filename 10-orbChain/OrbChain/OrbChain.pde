
      final static int ADD_MODE = 1;
      final static int INSERT_MODE = 2;
      final static int DELETE_MODE = 3;
       static float SPRING_LENGTH = 50;
       static float SPRING_DAMPEN = 0.990;
       static float SPRING_CONSTANT = 0.015;
       static float GRAVITY = 0.35;
       static int MODE = ADD_MODE;
      OrbList orbs;
      void setup() {
        size(1000, 800);
        orbs = new OrbList();
      }
      void mouseClicked() {
        if (MODE == ADD_MODE) {
          orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
        
        } else if (MODE == INSERT_MODE) {
          orbs.add(mouseX, new OrbNode(mouseX,mouseY,0,0,30));
        } else { 
          orbs.delete(orbs.getNodeAt(mouseX, mouseY));
          
        }
        
   
        
      }
      
      void draw() {
        background(255);
        fill(0);
        if (MODE == ADD_MODE) {
         text("ADD MODE", 10, 10);
        } else if (MODE == INSERT_MODE) {
          text("INSERT MODE", 10, 10);
        } else {
          text("DELETE MODE", 10, 10);        }

        text("SPRING_CONSTANT: " + SPRING_CONSTANT, 10, 25);
        text("SPRING_DAMPEN: " + SPRING_DAMPEN, 10, 40);
        text("SPRING_LENGTH: " + SPRING_LENGTH, 10, 55);
        text("GRAVITY: " + GRAVITY, 10, 70);
        orbs.processAll();
        orbs.display();
        
      }
      
      void keyPressed() {
        if (key == 49) {
          SPRING_CONSTANT *= 1.05;
          fill(255);
          noStroke();
          rect(0,0,10,70);
          stroke(0);
        }
        
        if (key == 50) {
          SPRING_CONSTANT *= 0.95;
          fill(255);
          noStroke();
          rect(0,0,10,70);
          stroke(0);
        }
        if (key == 51) {
          SPRING_DAMPEN *= 1.002;
          if (SPRING_DAMPEN > 1) {
            SPRING_DAMPEN = 1;
          }
          fill(255);
          noStroke();
          rect(0,0,10,70);
          stroke(0);
        }
        if (key == 52) {
          SPRING_DAMPEN *= 0.998;
          fill(255);
          noStroke();
          rect(0,0,10,70);
          stroke(0);
        }
        if (key == 53) {
          SPRING_LENGTH *= 1.05;
          fill(255);
          noStroke();
          rect(0,0,10,70);
          stroke(0);
        }
        if (key == 54) {
          SPRING_LENGTH *= 0.95;
          fill(255);
          noStroke();
          rect(0,0,10,70);
          stroke(0);
        }
        if (key == 55) {
          GRAVITY *= 1.05;
          fill(255);
          noStroke();
          rect(0,0,10,70);
          stroke(0);
        }
        if (key == 56) {
          GRAVITY *= 0.95;
          fill(255);
          noStroke();
          rect(0,0,10,70);
          stroke(0);
        }
        
        if (keyCode == 32) {
          if (MODE < 3) {
            MODE ++;
          } else {
            MODE = 1;
          }
        
        }
      }
