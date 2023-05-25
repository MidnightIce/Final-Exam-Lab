// Created By Aaliyah Creech
// Created on December 16, 2022
// CSIS 3701: Programming and Problem-Solving
// YSU 2022

import java.util.ArrayList;

public abstract class Polygon {
    protected int numSides;

    protected  int calcAngleSum(int num) {
        int sum = ((num - 2) * 180);
        System.out.println("Sum of the angles: " + sum);
        return sum;
    }

    protected void sideAverage(ArrayList<Integer> list) {
        double average = 0;
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }
        average = total / list.size();
        System.out.println("Average side length: " + average);
    }

    protected int getNumSides() {
        return numSides;
    }
}
