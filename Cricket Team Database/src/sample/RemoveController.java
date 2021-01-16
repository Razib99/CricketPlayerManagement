package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class RemoveController {
    ArrayList<CricketPlayer> selectedPlayer =new ArrayList<CricketPlayer>();
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
    private Button deleteButton;
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

        TableColumn select = new TableColumn("Select");
        select.setMinWidth(25);
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CricketPlayer, CheckBox>, ObservableValue<CheckBox>>() {

            @Override
            public ObservableValue call(TableColumn.CellDataFeatures<CricketPlayer, CheckBox> arg0)
            {
                CricketPlayer cp = arg0.getValue();
                CheckBox checkBox = new CheckBox();
                checkBox.selectedProperty().setValue(cp.isSelected());

                checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        cp.setSelected(newValue);
                        System.out.println(cp.getName()+" is selected!");
                        if(selectedPlayer.contains(cp))
                        {
                            selectedPlayer.remove(cp);
                        }else{
                            selectedPlayer.add(cp);
                        }
                    }
                });
                return new SimpleObjectProperty<CheckBox>(checkBox);
            }
        });
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

        rosterView.getColumns().addAll( select , name, jerseyNumber, salary, address, f_Position);
        for(CricketPlayer cp: tempArrCP)
        {
            rosterView.getItems().add(cp);
        }
    }

    ArrayList<CricketPlayer> updatedList = new ArrayList<>();
    public void deleteButtonOnAction(ActionEvent event){
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        for(CricketPlayer cp: tempArrCP)
        {
            boolean exist = false;
            for(CricketPlayer _cp: selectedPlayer)
            {
                if(cp.getName().equals(_cp.getName()))
                {
                    exist = true; break;
                }
            }
            if(!exist){updatedList.add(cp);}
        }
        try {

            FileOutputStream fileOut = new FileOutputStream("data.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(updatedList);
            objectOut.close();
            System.out.println("Player list updated...");

        } catch (Exception ex) {
//            ex.printStackTrace();s
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Deleted");
        a.setContentText("One player removed successfully...");
        a.showAndWait();

        rosterView.getItems().clear();
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {

            fin = new FileInputStream("data.txt");
            ois = new ObjectInputStream(fin);
            tempArrCP = (ArrayList<CricketPlayer>) ois.readObject();


        } catch (Exception ex) {
//            ex.printStackTrace();

        }
        for(CricketPlayer cp: tempArrCP)
        {
            rosterView.getItems().add(cp);
        }
//        stage.close();

//        this.initialize();

    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}




