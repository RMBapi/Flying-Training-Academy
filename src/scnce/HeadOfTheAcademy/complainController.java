package scnce.HeadOfTheAcademy;

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
import javafx.scene.control.TextArea;
import users.HeadOfTheAcad;
import javafx.stage.Stage;
import javafx.scene.Node;

public class complainController implements Initializable{

    

    @FXML public ComboBox<String> selectperson;
    @FXML public TextArea complaintextArea ;
     
    ObservableList<String> listofCourse = FXCollections.observableArrayList("Trainer","Academy");
    public void initialize(URL url, ResourceBundle rb) { 
     
        selectperson.setItems(listofCourse);
    }
    @FXML
    private void viewcomplainreportonclick(ActionEvent event) throws IOException
    {
         HeadOfTheAcad h1 =new HeadOfTheAcad();
         String optionChosen = this.selectperson.getValue();
         h1.viewAcademicComplain(optionChosen,complaintextArea);
    }

    @FXML
    private void backtoHTDONClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/scnce/HeadOfTheAcademy/headOftheAcademy.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }
}
