package sample;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameObject {

    private Polygon view;
    private Point2D velocity = new Point2D(1, 0);

    private int size = 100;
    private List<Coordinate> coordinateStack = new ArrayList<>();

    public GameObject() {
        Polygon polygon = new Polygon();
        polygon.setFill(Color.RED);
        drawCoordinates();
        view = polygon;
    }

    public Node getView() {
        return view;
    }

    public void update() {
        double valueOfCurrentX = view.getTranslateX() + velocity.getX();
        double valueOfCurrentY = view.getTranslateY() + velocity.getY();

        //update tail
        coordinateStack.add(new Coordinate(valueOfCurrentX, valueOfCurrentY));
        while (coordinateStack.size() > size) {
            coordinateStack.remove(0);
        }
        view.getPoints().clear();
        drawCoordinates();

        view.setTranslateX(valueOfCurrentX);
        view.setTranslateY(valueOfCurrentY);

    }

    public void setVelocity(int x, int y) {
        if (velocity.getX() == x && velocity.getY() == y) {
            System.out.println("ignored");
        } else {
            System.out.println("new point");
            velocity = new Point2D(x, y);
        }
    }

    public void drawCoordinates() {
        coordinateStack.forEach(this::drawCoordinate);
    }

    private void drawCoordinate(Coordinate coordinate){

        double initialX, initialY;
        initialX = coordinate.getX();
        initialY = coordinate.getY();

        Double[] es = {
                initialX, initialY,
                initialX + 10.0, initialY,
                initialX + 10.0, initialY + 10.0,
                initialX, initialY + 10.0};
        view.getPoints().addAll(Arrays.asList(es));
    }
}