import java.util.ArrayList;

class Triangle extends Polygon {

    private ArrayList<Integer> sideLengths = new ArrayList<Integer>();
    private int one;
    private int two;
    private int three;
    private double sum = 0;
    private double average = 0;

    public Triangle(int[] triangle) {
        numSides = 3;
        one = triangle[0];
        two = triangle[1];
        three = triangle[2];

        for (int i = 0; i < triangle.length; i++) {
            sideLengths.add(triangle[i]);
            sum += triangle[i];
        }
        average = sum/3;
    }
    public double averageOfTriangle(){
        return average;
    }

    public ArrayList<Integer> getTriangleSides() {
        return this.sideLengths;
    }
}