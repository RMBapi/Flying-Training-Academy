package scnce.Cadet;

import java.io.File;
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
import javafx.scene.control.Label;
import users.cadet;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ContactController implements Initializable {
    
    @FXML public Label HeadoftheAca;
    @FXML public Label addoff;
    @FXML public Label reg;

    public void initialize(URL arg0, ResourceBundle arg1) {
        showContact();
    }

    public void showContact()
    {
        cadet c1  =new cadet();
        c1.viewcontacts(HeadoftheAca,addoff,reg);
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




