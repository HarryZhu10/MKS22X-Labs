public class OrbList {
    OrbNode first, last;

    //create a fixed orb
    public OrbList() {
      first = new FixedOrbNode(0, height/5);
      last = new FixedOrbNode(width, height/5);
      //link them to eachother
      first.next = last;
      last.prev = first;
    }

    /**
    *complete this method
    */
    void add(OrbNode orb){
     //insert orb at the end of the list before the last node.
     orb.next = last;
     orb.prev = first;
     last.prev = orb;
     first.next = orb;
    }

    /**
    *complete this method
    *process all nodes by running move.
    */
    void processAll() {
      OrbNode current = first;
      //advance current to next until it is null, move() each of the nodes
      while (current != null) {
        current.move();
        current = current.next;
      }
      
    }
    /**
    *complete this method
    *Display all nodes by running their display().
    */
    void display() {
      OrbNode current = first;
      //advance current to next until it is null, display() each of the nodes
      while (current != null) {
        current.display();
        current = current.next;
      }
      
    }
    
    void add (int xcor, OrbNode toBeAdded) {
      OrbNode current = first;
      OrbNode previous = new OrbNode();
      
      while (current.x < xcor) {
        previous = current;
        current = current.next;
      }
      
      toBeAdded.next = current;
      toBeAdded.prev = previous;
      current.prev = toBeAdded;
      previous.next = toBeAdded;
    }
    
    
    void delete (OrbNode target) {
      if (target != null && target.next != null && target.prev != null) {
      target.next.prev = target.prev ;
      target.prev.next = target.next ;
      }
    }
    
    
    OrbNode getNodeAt(int x, int y) {
      OrbNode current = first.next;
      while (current.next != null) {
      if ((x < current.x + current.radius && x > current.x - current.radius) && (y > current.y - current.radius && y < current.y + current.radius)) {
        return current;
      }
      current = current.next;
      }
      return null;
    }
    
  }
