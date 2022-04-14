package marbels;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    //Alle Input Deklerationen
    MyPanel panel;
    JButton buttonAtt;
    JLabel sLabel;
    JLabel vLabel;
    JLabel aLabel;
    JLabel header;
    JTextField textFieldsX;
    JTextField textFieldsY;
    JTextField textFieldvX;
    JTextField textFieldvY;
    JTextField textFieldaX;
    JTextField textFieldaY;
    Font fieldFont = new Font("Arial", Font.PLAIN, 30);

    //Border Reset
    Border textline = new LineBorder(Color.black);
    Border textmargin = new EmptyBorder(5, 15, 5, 15);
    Border textcompound = new CompoundBorder(textline, textmargin);

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        //Canvas
        panel = new MyPanel();
        //Inputs
        JPanel inputPanel = new JPanel();
        //Empty Panels for borders
        JPanel emptyPanel1 = new JPanel();
        JPanel emptyPanel2 = new JPanel();
        JPanel emptyPanel3 = new JPanel();

        //panel styling
        inputPanel.setBackground(Color.white);
        emptyPanel1.setBackground(Color.white);
        emptyPanel2.setBackground(Color.white);
        emptyPanel3.setBackground(Color.white);
        inputPanel.setPreferredSize(new Dimension(500,60));
        emptyPanel1.setPreferredSize(new Dimension(50,80));
        emptyPanel2.setPreferredSize(new Dimension(50,50));
        emptyPanel3.setPreferredSize(new Dimension(50,50));

        //header in empty1
        header = new JLabel("Murmelbahn");
        header.setFont(new Font("Arial", Font.PLAIN, 60));
        emptyPanel1.add(header);

        //Labels für die Inputs
        sLabel = new JLabel("Startposition (X, Y): ");
        vLabel = new JLabel("Startgeschwindigkeit (X, Y): ");
        aLabel = new JLabel("Startbeschleunigung (X, Y): ");

        //Position Eingaben
        textFieldsX = new JTextField();
        textFieldsX.setPreferredSize(new Dimension(50,50));
        textFieldsX.setFont(fieldFont);
        textFieldsX.setBackground(Color.white);
        textFieldsX.setForeground(Color.black);
        textFieldsX.setColumns(1);
        textFieldsX.setBorder(textcompound);

        textFieldsY = new JTextField();
        textFieldsY.setPreferredSize(new Dimension(50,50));
        textFieldsY.setFont(fieldFont);
        textFieldsY.setBackground(Color.white);
        textFieldsY.setForeground(Color.black);
        textFieldsY.setColumns(1);
        textFieldsY.setBorder(textcompound);

        //Velocity Eingaben
        textFieldvX = new JTextField();
        textFieldvX.setPreferredSize(new Dimension(50,50));
        textFieldvX.setFont(fieldFont);
        textFieldvX.setBackground(Color.white);
        textFieldvX.setForeground(Color.black);
        textFieldvX.setColumns(1);
        textFieldvX.setBorder(textcompound);

        textFieldvY = new JTextField();
        textFieldvY.setPreferredSize(new Dimension(50,50));
        textFieldvY.setFont(fieldFont);
        textFieldvY.setBackground(Color.white);
        textFieldvY.setForeground(Color.black);
        textFieldvY.setColumns(1);
        textFieldvY.setBorder(textcompound);

        //Beschleunigung Eingaben
        textFieldaX = new JTextField();
        textFieldaX.setPreferredSize(new Dimension(50,50));
        textFieldaX.setFont(fieldFont);
        textFieldaX.setBackground(Color.white);
        textFieldaX.setForeground(Color.black);
        textFieldaX.setColumns(1);
        textFieldaX.setBorder(textcompound);

        textFieldaY = new JTextField();
        textFieldaY.setPreferredSize(new Dimension(50,50));
        textFieldaY.setFont(fieldFont);
        textFieldaY.setBackground(Color.white);
        textFieldaY.setForeground(Color.black);
        textFieldaY.setColumns(1);
        textFieldaY.setBorder(textcompound);
        textFieldaY.setBorder(textcompound);

        //Start Button
        buttonAtt = new JButton("Start");
        buttonAtt.addActionListener(this);
        buttonAtt.setPreferredSize(new Dimension(160,50));
        buttonAtt.setFont(fieldFont);
        buttonAtt.setForeground(Color.BLACK);
        buttonAtt.setBackground(Color.RED);
        Border line = new LineBorder(Color.RED);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        buttonAtt.setBorder(compound);

        //inputs werden dem panel übergeben
        inputPanel.add(sLabel);
        inputPanel.add(textFieldsX);
        inputPanel.add(textFieldsY);
        inputPanel.add(vLabel);
        inputPanel.add(textFieldvX);
        inputPanel.add(textFieldvY);
        inputPanel.add(aLabel);
        inputPanel.add(textFieldaX);
        inputPanel.add(textFieldaY);
        inputPanel.add(buttonAtt);

        //frame wird gefüllt mit panels
        this.add(panel, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.PAGE_END);
        this.add(emptyPanel1, BorderLayout.PAGE_START);
        this.add(emptyPanel2, BorderLayout.LINE_START);
        this.add(emptyPanel3, BorderLayout.LINE_END);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    //button action
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAtt) {
            double[] enteredPos = new double[2];
            double[] enteredVel = new double[2];
            double[] enteredA = new double[2];
            enteredPos[0]  = Double.parseDouble(textFieldsX.getText());
            enteredPos[1]  = Double.parseDouble(textFieldsY.getText());
            enteredVel[0]  = Double.parseDouble(textFieldvX.getText());
            enteredVel[1]  = Double.parseDouble(textFieldvY.getText());
            enteredA[0]  = Double.parseDouble(textFieldaX.getText());
            enteredA[1]  = Double.parseDouble(textFieldaY.getText() + 9.81);
            panel.setS(enteredPos);
            panel.setV(enteredVel);
            panel.setA(enteredA);
            MyPanel.timer.start();

            //werte aus den Input Feldern werden den Formeln in MyPanel übergeben.
            //Mit diesen Werten wird nun gearbeitet
        }
    }
}
