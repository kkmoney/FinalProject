import processing.core.PApplet;
public class Main extends PApplet{

    private float theta;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(800, 800); //draw the canvas
    }

    public void setUp() {
    }

    public void draw(){
        background(255);
        theta = map(mouseX,0,width,0,PI/2);

        translate(width/2, height);
        stroke(0);
        branch(60);
    }

    public void branch(float len){
        line(0, 0, 0, -len);
        translate(0, -len);

        len *= 0.66;

        if (len > 2) {
            pushMatrix();
            rotate(theta);
            branch(len);
            popMatrix();

            pushMatrix();
            rotate(-theta);
            branch(len);
            popMatrix();
        }
        }
    }
 //move tree to different position

    //start w fractal trees + flowers
    //if time, add L-systems

