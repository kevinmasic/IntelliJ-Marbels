package com.example.marbelsproject;
//awesome
import java.util.ArrayList;
import java.util.Arrays;

class Main {

    //Kevin stinkt
    //abcdefg
    public static void main(String[] args) {

        ArrayList<Double> xPosList = new ArrayList<>();
        ArrayList<Double> yPosList = new ArrayList<>();


        double[] v = new double[] { 20, 10 };
        double[] s = new double[] { 0, 0 };
        double[] a = new double[] { 0, 9.81 };
        Ball ball = new Ball(a, v, s);

        for (int i = 0; i <= 29; i++) {
            ball.nextFrame();
            s = ball.getS();
            double xPos = s[0];
            double yPos = s[1];
            System.out.println("V: " + Arrays.toString(ball.getV()) +
                    ", S: " + Arrays.toString(ball.getS()) +
                    ", A: " + Arrays.toString(ball.getA()));

            xPosList.add(xPos);
            yPosList.add(yPos);
            System.out.println( xPosList+ "Test");
            System.out.println( yPosList+ "TEST2");
        }
    }
}