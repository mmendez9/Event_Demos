package p12;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * Created by mmendez9 on 4/5/2016.
 */

public class TimerDemo  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Initialize two circles in an array
        Circle[] circle = new Circle[2];

        circle[0] = new Circle();
        circle[0].setRadius(50);
        circle[0].setStroke(Color.BLACK);
        circle[0].setFill(Color.RED);

        circle[1] = new Circle();
        circle[1].setRadius(50);
        circle[1].setStroke(Color.BLACK);
        circle[1].setFill(Color.DARKRED.darker());

        // Create an HBox pane for the circles
        HBox pane = new HBox(20);
        pane.setStyle("-fx-background-color: grey");
        pane.setPadding(new Insets(20));
        pane.getChildren().addAll(circle[0], circle[1]);

        // Create a scene and put in on the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("DANGER: RR Xing");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create a handler to toggle the lights
        EventHandler<ActionEvent> eventHandler = e -> {
            if (circle[0].getFill() == Color.RED) {
                circle[0].setFill(Color.DARKRED.darker());
                circle[1].setFill(Color.RED);
            }
            else {
                circle[0].setFill(Color.RED);
                circle[1].setFill(Color.DARKRED.darker());
            }
        };

        // Create an animation to trigger an event every half-second
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
}