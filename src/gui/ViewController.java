package gui;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import model.entities.Person;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> personComboBox;

    @FXML
    private ObservableList<Person> obsList;

    @FXML
    private Button btAll;

    @FXML
    public void onBtAllAction(){
        for(Person person : personComboBox.getItems()){
            System.out.println(person);

        }
    }

    @FXML
    public void onComboBoxPersonAction(){
        Person person = personComboBox.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Person> list = new ArrayList<>();
        list.add((new Person(1, "Maria", "maria@gmail.com")));
        list.add((new Person(2, "Bob", "bob@gmail.com")));
        list.add((new Person(3, "Alex", "alex@gmail.com")));
        list.add((new Person(4, "Joao", "joao@gmail.com")));

        obsList = FXCollections.observableArrayList(list);
        personComboBox.setItems(obsList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        personComboBox.setCellFactory(factory);
        personComboBox.setButtonCell(factory.call(null));

    }
}
