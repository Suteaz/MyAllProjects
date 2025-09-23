import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.shape.Rectangle;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {
    private final int winWidth = 550;
    private final int winHeight = 1100;
    private Rectangle line;

    @Override
    public void start(Stage primaryStage) {
        try {

            Font font = new Font("Arial", 200);

            Text timeText = new Text(lockTime());
            timeText.setStyle("-fx-fill: white;");
            timeText.setFont(font);
            timeText.setLayoutX(timeText.getBoundsInLocal().getWidth() - 65);
            timeText.setLayoutY(timeText.getBoundsInLocal().getHeight() + 20);
            
            Image bgImage = new Image(getClass().getResourceAsStream("resources/bgimage.jpg"));
            ImageView backgroundImage = new ImageView(bgImage);

            backgroundImage.setFitWidth(winWidth);
            backgroundImage.setFitHeight(winHeight);

            line = new Rectangle(250, 10);
            line.setX(winWidth / 2 - 125);
            line.setY(1075);
            line.setArcWidth(15);
            line.setArcHeight(15);
            line.setFill(Color.WHITE);

            Pane root = new Pane(backgroundImage, timeText, line);

            Scene scene = new Scene(root, winWidth, winHeight);

            primaryStage.setTitle("AseOS");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

            new AnimationTimer() {
                public void handle(long now){
                    timeText.setText(lockTime());
                }
            }.start();

        } catch (Exception e) {
            System.err.println("Ошибка загрузки изображения: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private String lockTime(){
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeString = currentTime.format(formatter);
        String[] parts = timeString.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        String result = String.format("%02d\n%02d", hours, minutes);
        return result;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
