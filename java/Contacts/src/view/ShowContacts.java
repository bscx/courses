package view;

/**
 * This class provides the GUI and some logic for the program
 *
 * @author Boris Bischoff
 * @date 2017-06-05
 * @version 1.0
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import model.Contacts;
import model.Contact;
import model.Email;

public class ShowContacts extends Application {

    private Scene scene;
    public BorderPane contactList;
    public GridPane gridContactDetails;
    Contacts init = new Contacts();
    String emailList = "";
    String listSelectedItem = "";

    @Override
    public void start(Stage primaryStage) {
        try {
            contactList = new BorderPane();

            Label top = new Label("Contact Management");
            top.setPadding(new Insets(25, 25, 25, 25));
            top.setFont(Font.font ("Helvetica", 24));
            contactList.setTop(top);

            //inside second all components will be placed in the middle
            //and on the bottom

            initializeList(contactList);

            HBox bottom = new HBox();
            bottom.setAlignment(Pos.BOTTOM_CENTER);
            bottom.setPadding(new Insets(10,0,10,0));
            Button buttonNewContact = new Button("New contact");
            buttonNewContact.setPadding(new Insets(10,25,10,25));
            buttonNewContact.setOnAction(e -> sceneAddEntry(primaryStage));
            bottom.getChildren().addAll(buttonNewContact);
            contactList.setBottom(bottom);


            scene = new Scene(contactList, 600, 400);
            primaryStage.setTitle("Contact Management");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sceneAddEntry(Stage stage){
        try {
            BorderPane dialogAddEntry = new BorderPane();

            Label top = new Label("Contact Management");
            top.setPadding(new Insets(25, 25, 25, 25));
            top.setFont(Font.font ("Helvetica", 24));
            dialogAddEntry.setTop(top);

            Label left = new Label("");
            left.setPadding(new Insets(25, 25, 25, 25));
            dialogAddEntry.setLeft(left);
            //put this label in the center of the left side
            BorderPane.setAlignment(left, Pos.CENTER);

            Label right = new Label("");
            right.setPadding(new Insets(25, 25, 25, 25));
            dialogAddEntry.setRight(right);

            GridPane gridDialog = new GridPane();
            gridDialog.setHgap(10);
            gridDialog.setVgap(10);
            gridDialog.setPadding(new Insets(0, 0, 0, 0));

            Label labelName = new Label("Full name: ");
            labelName.setFont(Font.font("Helvetica",12));
            gridDialog.add(labelName, 0, 0);

            TextField textFieldName = new TextField();
            gridDialog.add(textFieldName, 1, 0);

            Label labelPhoneNumber = new Label("Phone number: ");
            labelPhoneNumber.setFont(Font.font("Helvetica",12));
            gridDialog.add(labelPhoneNumber, 0, 1);

            TextField textFieldPhoneNumber = new TextField();
            gridDialog.add(textFieldPhoneNumber, 1, 1);
            textFieldPhoneNumber.textProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue.matches("[0-9]*")){
                    textFieldPhoneNumber.setText(oldValue);
                }
            });

            Text errorPhoneNumber = new Text("");
            errorPhoneNumber.setFont(Font.font("Helvetica", 12));
            errorPhoneNumber.setFill(Color.RED);
            gridDialog.add(errorPhoneNumber, 2, 1);

            Label labelEmailAddress = new Label("Email address: ");
            labelEmailAddress.setFont(Font.font("Helvetica", 12));
            gridDialog.add(labelEmailAddress, 0, 2);

            TextField textFieldEmailAddress = new TextField();
            gridDialog.add(textFieldEmailAddress, 1, 2);

            Text errorEmailAddress = new Text("");
            errorEmailAddress.setFont(Font.font("Helvetica", 12));
            errorEmailAddress.setFill(Color.RED);
            gridDialog.add(errorEmailAddress, 2, 2);

            Label labelPhoto = new Label("Path to photo: ");
            labelPhoto.setFont(Font.font("Helvetica", 12));
            gridDialog.add(labelPhoto, 0, 3);

            TextField textFieldPhoto = new TextField();
            gridDialog.add(textFieldPhoto, 1, 3);

            dialogAddEntry.setCenter(gridDialog);

            HBox bottom = new HBox();
            bottom.setAlignment(Pos.BOTTOM_CENTER);
            bottom.setPadding(new Insets(10,0,10,0));
            Button buttonAddEntry = new Button("Add");
            buttonAddEntry.setOnAction(e -> addAndBack(stage, textFieldName.getText(), Long.parseLong(textFieldPhoneNumber.getText()), textFieldEmailAddress.getText(), textFieldPhoto.getText()));
            buttonAddEntry.setPadding(new Insets(10,25,10,25));
            Button buttonCancel = new Button("Cancel");
            buttonCancel.setOnAction(e -> cancelAndBack(stage));
            buttonCancel.setPadding(new Insets(10,25,10,25));
            bottom.getChildren().addAll(buttonAddEntry,buttonCancel);
            dialogAddEntry.setBottom(bottom);

            stage.setTitle("Contact Management");
            stage.setScene(new Scene(dialogAddEntry, 600, 400));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addAndBack(Stage stage, String name, long phoneNumber, String emailAddress, String photo) {
        Contacts.addToList(name, phoneNumber, emailAddress, photo);
        initializeList(contactList);
        stage.setScene(scene);
    }

    private void cancelAndBack(Stage stage){
        stage.setScene(scene);
    }

    private void initializeList(BorderPane contactList) {
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList();

        ArrayList<Contact> contacts = Contacts.getContacts();

        for (Contact c : contacts) {
            items.add(c.getName());
        }

        list.setItems(items);
        list.setMaxWidth(150);
        contactList.setMargin(list, new Insets(0,0,25,25));
        contactList.setLeft(list);

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                ArrayList<Contact> contacts = Contacts.getContacts();
                for (Contact c : contacts) {
                    if (list.getSelectionModel().getSelectedItem() == null) {
                        listSelectedItem = c.getName();
                    }
                    else {
                        listSelectedItem = list.getSelectionModel().getSelectedItem();
                    }
                    if (listSelectedItem.equals(c.getName())) {
                        gridContactDetails = new GridPane();
                        gridContactDetails.setHgap(10);
                        gridContactDetails.setVgap(5);
                        gridContactDetails.setPadding(new Insets(0,25,0,25));

                        ColumnConstraints gridContactDetailsColumn1 = new ColumnConstraints(250);
                        ColumnConstraints gridContactDetailsColumn2 = new ColumnConstraints(100);
                        gridContactDetails.getColumnConstraints().addAll(gridContactDetailsColumn1,gridContactDetailsColumn2);

                        Label contactName = new Label(c.getName());
                        contactName.setFont(Font.font ("Helvetica", 20));
                        gridContactDetails.add(contactName, 0, 0, 3, 1);

                        Label labelContactPhoneNumber = new Label("Phone number: " + c.getNumber());
                        labelContactPhoneNumber.setFont(Font.font ("Helvetica", 12));
                        gridContactDetails.add(labelContactPhoneNumber, 0, 1, 1, 1);

                        initializeEmailAddressList(c);

                        Image imageContactPhoto = new Image(c.getPhoto());
                        ImageView viewContactPhoto = new ImageView(imageContactPhoto);
                        viewContactPhoto.setPreserveRatio(true);
                        viewContactPhoto.setFitWidth(100);
                        GridPane.setHalignment(viewContactPhoto, HPos.RIGHT);
                        GridPane.setValignment(viewContactPhoto, VPos.TOP);
                        gridContactDetails.add(viewContactPhoto, 1, 1, 2, 2);

                        Label labelNewEmailAddress = new Label("New email address: ");
                        labelNewEmailAddress.setFont(Font.font("Helvetica", 12));
                        gridContactDetails.add(labelNewEmailAddress,0,3,2,1);

                        TextField textFieldNewEmailAddress = new TextField();
                        gridContactDetails.add(textFieldNewEmailAddress, 0, 4);

                        Button buttonFieldNewEmailAddress = new Button("Add");
                        gridContactDetails.add(buttonFieldNewEmailAddress, 1, 4);
                        buttonFieldNewEmailAddress.setPadding(new Insets(5,10,5,10));
                        buttonFieldNewEmailAddress.setOnAction(e -> addNewContactEmailAddress(c, textFieldNewEmailAddress.getText()));
                        contactList.setCenter(gridContactDetails);
                    }
                }
            }
        });
    }

    private void initializeEmailAddressList(Contact c) {
        emailList = "";

        ArrayList<Email> emails = c.getEmails();
        for (int i = 0; i < c.getEmails().size(); i++) {
            Email e = emails.get(i);
            emailList += e.getEmail() + "\n";
        }

        Label labelContactEmailAddress = new Label("Email addresses:\n" + emailList);
        labelContactEmailAddress.setFont(Font.font ("Helvetica", 12));

        ScrollPane scrollPaneContactEmailAddress = new ScrollPane();
        scrollPaneContactEmailAddress.setBackground(
                new Background(new BackgroundFill(Color.TRANSPARENT, null, null))
        );
        scrollPaneContactEmailAddress.setPrefSize(250, 135);
        scrollPaneContactEmailAddress.setContent(labelContactEmailAddress);
        gridContactDetails.add(scrollPaneContactEmailAddress, 0,2,1,1);
    }

    private void addNewContactEmailAddress(Contact c, String newEmailAddress) {
        c.addEmail(newEmailAddress);
        initializeEmailAddressList(c);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
