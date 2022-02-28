package scnce.Cadet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import users.cadet;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HelpboxController implements Initializable {
    
    @FXML public ComboBox<String> selectperson;
    @FXML public TextArea helptextArea ;

    ObservableList<String> listofCourse = FXCollections.observableArrayList("Trainer","Academy");
    
    public void initialize(URL arg0, ResourceBundle arg1) {
        selectperson.setItems(listofCourse);
    }

    @FXML
    public void ebulationButtonOnClick(ActionEvent event) throws IOException{
        String optionChosen = this.selectperson.getValue();
        cadet c1 =new cadet();
        String h = helptextArea.getText();
        c1.evaluationbycadet(optionChosen,h);
        helptextArea.clear();
        
    }

    @FXML
    private void goBackToCadetSceneOnClick(ActionEvent event) throws IOException{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/scnce/Cadet/cadet2.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }


}