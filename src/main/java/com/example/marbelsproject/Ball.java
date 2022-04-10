package com.example.marbelsproject;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

class Ball extends Main {
    //Variablen a=Beschleunigung, v=Geschwindigkeit, s=Strecke, delta t
    public double[] a;
    public double[] v;
    public double[] s;
    public float dt = 1/30f;

    //Getter und Setter der Variablen
    public double[] getA() {
        return this.a;
    }

    public void setA(double[] a) {
        this.a = a;
    }

    public double[] getV() {
        return this.v;
    }

    public void setV(double[] v) {
        this.v = v;
    }

    public double[] getS() {
        return this.s;
    }

    public void setS(double[] s) {
        this.s = s;
    }


    //Konstruktor
    public Ball(double[] a, double[] v, double[] s) {
        this.a = a;
        this.v = v;
        this.s = s;
    }
    //Berrechnung der nächsten Position im nächsten Frame
    public void nextS() {
        double[] pos = new double[2];
        pos[0] = s[0] + v[0] * dt + 0.5 * a[0] * (dt * dt);
        pos[1] = s[1] + v[1] * dt + 0.5 * a[1] * (dt * dt);
        setS(pos);
    }

    //Berrechnung der nächsten Geschwindigkeit im nächsten Frame
    public void nextV() {
        double[] vel = new double[2];
        vel[0] = v[0] + a[0] * dt;
        vel[1] = v[1] + a[1] * dt;
        setV(vel);
    }
    //Methode zur Berrechung der Variabelen im nächsten Frame
    public void nextFrame() {
        nextS();
        nextV();
    }
}

