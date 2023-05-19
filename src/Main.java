import processing.core.PApplet;
public class Main extends PApplet {
  private float theta;
    private double x = 0.0;
    private double y = 0.0;

    private String timestamp; //variable for naming saved frames
    private float theta2;
    private float counter = 0;
    private float noPetals = 4; //number of petals the fractal flower has
    private float reductionFactor = 0.66F; //by what factor should the next branch get reduced by? 0.5 = each branch is half the size of the previous one.
    private float cutOff = 7; //what is the minimum branch length?  the fractal will continue to be drawn until this minimum size is reached.
    private float branchFactor = 2 ; //number of branches at each level
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
        theta = map(mouseX, 0, width, 0, PI / 2);

        translate(width / 2, height / 1);
        strokeWeight(4);
        keyPressed();

        counter += 1;
        theta2 = radians(counter);
        stroke(0,255,0);
        translate(width/400, height/100);
        for(int i = 0; i < noPetals; i++) {
            drawPetal();
            rotate((float) (PI / (noPetals/2.0)));
        }
    }

    public void branch(float h) {
        h *= reductionFactor;
        if (h > cutOff) {
            for(int i = 0; i < branchFactor; i++) {
                pushMatrix();
                rotate(branchFactor*theta2/2);
                line(0, 0, 0, -h);
                translate(0, -h);
                branch(h);
                popMatrix();

                pushMatrix();
                rotate(-branchFactor*theta2/2);
                line(0, 0, 0, -h);
                translate(0, -h);
                branch(h);
                popMatrix();

                if (branchFactor % 2 != 0) {
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

    public void keyPressed(){
        if(key == 'k'){
            tree1(150);
        }
    }

    //with each key pressed, a fractal snowflakes (koch) appears
    //another key pressed makes the snowflake spin
    //with another key pressed, make a square fractal appear
    //another key pressed makes the square spin

}
