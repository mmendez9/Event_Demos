package p9;

/**
 *
 * Created by mmendez9 on 3/24/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RadioButton_CheckBox_Demo extends Application {

    // Create text here so it can be changed
    private Text text = new Text("Click on the Buttons and Boxes");

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set a font for the text
        text.setFont(Font.font("Times", 20));

        // Define three radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");

        // Put the radio buttons in a group
        ToggleGroup tg1 = new ToggleGroup();
        rbRed.setToggleGroup(tg1);
        rbGreen.setToggleGroup(tg1);
        rbBlue.setToggleGroup(tg1);

        // Define two check boxes
        CheckBox cbxBold = new CheckBox("Bold");
        CheckBox cbxItalic = new CheckBox("Italic");

        // Define a VBox pane for the radio buttons
        VBox pane1 = new VBox(10);
        pane1.setAlignment(Pos.CENTER_LEFT);
        pane1.setPadding(new Insets(10, 10, 10, 10));
        pane1.getChildren().addAll(rbRed, rbGreen, rbBlue);

        // Define a VBox pane for the check boxes
        VBox pane3 = new VBox(10);
        pane3.setAlignment(Pos.CENTER_LEFT);
        pane3.setPadding(new Insets(10, 10, 10, 10));
        pane3.getChildren().addAll(cbxBold, cbxItalic);

        // Define a pane with text in it
        StackPane pane2 = new StackPane();
        pane2.getChildren().add(text);

        // Define a main pane for the other panes
        BorderPane pane = new BorderPane();
        pane.setLeft(pane1);
        pane.setCenter(pane2);
        pane.setRight(pane3);

        // set different options for the text's font
        Font fontBoldItalic = Font.font("Times", FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Times", FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times", FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Times", FontWeight.NORMAL, FontPosture.REGULAR, 20);

        // Set different options for the text's color
        Color colorRed = Color.RED;
        Color colorGreen = Color.GREEN;
        Color colorBlue = Color.BLUE;

        // Set action events
        EventHandler<ActionEvent> handler = e -> {
            if (cbxBold.isSelected() && cbxItalic.isSelected()) {
                text.setFont(fontBoldItalic);
            }
            else if (cbxBold.isSelected()) {
                text.setFont(fontBold);
            }
            else if (cbxItalic.isSelected()) {
                text.setFont(fontItalic);
            }
            else
                text.setFont(fontNormal);

            if (rbRed.isSelected())
                text.setFill(colorRed);
            else if (rbGreen.isSelected())
                text.setFill(colorGreen);
            else if (rbBlue.isSelected())
                text.setFill(colorBlue);
            else
                text.setFill(Color.BLACK);
        };

        cbxBold.setOnAction(handler);
        cbxItalic.setOnAction(handler);
        rbBlue.setOnAction(handler);
        rbGreen.setOnAction(handler);
        rbRed.setOnAction(handler);

        // Add the main pane to a scene
        Scene scene = new Scene(pane, 500, 250);

        // Setup the stage and put the scene on it
        primaryStage.setTitle("Radio Buttons and Check Boxes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Close Event");
        alert.setHeaderText(null);
        alert.setContentText("So long and thanks for all the fish");

        alert.showAndWait();
    }
}