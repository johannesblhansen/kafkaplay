package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    GameObject snake = new GameObject();
    GameObjectTest gameObjectTest = new GameObjectTest();

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Setup
        Pane rootPane = new Pane();
        rootPane.setPrefSize(800, 800);
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        handleKeyPresses(primaryStage);

        //Game objects
        rootPane.getChildren().add(gameObjectTest.getView());
        rootPane.getChildren().add(snake.getView());

        //Game loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                updateGame();
            }
        };
        timer.start();
    }

    public void updateGame() {
        snake.update();
    }

    private void handleKeyPresses(Stage primaryStage) {
        primaryStage.getScene().setOnKeyPressed(keyEvent -> {

            if (keyEvent.getCode() == KeyCode.UP) {
                System.out.println("up");
                snake.setVelocity(0, -1);
            }

            if (keyEvent.getCode() == KeyCode.DOWN) {
                System.out.println("down");
                snake.setVelocity(0, 1);
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {
                System.out.println("left");
                snake.setVelocity(-1, 0);
            }

            if (keyEvent.getCode() == KeyCode.RIGHT) {
                System.out.println("right");
                snake.setVelocity(1, 0);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
