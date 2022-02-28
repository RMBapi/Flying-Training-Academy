package scnce.Trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import users.Trainer;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class GradeController implements Initializable {
   
    @FXML public ComboBox<String> course;
    @FXML public TextArea courseview;
    @FXML public TextField idtextArea;
    @FXML public TextField sectiontextArea;
    @FXML public TextField gradetextArea;


    ObservableList<String> listofCourse = FXCollections.observableArrayList("Fly101","Fly102");
    
    public void initialize(URL arg0, ResourceBundle arg1) {
        course.setItems(listofCourse);
        
    }

    @FXML
    private void viewCourseOnClick(ActionEvent event) {
        String optionChosen = this.course.getValue();
        courseview.setText("");
        Trainer t1 =  new Trainer();
        t1.showcourseCadetList(optionChosen,courseview);
       
        
    }

    @FXML
    private void gradeSubmissionOnClick(ActionEvent event) {
        Trainer t1 =  new Trainer();
        t1.gradesubmission(idtextArea.getText(),sectiontextArea.getText(),gradetextArea.getText() );
        idtextArea.clear();sectiontextArea.clear();gradetextArea.clear();
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
