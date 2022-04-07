package com.example.marbelsproject;

import com.sun.javafx.charts.Legend;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class MainController
{
    @FXML
    private Label setLabel;
    @FXML
    private Label marbelsLabel;
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
    @FXML
    public HBox canvesHBox;
    @FXML
    public Canvas canvas;

    @FXML
    public void onPosButtonClick() throws InterruptedException {


        if (!sX.getText().trim().isEmpty() && !sX.getText().trim().isEmpty() && !sX.getText().trim().isEmpty() && !sX.getText().trim().isEmpty())
        {

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

            setLabel.setVisible(false);
            canvesHBox.setVisible(true);

            GraphicsContext g = canvas.getGraphicsContext2D();
            g.setFill(Color.WHITE);

            //double[] s = new double[]{0, 0};
            //double[] v = new double[]{20, 10};
            //double[] a = new double[]{0 + 3, 9.81 + 3};

            double[] s = new double[] {Double.parseDouble(sX.getText()), Double.parseDouble(sY.getText()) };
            double[] v = new double[] {Double.parseDouble(gX.getText()), Double.parseDouble(gY.getText()) };
            double[] a = new double[] {Double.parseDouble(bX.getText()), 9.81 + Double.parseDouble(bY.getText()) };
            Ball ball = new Ball(a, v, s);

            int runtime = 0;

            while (runtime < 30) {
                ball.nextFrame();
                s = ball.getS();
                double xPos = s[0];
                double yPos = s[1];
                g.fillOval(xPos * 10, yPos * 10, 5, 5);
                /*System.out.println("V: " + Arrays.toString(ball.getV()) +
                        ", S: " + Arrays.toString(ball.getS()) +
                        ", A: " + Arrays.toString(ball.getA()));*/
                //wait(1000);
                runtime++;
            }
        }
        else
            setLabel.setTextAlignment(TextAlignment.CENTER);
            setLabel.setText("Fehlende Eingabe!");
            setLabel.setTextFill(Color.RED);
    }
    public static void wait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}