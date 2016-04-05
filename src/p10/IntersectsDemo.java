package p10;

/*
 * Created by mmendez9 on 4/5/2016.
 */


import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class IntersectsDemo extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        final double CIRCLE_X = 75;
        final double CIRCLE_Y = 75;
        final double CIRCLE_R = 50;

        final double RECT_X = 150;
        final double RECT_Y = 225;
        final double RECT_WIDTH = 100;
        final double RECT_HEIGHT = 50;

        // Define a circle
        Circle circle = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLE_R);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        // Define a rectangle
        Rectangle rectangle =
                new Rectangle(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        // Create a pane for the circle and the rectangle
        Pane pane = new Pane();
        pane.getChildren().addAll(circle, rectangle);

        // Create a scene, add the pane, and put the scene on the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Intersecting?");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Event handler when the mouse is dragged on the pane
        pane.setOnMouseDragged(e -> {
            // Where is the mouse?
            // System.out.println("x:" + (int)e.getSceneX() + " y:" + (int)e.getSceneY());

            // The mouse is at p1
            Point2D p1 = new Point2D(e.getSceneX(), e.getSceneY());

            // Move the circle by following the mouse when dragged
            circle.setCenterX(p1.getX());
            circle.setCenterY(p1.getY());

            // Is the circle and rectangle intersecting?
            if (Shape.intersect(circle, rectangle).getBoundsInLocal().isEmpty())
                rectangle.setFill(Color.WHITE); // not intersecting
            else
                rectangle.setFill(Color.RED); // intersecting
        });
    }
}