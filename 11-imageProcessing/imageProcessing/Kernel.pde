
    public class Kernel {
      float[][]kernel;

      /**Constructor takes the kernel that will be applied to the image
      *This implementation only allows 3x3 kernels
      */
      public Kernel(float[][] init) {
        kernel = init;
        
      }

      /**If part of the kernel is off of the image, return black, Otherwise
      *Calculate the convolution of r/g/b separately, and return that color
       */
      color calcNewColor(PImage img, int x, int y) {
        //Hint: start by always returning black.
        //This will let you test your apply method right away!
        if (x == 0 || y == 0) {
          return 0;
        }
        
        for (float[] row : kernel) {
          
        }
        
      }

      /**You must write this method that applies the kernel to the source,
        *and saves the data to the destination.*/
      void apply(PImage source, PImage destination) {
      }

    }
  
