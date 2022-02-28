package scnce.MedicalStaff;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import users.MedicalStaff;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MviewNotice implements Initializable {
    
    
    @FXML public Label viewnoticeLabel;
    
    public void initialize(URL arg0, ResourceBundle arg1) {
        noticevisible();
        
    }
    public void noticevisible()
    {
       MedicalStaff m1 =new MedicalStaff();
       m1.viewnotice(viewnoticeLabel);
       
    }

    @FXML
    private void backtoStaff(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/scnce/MedicalStaff/medicalStaff.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }

}
