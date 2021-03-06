package p4;

/*
 * Created by mmendez9 on 3/22/2016.
 * Button handlers are Lamba expressions
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LambaExpressionDemo extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            VBox pane = new VBox(10);
            pane.setPadding(new Insets(20, 20, 20, 20));

            Button btUp = new Button("▲");
            btUp.setPrefWidth(100);
            btUp.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Button Event");
                    alert.setHeaderText(null);
                    alert.setContentText("Up Button Pressed");

                    alert.showAndWait();
            });

            Button btDown = new Button("▼");
            btDown.setPrefWidth(100);
            btDown.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Button Event");
                alert.setHeaderText(null);
                alert.setContentText("Down Button Pressed");

                alert.showAndWait();
            });

            pane.getChildren().addAll(btUp, btDown);

            Scene scene = new Scene(pane);
            primaryStage.setTitle("E_D4");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }
}




