import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;
import javafx.scene.control.*;
public class Main extends Application {
    public static boolean def = true;
    @Override
    public void start(Stage primaryStage) {
        Label distance_label = new Label("Distance (in kilometers)");
        distance_label.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        //
        TextField distance = new TextField();
        distance.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        distance.setPrefSize(150, 50);
        distance.setMaxSize(150, 50);
        HBox distanceBox = new HBox(10, distance, distance_label);
        //
        Label speed_label = new Label("Speed (in km/h)");
        speed_label.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        //
        TextField speed = new TextField();
        speed.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        speed.setPrefSize(150, 50);
        speed.setMaxSize(150, 50);
        HBox speedBox = new HBox(10, speed, speed_label);
        //
        Label res_label = new Label("Result (in minutes)");
        res_label.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        //
        TextField res = new TextField();
        res.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        res.setPrefSize(150, 50);
        res.setMaxSize(150, 50);
        HBox resBox = new HBox(10, res, res_label);
        //
        Button button = new Button("Get result");
        button.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        button.setPrefSize(150, 60);
        button.setOnAction(e -> {
            double num_distance = Double.parseDouble(distance.getText());
            double num_speed = Double.parseDouble(speed.getText());
            int num_time = (int)((num_distance / num_speed) * 60);
            res.setText(String.valueOf(num_time));
        });
        VBox root = new VBox(10, distanceBox, speedBox, resBox,button);
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(450);
        primaryStage.setHeight(280);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}