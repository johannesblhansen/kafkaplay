package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class GameObjectTest {

    public Polygon getView() {
        return view;
    }

    private Polygon view;

    public GameObjectTest() {

        Polygon polygon = new Polygon();
        polygon.setFill(Color.RED);
        polygon.getPoints().addAll(new Double[]{
                9.0, 100.0,
                19.0, 100.0,
                19.0, 110.0,
                9.0, 110.0});
        view = polygon;

    }
}