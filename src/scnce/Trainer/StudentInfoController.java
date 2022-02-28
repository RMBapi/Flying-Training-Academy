package scnce.Trainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import users.Trainer;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class StudentInfoController implements Initializable {
    
    @FXML public TextArea  infromTextArea;
    @FXML public TextField infromTextField;
    @FXML public Label viewmsgLevel;

    public void initialize(URL arg0, ResourceBundle arg1) {
     //todo
    }

    @FXML
    private void aboutStudentOnClick(ActionEvent event)
    {
        Trainer t1 =new Trainer();
        t1.studentinfo(infromTextField.getText(),infromTextArea,viewmsgLevel);
        infromTextField.clear();

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