package com.lab6.lab6;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    Canvas fig;
    @FXML
    Spinner<Integer> nrOfDots;

    @FXML
    StackPane figHolder;

    @FXML
    public void initialize()
    {
        nrOfDots.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,1,1));

        fig.widthProperty().bind(figHolder.widthProperty());
        fig.heightProperty().bind(figHolder.heightProperty());
    }

    @FXML
    protected void CreateNewGame() {
        int points = nrOfDots.getValue();
        var height = fig.getHeight();
        var width = fig.getWidth();

        double radius = height < width ? height : width;
        radius = radius / 1.15;

        GraphicsContext gc = fig.getGraphicsContext2D() ;
        gc.clearRect(0, 0, fig.getWidth(), fig.getHeight());

        gc.setFill(Color.DARKRED);

        double CircleX = (width-radius)/2;
        double CircleY = (height-radius)/2;


        double Radius = fig.getWidth() - 2 * CircleX;
        Radius = Radius / 2;

        List<Point> pointsList = new ArrayList<>();

        double slice = 2 * Math.PI / points;
        for (int i = 0; i < points; i++)
        {
            double angle = slice * i;

            double centerX = fig.getWidth() / 2;
            double centerY = fig.getHeight() / 2;

            double PozX = Radius * Math.cos(angle) + centerX - 5;
            double PozY = Radius * Math.sin(angle) + centerY - 5;

            gc.fillOval( PozX,  PozY, 10, 10);

            pointsList.add(new Point(PozX + 5, PozY + 5));
        }

        gc.setLineWidth(0.2);
        for(int i = 0; i < pointsList.size(); i++)
        {
            for(int j = 0; j < pointsList.size(); j++)
            {
                if(i != j)
                {
                    gc.strokeLine(pointsList.get(i).getX(), pointsList.get(i).getY(),
                            pointsList.get(j).getX(), pointsList.get(j).getY());
                }
            }
        }
    }
}