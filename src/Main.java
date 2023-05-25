import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

class Main {
    private static List<Triangle> triangleList = new ArrayList<>();
    private static List<Quadrilateral> quadrilateralList = new ArrayList<>();

    public static void main(String[] args) {

        String itemString = "T,3,4,5";
        String pattern = "(T|Q),(\\d+),(\\d+),(\\d+),?(\\d+)?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(itemString);

        try (Scanner input = new Scanner(Paths.get("C:\\Users\\jacob\\IdeaProjects\\Final Exam Lab\\src\\polygons.txt"))) {

            while (input.hasNextLine()) {
                itemString = input.nextLine();
                m = r.matcher(itemString);
                if (m.find()) {

                    System.out.println("\nFound value: " + m.group(0)); // full string
                    System.out.println("Found value: " + m.group(1)); // Q or T
                    System.out.println("Found value: " + m.group(2)); // Num 1
                    System.out.println("Found value: " + m.group(3)); // Num 2
                    System.out.println("Found value: " + m.group(4)); // Num 3
                    System.out.println("Found value: " + m.group(5) + "\n"); // Num 4

                    if (m.group(1).equals("T")) {
                        int t1 = Integer.parseInt(m.group(2));
                        int t2 = Integer.parseInt(m.group(3));
                        int t3 = Integer.parseInt(m.group(4));

                        int[] triangleParams = { t1, t2, t3 };
                        Triangle t = new Triangle(triangleParams);
                        triangleList.add(t);
                        t.calcAngleSum(t.getNumSides());
                        t.sideAverage(t.getTriangleSides());

                    } else if (m.group(1).equals("Q")) {
                        int q1 = Integer.parseInt(m.group(2));
                        int q2 = Integer.parseInt(m.group(3));
                        int q3 = Integer.parseInt(m.group(4));
                        int q4 = Integer.parseInt(m.group(5));

                        int[] quadParams = { q1, q2, q3, q4 };
                        Quadrilateral q = new Quadrilateral(quadParams);
                        quadrilateralList.add(q);
                        q.calcAngleSum(q.getNumSides());
                        q.sideAverage(q.getQuadSides());
                    }
                } else {
                    System.out.println("No matches found");
                }
            }

            System.out.println("\nTriangle Average Side Length: ");
            System.out.println((triangleList.stream().mapToDouble(x -> x.averageOfTriangle()).reduce(0, Double::sum))/2.0);

            System.out.println("Quadrilateral Average Side Length: ");
            System.out.println((quadrilateralList.stream().mapToDouble(x -> x.averageOfQuad()).reduce(0, Double::sum))/3.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}