package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddController {
    @FXML TextField name;
    @FXML TextField jersey_no;
    @FXML TextField salary;
    @FXML TextField p_Address;
    @FXML TextField f_Position;
//    String filePath="data.txt";
    public void registerButton(ActionEvent actionEvent) {
        ArrayList<CricketPlayer> tempArrCP=new ArrayList<CricketPlayer>();
        FileInputStream fin = null;
        ObjectInputStream ois = null;


        try {

            fin = new FileInputStream("data.txt");
            ois = new ObjectInputStream(fin);
            tempArrCP = (ArrayList<CricketPlayer>) ois.readObject();


        } catch (Exception ex) {
//            ex.printStackTrace();

        }

        System.out.println(name.getText());
        System.out.println(jersey_no.getText());
        System.out.println(salary.getText());
        System.out.println(p_Address.getText());
        System.out.println(f_Position.getText());

        String tempName=name.getText();
        String tempNumber=jersey_no.getText();
        String tempSalary=salary.getText();
        String tempAddress=p_Address.getText();
        String tempFielding=f_Position.getText();
        CricketPlayer tempCP=new CricketPlayer(tempName, tempNumber, tempSalary, tempAddress , tempFielding);
        try {

            FileOutputStream fileOut = new FileOutputStream("data.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            tempArrCP.add(tempCP);
            objectOut.writeObject(tempArrCP);
            objectOut.close();
            System.out.println("New player added..");
            registrationmessageLabel.setText("User has been registered successfully !");
        } catch (Exception ex) {
//            ex.printStackTrace();
        }

//        try{tempCP.loadPlayer(filePath, tempArrCP);}catch(Exception e){}
//        tempArrCP.add(tempCP);
//        tempCP.addPlayer(filePath,tempArrCP);

    }
    @FXML
    private Button cancelButton;
    @FXML
    private Label registrationmessageLabel;


    public void registerButtonOnAction(ActionEvent event) {

    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }
}
