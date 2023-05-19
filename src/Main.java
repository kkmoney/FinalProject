import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class Main extends PApplet {
    private float theta;
    private double x = 0.0;
    private double y = 0.0;
    private float theta2;
    private float counter = 0;
    private float petals = 4; //number of petals the fractal flower has
    private float reductionFactor = 0.66F; //by what factor should the next branch get reduced by
    private float cutOff = 7; //minimum branch length
    private float branch = 2 ; //number of branches at each level

    private PVector start;
    private PVector end;
    private ArrayList<kochSnowflake> lines;
    public static Main app;

    public Main(){
        super();
        app = this;
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(600, 600); //draw the canvas
    }

    public void setUp() {
    }

    public void draw() {
        background(255);
        keyPressed();

    }


    public void drawFlower(){
        counter += 1;
        theta2 = radians(counter);
        stroke(0,255,0);
        translate((float) (width / 2), (float) (height / 2));
        for(int i = 0; i < petals; i++) {
            drawPetal();
            rotate((float) (PI / (petals / 2.0)));
        }
    }

    public void branch(float h) {
        h *= reductionFactor;
        if (h > cutOff) {
            for(int i = 0; i < branch; i++) {
                pushMatrix();
                rotate(branch*theta2/2);
                line(0, 0, 0, -h);
                translate(0, -h);
                branch(h);
                popMatrix();

                pushMatrix();
                rotate(-branch*theta2/2);
                line(0, 0, 0, -h);
                translate(0, -h);
                branch(h);
                popMatrix();

                if (branch % 2 != 0) {
                    pushMatrix();
                    line(0, 0, 0, -h);
                    translate(0, -h);
                    branch(h);
                    popMatrix();
                }
            }
        }
    }

    public  void drawPetal() {
        line(0, 0, 0, -height/8);
        translate(0, -height/8);
        branch(height/8);
        translate(0, height/8);
    }

    public void tree1(float len) { //tree number 1
        line(0, 0, 0, -len);
        translate(0, -len);

        len *= 0.66;

        if (len > 1) {
            stroke(0,0,255);
            pushMatrix();
            rotate(theta);
            tree1(len);
            popMatrix();

            pushMatrix();
            rotate(-theta);
            tree1(len);
            popMatrix();
        }
    }

    public void keyPressed() {
        if (key == 'a') {

            theta = map(mouseX, 0, width, 0, PI / 2); //angle of big recursive tree
            translate(width / 2, height / 1);
            strokeWeight(4);
            tree1(150);

        } else if (key == 'b') {

            drawFlower(); //make flower appear

        } else if (key == 'c') {;

            //how do i call the class kochsnowflake?
            //make fractal snowflakes (koch) appear

        }  else if (key == 'd') {

            //makes the snowflake spin
        } else if (key == 'e') {
            //square fractal appear
        } else if (key == 'f') {
            //make square spin
        } else if (key == 'g') {
            //make circle appear
        } else if (key == 'h') {
            //make circles spin
        }

    }
    }

    //implement screen with instructions

