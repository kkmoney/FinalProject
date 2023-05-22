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
    private float branch = 2; //number of branches at each level
    private PVector start;
    private PVector end;
    private ArrayList<kochSnowflake> lines;

    private float a;
    private float b;
    private float c;
    private float alpha;
    public static Main app;

    ArrayList<PVector> heart = new ArrayList<PVector>();

    public Main() {
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

    public void drawFlower() {
        counter += 1;
        theta2 = radians(counter);
        stroke(102, 0, 153);
        translate((float) (width / 2), (float) (height / 2));
        for (int i = 0; i < petals; i++) {
            drawPetal();
            rotate((float) (PI / (petals / 2.0)));
        }
    }

    public void branch(float h) {
        h *= reductionFactor;
        if (h > cutOff) {
            for (int i = 0; i < branch; i++) {
                pushMatrix();
                rotate(branch * theta2 / 2);
                line(0, 0, 0, -h);
                translate(0, -h);
                branch(h);
                popMatrix();

                pushMatrix();
                rotate(-branch * theta2 / 2);
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

    public void drawPetal() {
        line(0, 0, 0, -height / 8);
        translate(0, -height / 8);
        branch(height / 8);
        translate(0, height / 8);
    }

    public void tree1(float len) { //tree number 1
        line(0, 0, 0, -len);
        translate(0, -len);

        len *= 0.66;

        if (len > 1) {
            stroke(102, 255, 102);
            pushMatrix();
            rotate(theta);
            tree1(len);
            popMatrix();

            stroke(255, 102, 102);
            pushMatrix();
            rotate(-theta);
            tree1(len);
            popMatrix();
        }
    }

    public void drawCircle(float x, float y, float radius) {
        stroke(189, 230, 255);
        fill(230, 255, 189);
        ellipse(x, y, radius, radius);
        //recusive - for every circle, smaller circle is drawn
        if (radius > 4) {
            drawCircle(x + radius / 2, y, radius / 2);
            drawCircle(x - radius / 2, y, radius / 2);
            drawCircle(x, y + radius / 2, radius / 2);
            drawCircle(x, y - radius / 2, radius / 2);
        }
    }

    public void drawsmallercircles(float x, float y, float radius) {
        stroke(189, 230, 255);
        fill(230, 255, 189);
        ellipse(x, y, radius, radius);
        if (radius > 4) {
            drawCircle(x + radius / 2, y, radius / 2);
            drawCircle(x - radius / 2, y, radius / 2);
        }
    }

    public void drawsmall(float x, float y, float radius) {
        stroke(189, 230, 255);
        fill(230, 255, 189);
        ellipse(x, y, radius, radius);
        if (radius > 4) {
            drawCircle(x, y + radius / 2, radius / 2);
            drawCircle(x, y - radius / 2, radius / 2);
        }
    }

    public void drawbig(float x, float y, float radius) {
        stroke(255, 105, 180);
        fill(255, 105, 180);
        ellipse(x, y, radius, radius);
        if (radius > 2) {
            drawCircle(x, y + radius / 1, radius / 1);
            drawCircle(x, y - radius / 1, radius / 1);
        }
    }

    public void drawAnother(float x, float y, float radius) {
        stroke(255, 255, 0);
        fill(255, 255, 0);
        ellipse(x, y, radius, radius);
        if (radius > 4) {
            drawCircle(x, y + radius / 2, radius / 2);
            drawCircle(x, y - radius / 2, radius / 2);
        }
    }

    public void circle_again(float x, float y, float radius) {
        stroke(255, 102, 102);
        ellipse(x, y, radius, radius);
        if(radius > 16) {
            radius *= 0.75f;
            circle_again((x + radius/2), y, radius/2);
            circle_again((x - radius/2), y, radius/2);
            circle_again(x, y + radius/2, radius/2);
            circle_again(x, y - radius/2, radius/2);
            circle_again(x, y , radius/2);
            circle_again(x, y, radius/2);
        }
    }

    public void circle_again2(float x, float y, float radius) {
        stroke(51, 204, 255);
        ellipse(x, y, radius, radius);
        if(radius > 16) {
            radius *= 0.75f;
            circle_again2((x + radius/2), y, radius/2);
            circle_again2((x - radius/2), y, radius/2);
            circle_again2(x, y + radius/2, radius/2);
            circle_again2(x, y - radius/2, radius/2);
            circle_again2(x, y , radius/2);
            circle_again2(x, y, radius/2);
        }
    }

    public void circle_again3(float x, float y, float radius) {
        stroke(102, 255, 102);
        ellipse(x, y, radius, radius);
        if(radius > 16) {
            radius *= 0.75f;
            circle_again3((x + radius/2), y, radius/2);
            circle_again3((x - radius/2), y, radius/2);
            circle_again3(x, y + radius/2, radius/2);
            circle_again3(x, y - radius/2, radius/2);
            circle_again3(x, y , radius/2);
            circle_again3(x, y, radius/2);
        }
    }

    public void circle_again4(float x, float y, float radius) {
        stroke(255, 255, 0);
        ellipse(x, y, radius, radius);
        if(radius > 16) {
            radius *= 0.75f;
            circle_again4((x + radius/2), y, radius/2);
            circle_again4((x - radius/2), y, radius/2);
            circle_again4(x, y + radius/2, radius/2);
            circle_again4(x, y - radius/2, radius/2);
            circle_again4(x, y , radius/2);
            circle_again4(x, y, radius/2);
        }
    }

    public void circle_again5(float x, float y, float radius) {
        stroke(102, 0, 253);
        ellipse(x, y, radius, radius);
        if(radius > 16) {
            radius *= 0.75f;
            circle_again5((x + radius/2), y, radius/2);
            circle_again5((x - radius/2), y, radius/2);
            circle_again5(x, y + radius/2, radius/2);
            circle_again5(x, y - radius/2, radius/2);
            circle_again5(x, y , radius/2);
            circle_again5(x, y, radius/2);
        }
    }



    public void heart(){
        background(0);
        translate(width / 2, height / 2);
        strokeWeight(8);
        fill(0, 255, 0);
        stroke(255);

        beginShape();
        for(PVector v: heart){
            vertex(v.x, v.y);
        }
        endShape();

        float r = 10;
        float x = r * 16 * pow(sin(a), 3);
        float y = -r * (13 * cos(a) - (5 * cos(2 * a)) - 2 * cos(3 * a) - cos(4 * a));
        heart.add(new PVector(x, y));
        a += 0.05;
    }

    public void instructions(){
        fill(0);
        String line1 = "Here are the instructions to this painting:";
        String line2 = "press a for instructions";
        String line3 =  "press b for a recursive tree,";
        String line4 = "press c for an animated flower,";
        String line5 =  "press d for a koch snowflake,";
        String line6 = "press e for a painting of circles,";
        String line7 = "press f for an animated heart";
        String line8 = "press g for a recursive circle drawing";

        text((line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n" + line7 + "\n" + line8),
                width / 3,height / 3);
    }

    public void keyPressed() {

        if (key == 'a') {

            //instructions
            instructions();

        } else if (key == 'b') {

            //tree
            theta = map(mouseX, 0, width, 0, PI / 2);
            translate(width / 2, height / 1);
            background(255, 255, 204);
            strokeWeight(4);
            tree1(150);

        } else if (key == 'c') {

            //flower
            background(51, 204, 255);
            drawFlower();

        } else if (key == 'd') {

            //how do i call the class kochsnowflake?
            //make fractal snowflakes (koch) appear

        } else if(key == 'e'){

            //circle
            background(255, 255, 204);
            drawsmallercircles(width / 2, height / 2, 300);
            drawCircle(width / 2, height / 2, 275);
            drawsmall(width / 2, height / 2, 250);
            drawbig(width / 2, height / 2, 200);
            drawAnother(width / 2, height / 2, 100);

        } else if(key == 'f'){

            //heart
            heart();

        } else if(key == 'g'){

            background(204, 204, 204);
            circle_again(width/2,height/2,200);
            circle_again2(width / 4, height / 4, 200);
            circle_again3((float) (width / 1.3), (float) (height / 1.3), 200);
            circle_again4((float) (width / 4), (float) (height / 1.3), 200);
            circle_again5((float) (width / 1.3), (float) (height / 4), 200);

        }

    }
}

    //1.5 hours of class time: implement koch snowflake + add clouds or something
//2.5 hours of homework:  revise heart animation to make multiple hearts on the same page +  make another circle painting

