import processing.core.PApplet;
public class Main extends PApplet {

    private float theta;

    private float theta2;


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
        theta = map(mouseX, 0, width, 0, PI / 2);
        theta2 = map(mouseX, 0, width, 0, PI / 2);

        translate(width / 4, height / 3);
        stroke(0);
        tree1(60);
        strokeWeight(2);

        translate(width / 3, height / 8);
        stroke(0);
        tree2(80);
        strokeWeight(2);
    }

    public void tree1(float len) { //tree number 1: basic tree on top left console
        line(0, 0, 0, -len);
        translate(0, -len);

        len *= 0.66;

        if (len > 2) {
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

    public void tree2(float len2) { //tree number 2: tree with random angle and length on top middle console and also random branches
        float theta2 = random(0, PI / 2);
        line(0, 0, 0, -len2);
        translate(0, -len2);
        len2 *= 0.66;

        if (len2 > 2) {
            int n = (int) (Math.random() * 4) + 1;
            for (int i = 0; i < n; i++) {
                float theta3 = random(-PI / 2, PI / 2);
                pushMatrix();
                rotate(theta3);
                tree2(len2);
                popMatrix();
            }
        }


    }
}


//add different features like lightening and mountains 

    //start w fractal trees + flowers
    //if time, add L-systems

