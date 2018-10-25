package Lesson4.homework.task01;

public class Figures {
    private int x1, x2, x3;
    private int y1, y2, y3;


    public Figures(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public Figures(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }


    public double getTrianglePerimetr() {
        double ab = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
        double bc = Math.sqrt(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2));
        double ca = Math.sqrt(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2));
        return ab + bc+ ca;
    }

    public double getRectamglePerimetr() {
        double ab = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
        double bc = Math.sqrt(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2));
        return 2*(ab + bc);
    }

    public double getCirclePerimetr(){
        double ab = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
        return 2*Math.PI*ab;
    }

    public double getCircleArea(){
        double ab = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
        return Math.PI*Math.pow(ab, 2);
    }

    public double getTriangleArea(){
        double ab = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
        double bc = Math.sqrt(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2));
        double ca = Math.sqrt(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2));
        double p = getTrianglePerimetr() / 2;
        return Math.sqrt(p*(p-ab)*(p-bc)*(p-ca));
    }

    public double getRectangleArea(){
        double ab = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
        double bc = Math.sqrt(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2));
        return ab * bc;
    }


}
