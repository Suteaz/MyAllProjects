import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.animation.AnimationTimer;
import javafx.animation.FillTransition;

public class Main extends Application {
    private static final int WinSize = 500;
    public static final int CubeSize = 50;
    public static final int Speed = 5;

    private Rectangle cube;

    private int dx = 0;
    private int dy = 0;

    public void start(Stage window) {

        cube = new Rectangle(CubeSize, CubeSize);
        cube.setFill(Color.WHITE);
        cube.setX(WinSize / 2 - CubeSize / 2);
        cube.setY(WinSize / 2 - CubeSize / 2);

        Pane pane = new Pane(cube);
        Scene scene = new Scene(pane, WinSize, WinSize);
        scene.setFill(Color.BLACK);

        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.UP || code == KeyCode.W) {
                dy = -Speed;
            }
            else if (code == KeyCode.DOWN || code == KeyCode.S) {
                dy = Speed;
            }
            else if (code == KeyCode.LEFT || code == KeyCode.A) {
                dx = -Speed;
            }
            else if (code == KeyCode.RIGHT || code == KeyCode.D) {
                dx = Speed;
            }
            if (code == KeyCode.DIGIT1) {
                cube.setFill(Color.RED);
            } else if (code == KeyCode.DIGIT2) {
                cube.setFill(Color.ORANGE);
            } else if (code == KeyCode.DIGIT3) {
                cube.setFill(Color.YELLOW);
            } else if (code == KeyCode.DIGIT4) {
                cube.setFill(Color.GREEN);
            } else if (code == KeyCode.DIGIT5) {
                cube.setFill(Color.CYAN);
            } else if (code == KeyCode.DIGIT6) {
                cube.setFill(Color.BLUE);
            } else if (code == KeyCode.DIGIT7) {
                cube.setFill(Color.PURPLE);
            } else if (code == KeyCode.DIGIT8) {
                cube.setFill(Color.PINK);
            } else if (code == KeyCode.DIGIT9) {
                cube.setFill(Color.CORAL);
            } else if (code == KeyCode.DIGIT0) {
                cube.setFill(Color.WHITE);
            }
        });

        scene.setOnKeyReleased(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.UP || code == KeyCode.DOWN || code == KeywCode.LEFT || code == KeyCode.RIGHT || code == KeyCode.W || code == KeyCode.S || code == KeyCode.A || code == KeyCode.D) {
                dx = 0;
                dy = 0;
            }
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveCube();
            }
        }.start();

        window.setTitle("CubeGame");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
    private void moveCube(){
        double newX = cube.getX() + dx;
        double newY = cube.getY() + dy;
        if (newX >= 0 && newX <= 450){
            cube.setX(newX);
        }
        if (newY >= 0 && newY <= 450){
            cube.setY(newY);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}