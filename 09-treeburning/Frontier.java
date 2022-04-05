import java.io.*;
import java.util.*;

public class Frontier{
     private Deque<int[]> frontier;
     public Frontier(){
       frontier = new ArrayDeque<int[]>();
     }
     public int size(){
       return frontier.size();
     }
     public void add(int[] location){
       frontier.addLast(location);
     }
     public int[] remove(){
       return frontier.removeFirst();
     }
   }
