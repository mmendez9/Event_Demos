package p8;

/*
 * Created by mmendez9 on 3/24/2016.
 */


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SliderDemo extends Application {

    // Declare four sliders
    static Slider slRed, slGreen, slBlue, slOpacity;

    // Declare a circle
    static Circle circle;

    @Override
    public void start(Stage stage) throws Exception {
        // Initialize four sliders with listeners scaled 0 to 1
        slRed = new Slider();
        slRed.setMax(1);
        slRed.valueProperty().addListener(ov -> CircleColor());

        slGreen = new Slider();
        slGreen.setMax(1);
        slGreen.valueProperty().addListener(ov -> CircleColor());

        slBlue = new Slider();
        slBlue.setMax(1);
        slBlue.valueProperty().addListener(ov -> CircleColor());

        slOpacity = new Slider();
        slOpacity.setMax(1);
        slOpacity.setValue(1);
        slOpacity.valueProperty().addListener(ov -> CircleColor());

        // Create four labels for the slider
        Label lbRed = new Label("Red");
        lbRed.prefWidth(50);

        Label lbGreen = new Label("Green");
        lbGreen.prefWidth(50);

        Label lbBlue = new Label("Blue");
        lbBlue.prefWidth(50);

        Label lbOpacity = new Label("Opacity");
        lbOpacity.prefWidth(50);

        // Create a grid pane for the labels and the sliders
        GridPane pane1 = new GridPane();
        pane1.setAlignment(Pos.BOTTOM_CENTER);
        pane1.setPadding(new Insets(20, 20, 20, 20));
        pane1.setHgap(10);
        pane1.setVgap(10);

        pane1.addRow(0, lbRed, slRed);
        pane1.addRow(1, lbGreen, slGreen);
        pane1.addRow(2, lbBlue, slBlue);
        pane1.addRow(3, lbOpacity, slOpacity);

        // Initialize a circle in a stack pane
        StackPane pane2 = new StackPane();
        circle = new Circle();
        circle.setRadius(50);
        circle.setFill(Color.BLACK);
        pane2.getChildren().add(circle);

        // Add the circle and slider panes to a VBox
        VBox pane3 = new VBox();
        pane3.setPadding(new Insets(20, 20, 20, 20));
        pane3.getChildren().addAll(pane2, pane1);

        // Add the main pane to a scene
        Scene scene = new Scene(pane3, 300, 250);

        // Setup the stage and put the scene on it
        stage.setTitle("Sliders and Color Mixer");
        stage.setScene(scene);
        stage.show();
    }

    private static void CircleColor() {

        // Get the new color from the four sliders
        double redValue = slRed.getValue();
        double greenValue = slGreen.getValue();
        double blueValue = slBlue.getValue();
        double opacityValue = slOpacity.getValue();
        Color newColor = new Color(redValue, greenValue, blueValue, opacityValue);

        circle.setFill(newColor);
    }

}