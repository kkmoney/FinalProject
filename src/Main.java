import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import java.util.ArrayList;
import java.util.Random;

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

    private static int k;

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
        heart2();

        //Source: The Coding Train on Youtube
    }

    public void heart2(){
        translate(width / 1, height / 1);
        strokeWeight(4);
        fill(0, 255, 0);
        stroke(0,0,255);
        beginShape();
        for(PVector v: heart){
            vertex(v.x, v.y);
        }
        endShape();

        float r = 5;
        float x = r * 7 * pow(sin(a), 3);
        float y = -r * (13 * cos(a) - (5 * cos(2 * a)) - 2 * cos(3 * a) - cos(4 * a));
        heart.add(new PVector(x, y));
        a += 0.00;
    }

    public void flower(){
        translate(width / 2, height / 2);
        line(0, 0, 0, 400);
        translate(0, -50);

        fill(102, 0, 153);
        pushMatrix();
        rotate(PI/6);
        petal();
        popMatrix();

        fill(255, 204, 51);
        pushMatrix();
        rotate(-PI/6);
        petal();
        popMatrix();

        fill(102, 255, 102);
        pushMatrix();
        rotate(PI/12);
        petal();
        popMatrix();

        fill(51, 204, 255);
        pushMatrix();
        rotate(-PI/12);
        petal();
        popMatrix();

    }

    public void petal(){
        beginShape();
        for(float a = 0; a < TWO_PI; a += 0.01){
            float r = 100;
            float x = r * pow(cos(a), 3);
            float y = r * sin(a);
            vertex(x, y);
        }
        endShape();
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

    public void background(){
        loadPixels();
        for (int x = 0; x < width; x++ ) {
            for (int y = 0; y < height; y++ ) {
               int loc = x + y * width;
                if (x % 2 == 0) {
                    pixels[loc] = color(255, 255, 204);
                } else if (x % 4 == 0) {
                    pixels[loc] = color(102, 255, 102);
                } else if(x % 6 == 0) {
                    pixels[loc] = color(255,102,102);
                } else{
                    pixels[loc] = color(0);
                }
            }
        }
        updatePixels();

    }

    public void h(){
        background();
        recursion();
    }
    public void background2(){
        loadPixels();
        for (int x = 0; x < width; x++ ) {
            for (int y = 0; y < height; y++ ) {
                int loc = x + y * width;
                if (x % 2 == 0) {
                    pixels[loc] = color(0,255,0);
                } else{
                    pixels[loc] = color(0,0,255);
                }
            }
        }
        updatePixels();
    }

  public void recursion(){
     drawBasicCircle(mouseX, mouseY, 400);
     drawBasicCircle(mouseX, mouseY, 350);
     drawBasicCircle(mouseX, mouseY, 300);
     drawBasicCircle(mouseX, mouseY, 250);
     drawBasicCircle(mouseX, mouseY, 200);
     drawBasicCircle(mouseX, mouseY, 150);
     drawBasicCircle(mouseX, mouseY, 100);

      if(mousePressed){
          fill(random(0,255), random(0,255), random(0,255));
          ellipse(mouseX, mouseY, 50, 50);
      }
  }


    public void drawBasicCircle(int x, int y, int radius){
            ellipse(x,y,radius,radius);
        }


    public void instructions(){
        fill(0);
        String line1 = "Here are the instructions to this painting:";
        String line2 = "press a for instructions";
        String line3 =  "press b for a recursive tree,";
        String line4 = "press c for an animated flower,";
        String line5 =  "press d for a animated circle,";
        String line6 = "press e for a painting of circles,";
        String line7 = "press f for an animated heart";
        String line8 = "press g for saturation";
        String line9 = "press h for flower";
        String line10 = "press i for tree";
        String line11 = "press j for gradiant";
        String line12 = "press k for hue";
        String line13 = "press l for another recursive drawing";

        text((line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n" + line7 + "\n" + line8 + "" +
                        "\n" + line9 + "\n" + line10 + "\n" + line11 + "\n" + line12 + "\n" + line13),
                width / 3,height / 3);
    }

    public void drawGradient(float x, float y){

        ellipseMode(RADIUS); //modifies location of ellipse
        int dim = width / 2;
        int radius = dim / 2;
        float h = random(0, 360);
        for (int r = radius; r > 0; r--) {
            fill(h, 100, 100);
            ellipse(x, y, r, r);
            h = (h + 1) % 360; //shift colors
            }
        }

        public void hue(){
            colorMode(HSB, height, height, height);
            background(0);
            //hue is color transmitted from object; cursor moves affects hue
            int width = 20;
            int bar = -1;

            int hue = mouseX / width;
            if(hue != bar){
                int barX = hue * width;
                fill(mouseY, height, height);
                rect(barX, 0, width, height);
                bar = hue;
            }
        }

        public void saturation() {
        //strength of color in hue
            colorMode(HSB, width, height, 100); //hsb describes saturation and brightness, different to rgb
            noStroke();

            int width = 20;
            int bar = -1;
            int secondBar = mouseX / width;
            if (secondBar != bar) {
                int barX = secondBar * width;
                fill(barX, mouseY, 66);
                rect(barX, 0, width, height);
                bar = secondBar;
            }
        }


        public void drawGradiantCircles(){
            background(100,0,0);
            stroke(0,0,255);
            int dim = width / 2;

            for (int k = 0; k <= width; k+= dim) {
                drawGradient(k, height / 2);
            }
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

            //drawing + background
            h();

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

            //saturation
            saturation();


        } else if(key =='h'){

            //flower2

            stroke(0,0,0);
            line(0, 0, 0, 400);
            background2();
            flower();

        } else if(key == 'i'){

            //fast tree
            translate((float) (width / 2), (float) (height /1));
            background(255, 102, 102);
            stroke(51, 153, 255);
            tree2(175);

        } else if(key == 'j'){

            //draw gradiant circles
            drawGradiantCircles();

        } else if(key == 'k'){

            //hue
            hue();

        } else if(key =='l'){

            //another circle drawing
            background(204, 204, 204);
            circle_again(width/2,height/2,200);
            circle_again2(width / 4, height / 4, 200);
            circle_again3((float) (width / 1.3), (float) (height / 1.3), 200);
            circle_again4((float) (width / 4), (float) (height / 1.3), 200);
            circle_again5((float) (width / 1.3), (float) (height / 4), 200);

        }

    }
}

