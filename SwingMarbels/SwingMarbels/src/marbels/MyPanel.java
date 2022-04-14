package marbels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    //varíables
    final int PANEL_WIDTH = 900;
    final int PANEL_HEIGHT = 600;
    public static Timer timer;
    public double[] a = new double[] { 0, 9.81 };
    public double[] v;
    public double[] s;
    public float dt = 1/30f;
    double[] pos = new double[2];
    double[] vel = new double[2];


    //getters und setters
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

    public double[] getA() {
        return this.a;
    }

    public void setA(double[] a) {
        this.a = a;
    }


    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        timer = new Timer(1/30, this);
        //panel wird je nach dem timer delay neu gezeichnet
    }

    public void paint(Graphics g) {
        //Kugel wird hier gemalt
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillOval((int) pos[0], (int) pos[1], 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Physikalische Berechnung für den nächstenh Schritt
        pos[0] = s[0] + v[0] * dt + 0.5 * a[0] * (dt * dt);
        pos[1] = s[1] + v[1] * dt + 0.5 * a[1] * (dt * dt);
        vel[0] = v[0] + a[0] * dt;
        vel[1] = v[1] + a[1] * dt;
        setS(pos);
        setV(vel);
        repaint();
    }
}
