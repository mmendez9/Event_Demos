package p11;


/*
 * Created by mmendez9 on 4/5/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonArrayDemo extends Application{

    // Create an array of buttons
    int numOfButtons = 10;
    Button[] buttonsArray = new Button[numOfButtons];

    @Override
    public void start(Stage primaryStage) {
        // Get the pane for the scene
        primaryStage.setScene(new Scene(getPane(), 180, 600));

        // Setup the stage
        primaryStage.setTitle("Elevator Buttons");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    protected Pane getPane() {
        Pane pane = new VBox(10);
        pane.setPadding(new Insets(40));

        for (int i = numOfButtons - 1; i >= 0; i--) {

            // Set the button number as text for the button
            buttonsArray[i] = new Button(Integer.toString(i + 1));

            // Set preferred width and style with a light gray background
            buttonsArray[i].setPrefWidth(100);
            buttonsArray[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            // Add the button to the pane and set the handler
            pane.getChildren().add(buttonsArray[i]);
            buttonsArray[i].setOnAction(ButtonHandler);
        }
        return pane;
    }

    // Build an event handler for the buttons
    EventHandler<ActionEvent> ButtonHandler = e -> {
        // Identify the object that caused the event
        Button b = (Button)e.getSource();

        // Read the text field of the object and convert it to an integer
        int i = Integer.parseInt(b.getText());

        // Check the background of the button to a dark red
        buttonsArray[i-1].setStyle("-fx-font: 22 arial; -fx-base: DarkRed");
    };
}
