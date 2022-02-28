package scnce.CourseAdmin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import users.CourseAdmin;
import javafx.stage.Stage;
import javafx.scene.Node;

public class NoticeController implements Initializable{
    
    @FXML public Label viewnoticeLabel;
    public void initialize(URL url, ResourceBundle rb) { 
        noticevisible();

    }

    public void noticevisible()
    {
        CourseAdmin t =new CourseAdmin();
        t.viewnotice(viewnoticeLabel);

    }
    @FXML
    private void goBacadminOnClick(ActionEvent event) throws IOException{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/scnce/CourseAdmin/CourseAdmin.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
}
