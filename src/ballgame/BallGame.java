/*
Author: Amir Saad
This program is a game where the user has to navigate through the bars and balls without getting hit.
*/

package ballgame;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BallGame extends Application {

    private Circle circle;
    private Circle circle1, circle2, circle3, circle4;
    private Rectangle rect, rect2, rect3, rect4;
    private Pane pane;
    private Scene scene;
    private PathTransition pt, pt2, pt3, pt4;
    //Declare nodes

    @Override
    public void start(Stage primaryStage) {
        circle = new Circle(50);
        pane = new Pane();
        circle.setFill(Color.ORANGE);
        //Create nodes

        pane.getChildren().add(circle);

        circle.setOnKeyPressed(new key());
        //register the KeyEvent handler object

        pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(rect = new Rectangle(100, 100, 200, 800));
        pt.setNode(circle1 = new Circle(100, Color.BLUE));
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();
        //Create a path transition animation for the circle1 to around rectangle1

        pt2 = new PathTransition();
        pt2.setDuration(Duration.millis(2500));
        pt2.setPath(rect2 = new Rectangle(600, 100, 200, 800));
        pt2.setNode(circle2 = new Circle(100, Color.BLUE));
        pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt2.setCycleCount(Timeline.INDEFINITE);
        pt2.setAutoReverse(true);
        pt2.play();
        //Create a path transition animation for the circle2 to around rectangle2

        pt3 = new PathTransition();
        pt3.setDuration(Duration.millis(2000));
        pt3.setPath(rect3 = new Rectangle(1100, 100, 200, 800));
        pt3.setNode(circle3 = new Circle(100, Color.BLUE));
        pt3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt3.setCycleCount(Timeline.INDEFINITE);
        pt3.setAutoReverse(true);
        pt3.play();
        //Create a path transition animation for the circle3 to round rectangle3

        pt4 = new PathTransition();
        pt4.setDuration(Duration.millis(1500));
        pt4.setPath(rect4 = new Rectangle(1600, 100, 200, 800));
        pt4.setNode(circle4 = new Circle(100, Color.BLUE));
        pt4.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt4.setCycleCount(Timeline.INDEFINITE);
        pt4.setAutoReverse(true);
        pt4.play();
        pane.getChildren().addAll(circle1, rect, circle2, rect2, circle3, rect3, circle4, rect4);
        //Create a path transition animation for the circle4 to round rectangle4

        scene = new Scene(pane, 3200, 1000);
        primaryStage.setTitle("KeyEventDemo");
        primaryStage.setScene(scene);
        primaryStage.show();

        circle.requestFocus();

    }

    class key implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case DOWN:
                    if (circle.getCenterY() < scene.getHeight() - circle.getRadius()) {
                        circle.setCenterY(circle.getCenterY() + 10);
                    }

                    break;
                case UP:
                    if (circle.getCenterY() > circle.getRadius()) {
                        circle.setCenterY(circle.getCenterY() - 10);
                    }

                    break;
                case LEFT:
                    if (circle.getCenterX() > circle.getRadius()) {
                        circle.setCenterX(circle.getCenterX() - 10);
                    }

                    break;
                case RIGHT:
                    if (circle.getCenterX() < scene.getWidth() - circle.getRadius()) {
                        circle.setCenterX(circle.getCenterX() + 10);
                    }

                    break;

            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
