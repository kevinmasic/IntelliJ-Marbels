package com.example.marbelsproject;


import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import java.util.Arrays;


public class MainController
{
    //Erstellung der FXML Elemente
    @FXML
    private Label setLabel;
    @FXML
    private Label marbelsLabel;

    //Textfelder zur eingabe der Werte, um die Simulation zu berechnen
    @FXML
    public TextField sX;
    @FXML
    public TextField sY;
    @FXML
    public TextField gX;
    @FXML
    public TextField gY;
    @FXML
    public TextField bX;
    @FXML
    public TextField bY;

    //Erstellung eine Canvas zu Darstellung der Flugbahn
    @FXML
    public HBox canvesHBox;
    @FXML
    public Canvas canvas;


    //OnClick Event zur Berechnung der Werte und grafischen Darstellung der Flugbahn
    @FXML
    public void onPosButtonClick() {

    //OnClick Event wird nur ausgeführt, wenn alle Textfelder in der GUI ausgefüllt wurden
        if (!sX.getText().trim().isEmpty() && !sY.getText().trim().isEmpty() &&
                !gX.getText().trim().isEmpty() && !gY.getText().trim().isEmpty() &&
                !bX.getText().trim().isEmpty() && !bY.getText().trim().isEmpty())
        {
    //Spielerei zum Farbwechsel in der GUI(noch unvollständig)
            final Animation animation = new Transition() {
                {
                    setCycleDuration(Duration.millis(1000));
                    setInterpolator(Interpolator.EASE_OUT);
                }

                @Override
                protected void interpolate(double frac) {
                    Color vColor = new Color(1, 0, 0, 1 - frac);
                    marbelsLabel.setBackground(new Background(new BackgroundFill(vColor, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            };
            animation.play();


    //Meldung für den Nutzer werden ausgebledndet und das Canvas wird sichtbar
            setLabel.setVisible(false);
            canvesHBox.setVisible(true);

            GraphicsContext g = canvas.getGraphicsContext2D();
            g.setFill(Color.WHITE);

    //Positions-, Gechwindigkeits- und Beschleunigungswerte, welche aus der Eingabe des Benutzers in der GUI aufgenommen werden
            double[] s = new double[] {Double.parseDouble(sX.getText()), Double.parseDouble(sY.getText()) };
            double[] v = new double[] {Double.parseDouble(gX.getText()), Double.parseDouble(gY.getText()) };
            double[] a = new double[] {Double.parseDouble(bX.getText()), 9.81 + Double.parseDouble(bY.getText()) };
            Ball ball = new Ball(a, v, s);

    //Festlegung von dt
            int runtime = 0;
    //Berechnung der Werte und Daratellung der Positionen für jeden festgelegten Frame
    //Ausgabe der Werte in der Konsole
            while (runtime < 30) {
                ball.nextFrame();
                s = ball.getS();
                double xPos = s[0];
                double yPos = s[1];
    //Setzen der Kugel für den jeweiligen Frame(mulipliziert mit einer Konstanten, da die grafische Darstellung sonst zu klein wäre)
                g.fillOval(xPos * 10, yPos * 10, 5, 5);

                System.out.println("V: " + Arrays.toString(ball.getV()) +
                        ", S: " + Arrays.toString(ball.getS()) +
                        ", A: " + Arrays.toString(ball.getA()));
                runtime++;
            }
        }
    //Fehlermeldung bei nicht-Erfüllung der if Bedingung
        else
            setLabel.setTextAlignment(TextAlignment.CENTER);
            setLabel.setText("Fehlende Eingabe!");
            setLabel.setTextFill(Color.RED);
    }
}