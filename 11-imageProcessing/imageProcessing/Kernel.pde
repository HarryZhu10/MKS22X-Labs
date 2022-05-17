
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
        img.loadPixels();
        if (x == 0 || y == 0 || x == img.width || y == img.height) {
          return 0;
        }
        float result = 0;
        
        for (int i = 0; i < 3; i ++) {
          for (int j = 0; j < 3; j ++) {
            result = result + kernel[i][j] * img.get(x + i - 1,y + j - 1);;
          }
        }
        
        return (int) result;
      }

      /**You must write this method that applies the kernel to the source,
        *and saves the data to the destination.*/
      void apply(PImage source, PImage destination) {
        for (int i = 0; i < source.height; i ++) {
          for (int j = 0; j < source.width; j ++) {
            destination.set(j, i, calcNewColor(source, j,i));
          }
        }
      }

    }
  
