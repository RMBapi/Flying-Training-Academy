package scnce.CourseAdmin;

import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.TextField;
import users.CourseAdmin;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

public class AddinCourseController implements Initializable{
     
    @FXML public ComboBox<String> selectCourse;
    @FXML public TextField  nameTextField;
    @FXML public TextField  idTextField;
    @FXML public TextField  sectionTextField;
    @FXML public TextField  dayTextField;
    @FXML public TextField  timeTextField;


    ObservableList<String> listofCourse = FXCollections.observableArrayList("Fly101","Fly102");

    public void initialize(URL url, ResourceBundle rb) { 
        selectCourse.setItems(listofCourse);
    }

    @FXML
    public void addCourseButtonOnClick(ActionEvent event) throws IOException{
               
                CourseAdmin c1=new CourseAdmin();
                String optionChosen = this.selectCourse.getValue();
                c1.addstudentinCourse(nameTextField.getText(),idTextField.getText(),sectionTextField.getText(),dayTextField.getText(),timeTextField.getText(),optionChosen);
                nameTextField.clear();idTextField.clear();sectionTextField.clear();dayTextField.clear();
                timeTextField.clear();
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