package scnce.Cadet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import users.cadet;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ViewCourseController implements Initializable {
    
    @FXML private TextArea outputTxtArea;
    @FXML private TextField courseIdTextField;
    @FXML private TextField sectionTextField;
    
    public void initialize(URL arg0, ResourceBundle arg1) {
     //todo
    }

    @FXML
    private void viewCourseOnClick(ActionEvent event) {      
       cadet c1 =new cadet();
       c1.viewCourse(outputTxtArea);
    }

    @FXML
    private void addOnClick(ActionEvent event) {      
       cadet c1 =new cadet();
       c1.addinCourse(courseIdTextField.getText(),sectionTextField.getText());
       courseIdTextField.clear();sectionTextField.clear();
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
