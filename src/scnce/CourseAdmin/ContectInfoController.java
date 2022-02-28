package scnce.CourseAdmin;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import users.CourseAdmin;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class ContectInfoController implements Initializable {
     
    @FXML public TextArea informationtakeTextArea;
    @FXML public TextArea showInformationTextArea;
    @FXML public TextArea informationcontEditTextArea;
    @FXML public CheckBox  editcontCheckBox;

    public void initialize(URL arg0, ResourceBundle arg1) {
      //todo
    }

    @FXML
    private void submitContactOnClick(ActionEvent event) {       
        CourseAdmin c1 =new CourseAdmin();
        c1.addContectInformation(informationtakeTextArea);
    }

    @FXML
    private void viewcontInformationOnClick(ActionEvent event) {
        showInformationTextArea.setText("");
        File f = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("src/Files/CourseAdmin/contectInfo.txt");
            sc = new Scanner(f);
            if(f.exists()){

                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    showInformationTextArea.appendText(
                        tokens[0]+
                        tokens[1]                    
                    );
                }
            }
            else 
                showInformationTextArea.setText("oops! file does not exist...");

        } 
        catch (IOException ex) {
            Logger.getLogger(ContectInfoController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            //todo
        }
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


