package scnce.MedicalStaff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import users.MedicalStaff;
import javafx.stage.Stage;
import javafx.scene.Node;

public class PreviousController implements Initializable {
    

    @FXML public TextField  cadetIDTextField;
    @FXML public TextArea   viewFileTextArea;
    @FXML public CheckBox  editSchlorshipontentCheckBox;
    @FXML public TextArea   InformationEditTextArea;
   
    
    
    public void initialize(URL arg0, ResourceBundle arg1) {
        //todo
    }

    @FXML
    private void previousMedicalReportOnClick(ActionEvent event) { 
           MedicalStaff m1 =new MedicalStaff();
           m1.previousreports(cadetIDTextField.getText(),viewFileTextArea);

    }

    @FXML
    private void editSchlorshipContentOnClick(ActionEvent event) {
        if(editSchlorshipontentCheckBox.isSelected()){
            InformationEditTextArea.setEditable(true);
            InformationEditTextArea.setText(viewFileTextArea.getText());
        }
        else{
            InformationEditTextArea.setText(null);
            InformationEditTextArea.setEditable(false);
        }
    }


    @FXML
    public void saveEditedSchfile(ActionEvent event)throws Exception{
        try {
            File file = new File("src/Files/MedicalStaff/"+cadetIDTextField.getText()+".txt");
            if (!file.exists()) {
               //todo
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(InformationEditTextArea.getText());
            out.newLine();
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
       
       
    }

    @FXML
    private void backtoStaff(ActionEvent event) throws IOException{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/scnce/MedicalStaff/medicalStaff.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
}
