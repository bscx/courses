package view;

/**
 * A class to represent graphically an Array of Shape-objects.
 * A Shape Object can be a rectangle or a circle.
 * The shapes appear with their real dimensions and positions,
 * and their area (number rounded) displayed at their origin.
 * @author agathe merceron
 */


import controller.ShapeController;

import model.MAllShapes;
import model.MCircle;
import model.MRectangle;
import model.MShape;
import model.MSquare;
import model.MEllipse;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowShapesA extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Group root = new Group();
            // the data that should be graphically represented
            MShape[] shapes = MAllShapes.getDefaultShapes();

            for (MShape s : shapes) {
                // check whether the shape is a rectangle
                if (s instanceof MRectangle) {
                    // cast necessary for the methods getXDelta and getYDelta
                    MRectangle srec = (MRectangle) s;
                    Rectangle rec = new Rectangle(srec.getXOrigin(),
                            srec.getYOrigin(), 2*srec.getXDelta(), 2*srec.getYDelta());
                    //color red is made transparent
                    //so that overlapping shapes are visible
                    rec.setFill(Color.rgb(255, 0, 0, 0.15));
                    // the area (number rounded) displayed as text
                    Text text = new Text(srec.getXOrigin(), srec.getYOrigin(),
                            "a: "+Double.toString(Math.round(srec.area())));

                    root.getChildren().addAll(rec, text);

                    rec.setOnMouseClicked(new ShapeController(root, srec, rec, text));

                } else if (s instanceof MCircle) {
                    // cast necessary for the methods getXDelta and getYDelta
                    MCircle sc = (MCircle) s;
                    Circle circ = new Circle(sc.getXOrigin(),
                            sc.getYOrigin(), sc.getRadius());
                    //color green is made transparent
                    //so that overlapping shapes are visible
                    circ.setFill(Color.rgb(0, 255, 0, 0.15));
                    // the area (number rounded) displayed as text
                    Text text = new Text(sc.getXOrigin(), sc.getYOrigin(),
                            "a: "+Double.toString(Math.round(sc.area())));

                    root.getChildren().addAll(circ, text);

                    circ.setOnMouseClicked(new ShapeController(root, sc, circ, text));

                } else if (s instanceof MSquare) {
                    // cast necessary for the methods getXDelta
                    MSquare ssquare = (MSquare) s;
                    Rectangle square = new Rectangle(ssquare.getXOrigin(),
                            ssquare.getYOrigin(), 2*ssquare.getXDelta(), 2*ssquare.getXDelta());
                    //color blue is made transparent
                    //so that overlapping shapes are visible
                    square.setFill(Color.rgb(0, 0, 255, 0.15));
                    // the area (number rounded) displayed as text
                    Text text = new Text(ssquare.getXOrigin(), ssquare.getYOrigin(),
                            "square(A): "+Double.toString(Math.round(ssquare.area())));

                    root.getChildren().addAll(square, text);
                } else if (s instanceof MEllipse) {
                    // cast necessary for the methods getRadiusA and getRadiusB
                    MEllipse sellipse = (MEllipse) s;
                    Ellipse ellipse = new Ellipse(sellipse.getXOrigin(),
                            sellipse.getYOrigin(), sellipse.getRadiusA(), sellipse.getRadiusB());
                    //color purple is made transparent
                    //so that overlapping shapes are visible
                    ellipse.setFill(Color.rgb(200, 50, 255, 0.15));
                    // the area (number rounded) displayed as text
                    Text text = new Text(sellipse.getXOrigin(), sellipse.getYOrigin(),
                            "ellipse(A): "+Double.toString(Math.round(sellipse.area())));

                    root.getChildren().addAll(ellipse, text);
                }
            }

            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}