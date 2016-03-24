package p6;

/*
 * Created by mmendez9 on 3/24/2016.
 */

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MouseDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final double CIRCLE_X = 100;
        final double CIRCLE_Y = 100;
        final double CIRCLE_R = 50;

        // Define a circle
        Circle circle = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLE_R);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        // Create a pane for the circle
        Pane pane = new Pane();
        pane.getChildren().add(circle);

        // Create a scene, add the pane, and put the scene on the stage
        Scene scene = new Scene(pane, CIRCLE_X * 2, CIRCLE_Y * 2);
        primaryStage.setTitle("Hot or Cold");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Event handler when the mouse is moved on the pane
        pane.setOnMouseMoved(e -> {
            // Where is the mouse?
            // System.out.println("x:" + (int)e.getSceneX() + " y:" + (int)e.getSceneY());

            // The mouse is at p1
            Point2D p1 = new Point2D(e.getSceneX(), e.getSceneY());

            // If inside the circle, make it red (hot)
            // If outside the circle, make it blue (cold)

            // One way to find out if the point is in the circle
            // Find the distance from p1 to p2

            // The center of the circle is at p2
            Point2D p2 = new Point2D(CIRCLE_X, CIRCLE_Y);

            double distance = p1.distance(p2);
            if (distance < CIRCLE_R)
                circle.setFill(Color.RED);
            else
                circle.setFill(Color.BLUE);

            // An easier way to find out if the point is in the circle
            if (circle.contains(p1))
                circle.setFill(Color.RED);
            else
                circle.setFill(Color.BLUE);
        });
    }
}
