public class Barnsley_Fern extends Main {
    //matrix algebra
    //indivual affine transformations each with a probability

    double x = 0.5;
    double y = 0.0;

    int n = Integer.parseInt(args[0]); //number of points to draw

      for(int i = 0; i < n; i++){
            double nextX;
            double nextY;

            stroke(255);
            strokeWeight(8);
            double r = random(1);

            //stem
            if (r < 0.01) {
                nextX = 0.50; //matrix algebra
                nextY = (0.16 * y);
            } else if (r <= 0.08) {
                nextX = (0.20 * x - 0.26 * y + 0.400); //matrix algebra
                nextY = (0.23 * x + 0.22 * y - 0.045);
            } else if (r <= 0.15) {
                nextX = (0.20 * x + -0.26 * y + 0.400); //matrix algebra
                nextY = (0.23 * x + 0.22 * y - 0.045);
            } else {
                nextX = (0.85 * x + 0.04 * y + 0.075); //matrix algebra
                nextY = (-0.04 * x + 0.85 * y + 0.180);
            }

            x = nextX;
            y = nextY;
            point(x, y);
        }
    }

