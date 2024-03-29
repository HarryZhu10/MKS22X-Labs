
   String[]names;
      Kernel[]kernels;
      int currentKernel;
      PImage car, output;
      void setup(){
        size(1450,500);
        currentKernel = 0;
       car = loadImage("redcar.png");
       output = car.copy();
        names = new String[]{
          "Identity", "Blur", "Sharpen",
          "Outline", "Left Sobel", "Right Sobel",
          "Top Sobel", "Emboss"
        };

        kernels = new Kernel[] {
          new Kernel( new float[][] {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
          }) ,
          new Kernel( new float[][] {
            {.111, .111, .111},
            {.111, .111, .111},
            {.111, .111, .111}
          }) ,
          new Kernel( new float[][] {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
          }) ,
          new Kernel( new float[][] {
            {-1, -1, -1},
            {-1, 8, -1},
            {-1, -1, -1}
          }) ,
          new Kernel( new float[][] {
            {1, 0, -1},
            {2, 0, -2},
            {1, 0, -1}
          }) ,
          new Kernel( new float[][] {
            {-1, 0, 1},
            {-2, 0, 2},
            {-1, 0, 1}
          }) ,
          new Kernel( new float[][] {
            {1, 2,  1},
            {0, 0, 0},
            {-1, -2, -1}
          }),
          new Kernel( new float[][] {
            {-2, -1,  0},
            {-1, 1, 1},
            {0, 1, 2}
          })
        };
      }
      
      void draw() {
      kernels[currentKernel].apply(car,output);
      image(car,0,0);
      image(output,car.width,0);
      }
      
      
      void keyPressed() {
        if (key == 49) {
          if (currentKernel < 7) {
          currentKernel++;
        } else {
          currentKernel = 0;
        }
        }
      }
