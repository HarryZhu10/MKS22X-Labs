
    ArrayList<Orb>orbList;
    void setup() {
      size(1000, 700);
      orbList = new ArrayList<Orb>();

    }
    void mouseClicked() {
      //add a new Orb to the orbList, constructed as follows:
      //The x and y positions are the same as the mouse
      //the size should be between [20.0,70.0)
      //the dx and dy should be [-3.0,3.0)
      Orb ball = new Orb(mouseX, mouseY, random(6) - 3, random(6) - 3, random(50) + 20);
      orbList.add(ball);
    }
    void draw() {
      background(255);
      Orb center = new Orb(width/2.0, height/2.0,0,0,20);
      center.display();
      for (Orb o : orbList) {
        o.move();
        o.display();
        o.attract(center);
      }
      fill(0);
      text(frameRate,20,20);
      text(orbList.size(),20,40);
    }
