package controller;

import model.MCircle;
import model.MRectangle;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * ShapeController provides the controller for ShowShapesA
 * It's supposed to provide the dialogs for user provided data entry.
 *
 * @author Boris Bischoff
 * @date 2017-06-07
 * @version 1.0
 */

public class ShapeController implements EventHandler<MouseEvent> {
    private Group root;
    private MRectangle rShape;
    private MCircle cShape;
    private Rectangle rec;
    private Circle circ;
    private Text text;
    private Object s;

    private Stage secondaryStage = new Stage();

    /**
     * A constructor for a rectangle object
     *
     * @param root
     * @param s
     * @param rec
     * @param text
     */

    public ShapeController(Group root, MRectangle s, Rectangle rec, Text text) {
        this.root = root;
        this.s = s;
        this.rec = rec;
        this.text = text;
    }

    /**
     * A constructor for a circle object
     *
     * @param root
     * @param s
     * @param circ
     * @param text
     */


    public ShapeController(Group root, MCircle s, Circle circ, Text text) {
        this.root = root;
        this.s = s;
        this.circ = circ;
        this.text = text;
    }

    /**
     * Mouse handler gets called when an user clicks on an object.
     * The inherent if statement calls the correct dialog by checking which type of object this is supposed to be.
     *
     * @param event
     */

    @Override
    public void handle(MouseEvent event) {
        if (s instanceof MRectangle) {
            rectangleDialog(s, rec, text).show();
        }
        else if (s instanceof MCircle) {
            circleDialog(s, circ, text).show();
        }
    }

    /**
     * Provides user prompt in separate dialog
     *
     * @param s
     * @param rec
     * @param text
     * @return secondaryStage
     */

    private Stage rectangleDialog(Object s, Rectangle rec, Text text) {
            rShape = (MRectangle) s;
            GridPane gridDialog = new GridPane();
            gridDialog.setHgap(10);
            gridDialog.setVgap(10);
            gridDialog.setPadding(new Insets(25, 25, 25, 25));

            Label labelNewXDelta = new Label("Enter width: ");
            labelNewXDelta.setFont(Font.font("Helvetica", 12));
            gridDialog.add(labelNewXDelta, 0, 0);

            TextField textFieldNewXDelta = new TextField(String.valueOf(2*rShape.getXDelta()));
            gridDialog.add(textFieldNewXDelta, 1, 0);

            Label labelNewYDelta = new Label("Enter length: ");
            labelNewYDelta.setFont(Font.font("Helvetica", 12));
            gridDialog.add(labelNewYDelta, 0, 1);

            TextField textFieldNewYDelta = new TextField(String.valueOf(2*rShape.getYDelta()));
            gridDialog.add(textFieldNewYDelta, 1, 1);

            Button buttonSubmit = new Button("Submit");
            gridDialog.add(buttonSubmit, 0,2);

            Scene sceneGridDialog = new Scene(gridDialog, 400, 300);
            secondaryStage.setScene(sceneGridDialog);

            textFieldNewXDelta.setOnAction(e -> repaintObject(rec, text, textFieldNewXDelta.getText(), textFieldNewYDelta.getText()));
            textFieldNewYDelta.setOnAction(e -> repaintObject(rec, text, textFieldNewXDelta.getText(), textFieldNewYDelta.getText()));
            buttonSubmit.setOnAction(e -> repaintObject(rec, text, textFieldNewXDelta.getText(), textFieldNewYDelta.getText()));
            return secondaryStage;
    }

    /**
     * Provides user prompt in separate dialog
     * @param s
     * @param circ
     * @param text
     * @return secondaryStage
     */

    private Stage circleDialog(Object s, Circle circ, Text text) {
            cShape = (MCircle) s;
            GridPane gridDialog = new GridPane();
            gridDialog.setHgap(10);
            gridDialog.setVgap(10);
            gridDialog.setPadding(new Insets(25, 25, 25, 25));

            Label labelNewXDelta = new Label("Enter radius: ");
            labelNewXDelta.setFont(Font.font("Helvetica", 12));
            gridDialog.add(labelNewXDelta, 0, 0);

            TextField textFieldNewRadius = new TextField(String.valueOf(cShape.getRadius()));
            gridDialog.add(textFieldNewRadius, 1, 0);

            Button buttonSubmit = new Button("Submit");
            gridDialog.add(buttonSubmit, 0,2);

            Scene sceneGridDialog = new Scene(gridDialog, 400, 300);
            secondaryStage.setScene(sceneGridDialog);

            textFieldNewRadius.setOnAction(e -> repaintObject(circ, text, textFieldNewRadius.getText()));
            buttonSubmit.setOnAction(e -> repaintObject(circ, text, textFieldNewRadius.getText()));
            return secondaryStage;
    }

    /**
     * Repaints the square object with the new data
     *
     * @param rec
     * @param text
     * @param textFieldNewXDelta
     * @param textFieldNewYDelta
     */

    private void repaintObject(Rectangle rec, Text text, String textFieldNewXDelta, String textFieldNewYDelta) {

            root.getChildren().removeAll(rec, text);
            rShape.setXDelta((Double.parseDouble(textFieldNewXDelta))/2);
            rShape.setYDelta((Double.parseDouble(textFieldNewYDelta))/2);
            rec.setWidth(2*rShape.getXDelta());
            rec.setHeight(2*rShape.getYDelta());
            text.setText("a: "+Double.toString(Math.round(rShape.area())));
            // Debug message on command prompt.
            // System.out.println("repaint: " + rShape);
            root.getChildren().addAll(rec, text);
            secondaryStage.close();
    }

    /**
     * Repaints the circle object with the new data
     * @param circ
     * @param text
     * @param textFieldNewRadius
     */

    private void repaintObject(Circle circ, Text text, String textFieldNewRadius) {
            root.getChildren().removeAll(circ, text);
            cShape.setRadius(Double.parseDouble(textFieldNewRadius));
            circ.setRadius(cShape.getRadius());
            text.setText("a: "+Double.toString(Math.round(cShape.area())));
            // Debug message on command prompt.
            // System.out.println("repaint: " + cShape);
            root.getChildren().addAll(circ, text);
            secondaryStage.close();
    }
}
