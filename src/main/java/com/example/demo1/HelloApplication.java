package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Group root = new Group();
    @Override
    public void start(Stage stage) throws IOException {
        drawHTree(960,540,300,7);
        Scene scene = new Scene(root, 1920, 1080);

        stage.setTitle("Sample application");

        stage.setScene(scene);

        stage.show();


    }
    public static Line drawLine(double x1, double y1, double x2, double y2) {
        Line line = new Line();
        line.setStartX(x1);
        line.setStartY(y1);
        line.setEndX(x2);
        line.setEndY(y2);
        return line;
    }

    public static void drawHTree(double x, double y, double length, int depth) {
        if (depth == 0) return;
        double x0 = x - length / 2;
        double x1 = x + length / 2;
        double y0 = y - length / 2;
        double y1 = y + length / 2;

        root.getChildren().add(drawLine(x0, y0, x0, y1));
        root.getChildren().add(drawLine(x1, y0, x1, y1));
        root.getChildren().add(drawLine(x0, y, x1, y));


        double newLength = length / 2;

        drawHTree(x0, y0, newLength, depth - 1);
        drawHTree(x0, y1, newLength, depth - 1);
        drawHTree(x1, y0, newLength, depth - 1);
        drawHTree(x1, y1, newLength, depth - 1);
    }

    public static void main(String[] args) {
        launch();
    }
}