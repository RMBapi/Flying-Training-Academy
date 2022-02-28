package scnce.CourseAdmin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import users.CourseAdmin;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class OfferedCourseController implements Initializable{
   
    
    @FXML    private TextField courseIdTextField;
    @FXML    private TextField sectionTextField;
    @FXML    private TextField dateTextField;
    @FXML    private TextField timeTextField;
     
 
    public void initialize(URL url, ResourceBundle rb) { 
    //todo

    }

    @FXML
    private void addCourseOnClick(ActionEvent event) {      
       
        CourseAdmin c1 = new CourseAdmin();
        c1.offeredCourse(courseIdTextField.getText(),sectionTextField.getText(),dateTextField.getText(),timeTextField.getText());
        courseIdTextField.clear();sectionTextField.clear();dateTextField.clear();timeTextField.clear();
    }
    @FXML
    private void backtoAdminOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/scnce/CourseAdmin/CourseAdmin.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }


}

