package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class RosterController {

    ArrayList<CricketPlayer> tempArrCP=new ArrayList<CricketPlayer>();
    @FXML
    private TableView rosterView;

    @FXML
    private TableColumn<?, ?> no;

    @FXML
    private TableColumn<?, ?> playerName;

    @FXML
    private TableColumn<?, ?> jerseyNumber;

    @FXML
    private TableColumn<?, ?> salary;

    @FXML
    private TableColumn<?, ?> p_Address;

    @FXML
    private TableColumn<?, ?> f_Position;

    @FXML
    private Button cancelButton;

    @FXML
    private void initialize(){

        FileInputStream fin = null;
        ObjectInputStream ois = null;


        try {

            fin = new FileInputStream("data.txt");
            ois = new ObjectInputStream(fin);
            tempArrCP = (ArrayList<CricketPlayer>) ois.readObject();


        } catch (Exception ex) {
//            ex.printStackTrace();

        }


        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn jerseyNumber = new TableColumn("Jersey No");
        jerseyNumber.setCellValueFactory(new PropertyValueFactory<>("jerseyNumber"));

        TableColumn salary = new TableColumn("Salary");
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn address = new TableColumn("Address");
        address.setCellValueFactory(new PropertyValueFactory<>("p_Address"));

        TableColumn f_Position = new TableColumn("Fielding Position");
        f_Position.setCellValueFactory(new PropertyValueFactory<>("f_Position"));

        rosterView.getColumns().addAll( name, jerseyNumber, salary, address, f_Position);
        for(CricketPlayer cp: tempArrCP)
        {
            rosterView.getItems().add(cp);
        }
    }


    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}




