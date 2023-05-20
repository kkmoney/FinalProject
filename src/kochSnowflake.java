import processing.core.PVector;

import java.util.ArrayList;

public class kochSnowflake {
    private PVector start;
    private PVector end;

    ArrayList<kochSnowflake> lines;

    public kochSnowflake(PVector a, PVector b) {
        start = a.get();
        end = b.get();
    }


    public void display() {
        Main.app.stroke(0);
        Main.app.line(start.x, start.y, end.x, end.y);
    }

    public void setUp() {
        lines = new ArrayList<kochSnowflake>();
        PVector start = new PVector(0, 200);
        PVector end = new PVector(Main.app.width, 200);
        lines.add(new kochSnowflake(start, end));
        for (int i = 0; i < 5; i++) {
            generate();
        }
    }


    public void draw() {
        Main.app.background(255);
        for (kochSnowflake l : lines) {
            l.display();
        }
    }

    public void generate() {
        ArrayList next = new ArrayList<kochSnowflake>();
        for (kochSnowflake l : lines) {

            PVector a = l.kochA();
            PVector b = l.kochB();
            PVector c = l.kochC();
            PVector d = l.kochD();
            PVector e = l.kochE();

            next.add(new kochSnowflake(a, b));
            next.add(new kochSnowflake(b, c));
            next.add(new kochSnowflake(c, d));
            next.add(new kochSnowflake(d, e));
        }

        lines = next;
    }


    public PVector kochA(){
        return start.get();
    }

    public PVector kochE(){
        return start.get();
    }

    public PVector kochB() {
        PVector v = PVector.sub(end, start);
        v.div(3);
        v.add(start);
        return v;
    }

    public PVector kochD(){
        PVector v = PVector.sub(end, start);
        v.mult((float) (2/3.0));
        v.add(start);
        return v;
    }

    public PVector kochC(){
        PVector a = start.get();
        PVector v = PVector.sub(end, start);
        v.div(3);
        a.add(v);
        v.rotate(-Main.app.radians(60));
        a.add(v);
        return a;
    }

}



