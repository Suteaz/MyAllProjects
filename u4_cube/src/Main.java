import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import java.util.Random;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Main extends Application {
    private Pane pane;
    private static final int cubeSize = 50;
    private static final int winSize = 500;
    private Rectangle userCube;;
    private Rectangle redCube1;
    private Rectangle redCube2;
    private Rectangle redCube3;
    private int randomX;
    private int userCubeSpeed = 5;
    private int dx = 0;
    private int redCubeSpeed = 3;
    private boolean isPaused = false;
    private int score = 0;
    private int d3 = 0;
    private static Random rand = new Random();
    public void start(Stage win) {
        Font scoreFont = new Font("Arial", 36);

        Label scoreText = new Label("Score: " + score);
        scoreText.setFont(scoreFont);
        scoreText.setStyle("-fx-text-fill: white;");
        scoreText.setLayoutX(10);
        scoreText.setLayoutY(scoreText.getBoundsInLocal().getWidth() + 10);

        Label defeatLabel = new Label("Defeat!");
        defeatLabel.setFont(scoreFont);
        defeatLabel.setStyle("-fx-text-fill: #ffffff;");
        defeatLabel.setLayoutX(250 - 60);
        defeatLabel.setLayoutY(250 - 20);
        defeatLabel.setVisible(false);

        userCube = new Rectangle(cubeSize, cubeSize);
        userCube.setArcWidth(15);
        userCube.setArcHeight(15);

        redCube1 = new Rectangle(cubeSize, cubeSize);
        redCube1.setArcWidth(15);
        redCube1.setArcHeight(15);
        redCube2 = new Rectangle(cubeSize, cubeSize);
        redCube2.setArcWidth(15);
        redCube2.setArcHeight(15);
        redCube3 = new Rectangle(cubeSize, cubeSize);
        redCube3.setArcWidth(15);
        redCube3.setArcHeight(15);

        userCube.setFill(Color.BLUE);

        redCube1.setFill(Color.RED);
        redCube2.setFill(Color.RED);
        redCube3.setFill(Color.RED);

        userCube.setX(winSize / 2 - cubeSize / 2);
        userCube.setY(450);

        randomX = rand.nextInt(winSize - cubeSize);
        redCube1.setX(randomX);
        redCube1.setY(0);
        randomX = rand.nextInt(winSize - cubeSize);
        redCube2.setX(randomX);
        redCube2.setY(0);
        randomX = rand.nextInt(winSize - cubeSize);
        redCube3.setX(randomX);
        redCube3.setY(0);
        pane = new Pane(userCube, redCube1, redCube2, redCube3, scoreText, defeatLabel);
        pane.setStyle("-fx-background-color: #000000");
        Scene scene = new Scene(pane, winSize, winSize);
        scene.setFill(Color.BLACK);

        scene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();
            if (key == KeyCode.A) {
                dx = -userCubeSpeed;
            } else if (key == KeyCode.D) {
                dx = userCubeSpeed;
            } else if (key == KeyCode.ESCAPE) {
                if (isPaused) {
                    isPaused = false;
                } else if (!isPaused) {
                    isPaused = true;
                }
            }
        });

        scene.setOnKeyReleased(event -> {
            KeyCode key = event.getCode();
            if (key == KeyCode.A || key == KeyCode.D) {
                dx = 0;
            }
        });

        win.setScene(scene);
        win.setTitle("Cube");
        win.setResizable(false);
        win.show();
        new AnimationTimer() {
            public void handle(long now) {
                if (!isPaused) {
                    moveUserCube();
                    moveRedCube();
                    scoreText.setText("Score: " + score);
                    if (checkCollisions()) {
                        this.stop();
                        defeatLabel.setVisible(true);
                    }
                }
            }
        }.start();
    }
    private boolean checkCollisions(){
        Bounds playerBounds = userCube.getBoundsInLocal();
        for (Rectangle redCube : new Rectangle[]{redCube1, redCube2, redCube3}) {
            if (playerBounds.intersects(redCube.getBoundsInParent())) {
                return true; // Есть столкновение
            }
        }
        return false;
    }
    private void resetRedCube(Rectangle cube) {
        d3++;
        if (d3 >= 3){
            score++;
            d3 = 0;
        }
        cube.setX(rand.nextInt(winSize - cubeSize));
        cube.setY(0);
    }
    private void moveUserCube(){
        double newX = userCube.getX() + dx;
        if (newX < 450 && newX >= 0){
            userCube.setX(newX);
        }
    }
    private void moveRedCube(){
        moveSingleCube(redCube1);
        moveSingleCube(redCube2);
        moveSingleCube(redCube3);
    }
    private void moveSingleCube(Rectangle cube){
        if (cube.getY() <= winSize) {
            cube.setY(cube.getY() + redCubeSpeed);
        } else {
            resetRedCube(cube);
        }
    }
    private void gameRestart(){
        isPaused = false;
        resetRedCube(redCube1);
        resetRedCube(redCube2);
        resetRedCube(redCube3);
    }
    public static void main(String[] args) {
        launch(args);
    }
}