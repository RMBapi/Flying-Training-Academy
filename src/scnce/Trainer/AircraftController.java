package scnce.Trainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import users.Trainer;
import javafx.stage.Stage;
import javafx.scene.Node;


public class AircraftController implements Initializable {

    @FXML public DatePicker adate;
    @FXML public TextField timeTextField;
    @FXML public TextField purposeTextField;
    @FXML public ComboBox<String> aircirft;

    ObservableList<String> listofCourse = FXCollections.observableArrayList("Boing121","Boing707");
    
    public void initialize(URL arg0, ResourceBundle arg1) {
        aircirft.setItems(listofCourse);
        
    }
    
    @FXML
    private void bookaircriftOnClick(ActionEvent event)
    {
        String name =this.aircirft.getValue();
        Trainer t1 =new Trainer();
        t1.bookaircrift(name,adate.getValue(),timeTextField.getText(),purposeTextField.getText());
        timeTextField.clear();purposeTextField.clear();

    }

    @FXML
    private void goBackToCadetSceneOnClick(ActionEvent event) throws IOException{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/scnce/Trainer/Trainer.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }


}