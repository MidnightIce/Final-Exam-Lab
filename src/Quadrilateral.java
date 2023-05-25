// Created By Aaliyah Creech
// Created on December 16, 2022
// CSIS 3701: Programming and Problem-Solving
// YSU 2022

import java.util.ArrayList;

public class Quadrilateral extends Polygon {

    private ArrayList<Integer> sideLengths = new ArrayList<Integer>();
    private int one;
    private int two;
    private int three;
    private int four;
    private double sum = 0;
    private double average = 0;

    public Quadrilateral(int[] quad) {
        numSides = 4;
        one = quad[0];
        two = quad[1];
        three = quad[2];
        four = quad[3];

        for (int i = 0; i < quad.length; i++) {
            sideLengths.add(quad[i]);
            sum += quad[i];
        }
        average = sum/4;
    }
    public double averageOfQuad(){
        return average;
    }

    public ArrayList<Integer> getQuadSides() {
        return this.sideLengths;
    }

}

