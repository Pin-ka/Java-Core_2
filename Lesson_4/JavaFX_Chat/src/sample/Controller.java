package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Controller {

    @FXML
    ListView listView;

    @FXML
    TextField textField;

    @FXML
    HBox controlPane;

    @FXML
    Button send;

    public void sendMsg(ActionEvent actionEvent) {

        sendMessage();

    }

    public void sendMessage() {
        Label message = new Label(textField.getText());

        VBox messageBox = new VBox(message);

        if (listView.getItems().size()%2 != 0) messageBox.setAlignment(Pos.CENTER_RIGHT);

        listView.getItems().add(messageBox);
        textField.clear();
        textField.requestFocus();
        listView.scrollTo(listView.getItems().size()-1);
    }
}
