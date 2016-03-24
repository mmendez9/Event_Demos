package p7;

/*
 * Created by mmendez9 on 3/24/2016.
 */


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class PolygonDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Define a polygon
        Polygon polygon = new Polygon();
        polygon.setStroke(Color.BLACK);
        polygon.setFill(Color.WHITE);

        // Put the points for the polygon in an observable list
        ObservableList<Double> pointsList = polygon.getPoints();

        // (50, 100)
        pointsList.add(50.0);
        pointsList.add(100.0);

        // (50, 200)
        pointsList.add(50.0);
        pointsList.add(200.0);

        // (250, 200)
        pointsList.add(250.0);
        pointsList.add(200.0);

        // (250, 100)
        pointsList.add(250.0);
        pointsList.add(100.0);

        // (150, 50)
        pointsList.add(150.0);
        pointsList.add(50.0);

        // Create a pane for the polygon
        Pane pane = new Pane();
        pane.getChildren().add(polygon);

        // Create a scene, add the pane, and put the scene on the stage
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Polygon Demo");
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

            if (polygon.contains(p1))
                polygon.setFill(Color.RED);
            else
                polygon.setFill(Color.BLUE);
        });
    }
}