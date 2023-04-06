package com.lab6.lab6;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.util.Pair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class HelloController {
    @FXML
    Canvas fig;
    @FXML
    Spinner<Integer> nrOfDots;
    @FXML
    StackPane figHolder;
    @FXML
    Pane overlay;

    int points = 0;
    Boolean isFirstPlayer = true;
    Hashtable<Line, Pair<Point, Point>> linePoints = new Hashtable<>();
    ArrayList<Line> redLines = new ArrayList<>();
    ArrayList<Line> blueLines = new ArrayList<>();

    @FXML
    public void initialize()
    {
        nrOfDots.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,1,1));

        fig.widthProperty().bind(figHolder.widthProperty());
        fig.heightProperty().bind(figHolder.heightProperty());
    }

    @FXML
    protected void CreateNewGame() {
        overlay.getChildren().clear();

        points = nrOfDots.getValue();
        DrawGame();
    }

    private void DrawGame()
    {
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
        linePoints.clear();
        redLines.clear();
        blueLines.clear();

        for(int i = 0; i < pointsList.size(); i++)
        {
            for(int j = 0; j < pointsList.size(); j++)
            {
                if(i != j)
                {
                    Line line = new Line(pointsList.get(i).getX(), pointsList.get(i).getY(),
                            pointsList.get(j).getX(), pointsList.get(j).getY());
                    line.setStrokeWidth(3);

                    linePoints.put(line, new Pair<>(pointsList.get(i), pointsList.get(j)));
                    line.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            Line clickedLine = (Line) mouseEvent.getSource();
                            overlay.getChildren().remove(clickedLine);

                            if(isFirstPlayer)
                            {
                                clickedLine.setStroke(Color.RED);
                                redLines.add(clickedLine);
                            }
                            else {
                                clickedLine.setStroke(Color.BLUE);
                                blueLines.add(clickedLine);
                            }
                            isFirstPlayer = !isFirstPlayer;
                            overlay.getChildren().add(clickedLine);

                            figHolder.getChildren().clear();
                            figHolder.getChildren().add(fig);
                            figHolder.getChildren().add(overlay);

                            CheckPlayerWonStatus();
                        }
                    });
                    overlay.getChildren().addAll(line);
                }
            }
        }

        figHolder.getChildren().clear();
        figHolder.getChildren().add(fig);
        figHolder.getChildren().add(overlay);
    }

    void CheckPlayerWonStatus()
    {
        // Check if player RED has won
        if(CheckIfPlayerWon(redLines))
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("RED WON");
            a.showAndWait();
            CreateNewGame();
        }

        // Check if player BLUE has won
        if(CheckIfPlayerWon(blueLines))
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("BLUE WON");
            a.showAndWait();
            CreateNewGame();
        }
    }

    Boolean CheckIfPlayerWon(ArrayList<Line> lines)
    {
        for(int i = 0; i < lines.size(); i++)
        {
            for(int j = 0; j < lines.size(); j++)
            {
                for(int k = 0; k < lines.size(); k++)
                {
                    if(i == j || j == k || k == i) continue;

                    Pair<Point, Point> pair1 = linePoints.get(lines.get(i));
                    Pair<Point, Point> pair2 = linePoints.get(lines.get(j));
                    Pair<Point, Point> pair3 = linePoints.get(lines.get(k));

                    int pointsCount = GetNumberOfDifferentPoints(pair1, pair2, pair3);

                    if(pointsCount == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int GetNumberOfDifferentPoints(Pair<Point, Point> p1, Pair<Point, Point> p2, Pair<Point, Point> p3)
    {
        HashSet<Point> points = new HashSet<>();
        points.add(p1.getKey());
        points.add(p1.getValue());

        points.add(p2.getKey());
        points.add(p2.getValue());

        points.add(p3.getKey());
        points.add(p3.getValue());

        return points.size();
    }

    @FXML
    protected void ExitApp()
    {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    protected void CaptureAndSaveDisplay(){
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));

        //Prompt user to select a file
        var file = fileChooser.showSaveDialog(null);

        if(file != null){
            try {
                //Pad the capture area
                WritableImage writableImage = new WritableImage((int)figHolder.getWidth() + 20,
                        (int)figHolder.getHeight() + 20);
                figHolder.snapshot(null, writableImage);
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }

    @FXML
    protected void SaveAsJSON()
    {
        FileChooser fileChooser = new FileChooser();
        //Set extension filter
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("json files (*.json)", "*.json"));
        //Prompt user to select a file
        var file = fileChooser.showSaveDialog(null);

        if(file != null){
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<Pair<Point, Point>> lines = new ArrayList<>();
            ArrayList<Pair<Point, Point>> _red = new ArrayList<>();
            ArrayList<Pair<Point, Point>> _blue = new ArrayList<>();
            linePoints.values().forEach(pair -> {
                lines.add(pair);
            });
            redLines.forEach(pair -> {_red.add(linePoints.get(pair)); });
            blueLines.forEach(pair -> {_blue.add(linePoints.get(pair)); });
            try {
                objectMapper.writeValue(new File(file.getPath()),new GameInstance(
                    points, isFirstPlayer,
                        lines,
                        _red,
                        _blue
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    protected void LoadJSON()
    {
        FileChooser fileChooser = new FileChooser();
        //Set extension filter
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("json files (*.json)", "*.json"));
        //Prompt user to select a file
        var file = fileChooser.showOpenDialog(null);

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            GameInstance instance = objectMapper.readValue(new File(file.getPath()),GameInstance.class);

            points = instance.numberOfPoints;
            isFirstPlayer = instance.isFirstPlayer;

            DrawGame();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}

