package com.example.marbelsproject;

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

public class MainController implements Initializable {
    @FXML
    private Label setLabel;
    @FXML
    private Label marbelsLabel;
    @FXML
    private Label tableTitelLabel;
    @FXML
    private TableView<Ball> posTable;
    @FXML
    public TableColumn<Ball, String> xyCol;
    @FXML
    public TextField sX;
    @FXML
    public TextField sY;
    @FXML
    public TextField gX;
    @FXML
    public TextField gY;
    @FXML
    public HBox canvesHBox;
    @FXML
    public Canvas canvas;

    ObservableList xyPosList = FXCollections.observableArrayList();

    @FXML
    public void onPosButtonClick() {


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

            String sXtest = sX.getText();
            String sYtest = sY.getText();
            String gXtest = gX.getText();
            String gYtest = gY.getText();


            tableTitelLabel.setText("TEST");
            GraphicsContext g = canvas.getGraphicsContext2D();
            g.setFill(Color.WHITE);

            //double[] v = new double[] {Double.parseDouble(sX.getText()), Double.parseDouble(sY.getText()) };
            double[] v = new double[]{20, 10};
            //double[] s = new double[] {Double.parseDouble(gX.getText()), Double.parseDouble(gY.getText()) };
            double[] s = new double[]{0, 0};
            double[] a = new double[]{0, 9.81};
            Ball ball = new Ball(a, v, s);

            for (int i = 0; i <= 29; i++) {
                ball.nextFrame();
                s = ball.getS();
                double xPos = s[0];
                double yPos = s[1];
                String xyString = Arrays.toString(ball.getS());
                g.fillOval(xPos * 10, yPos * 10, 5, 5);
                System.out.println("V: " + Arrays.toString(ball.getV()) +
                        ", S: " + Arrays.toString(ball.getS()) +
                        ", A: " + Arrays.toString(ball.getA()));

                xyPosList.add(xyString);
                System.out.println("TEST" + sXtest + sYtest + gXtest + gYtest);
                System.out.println("TEST2" + v + s + a);

            }
            System.out.println(xyPosList + "TEST2");
        }
        else
            setLabel.setTextAlignment(TextAlignment.CENTER);
            setLabel.setText("Fehlende Eingabe!");
            setLabel.setTextFill(Color.RED);


    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        //xyCol.setCellValueFactory(new PropertyValueFactory<Ball, String>("s"));

        posTable.setItems(xyPosList);
    }

}