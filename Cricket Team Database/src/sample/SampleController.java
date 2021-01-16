package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SampleController {
    @FXML
    public ListView<CricketPlayer> cricketPlayerListView;

    @FXML
    public void addPlayerAction(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPlayer.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void RemoveController(){
        ArrayList<CricketPlayer> tempArrCP=new ArrayList<CricketPlayer>();
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {

            fin = new FileInputStream("data.txt");
            ois = new ObjectInputStream(fin);
            tempArrCP = (ArrayList<CricketPlayer> ) ois.readObject();
            for(CricketPlayer cp: tempArrCP)
            {
                System.out.println(cp.getName());
                System.out.println(cp.getP_Address());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Remove_P.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void RosterController(){
        ArrayList<CricketPlayer> tempArrCP=new ArrayList<CricketPlayer>();
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {

            fin = new FileInputStream("data.txt");
            ois = new ObjectInputStream(fin);
            tempArrCP = (ArrayList<CricketPlayer> ) ois.readObject();
            for(CricketPlayer cp: tempArrCP)
            {
                System.out.println(cp.getName());
                System.out.println(cp.getP_Address());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Roster.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private Button cancelButton;

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


}
