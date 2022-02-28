package scnce.MedicalStaff;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import users.MedicalStaff;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CreateReportController implements Initializable {

    @FXML public TextField  cadetIDTextField;
    @FXML public TextField  test1TextField;
    @FXML public TextField  test2TextField;
    @FXML public TextField  test3TextField;
    @FXML public TextField cadetIDWatchTextField;
    @FXML public TextArea   mediRepoutputTextArea;
    
    
    public void initialize(URL arg0, ResourceBundle arg1) {
        //todo
    }
    
    @FXML
    private void createMedicalReportOnClick(ActionEvent event) {       
       MedicalStaff m1 =new MedicalStaff();
       m1.createmedicalreport(cadetIDTextField.getText(),test1TextField.getText(),test2TextField.getText(),test3TextField.getText());
       test1TextField.clear();test2TextField.clear();test3TextField.clear();
      }
    @FXML
    private void readmediRecONClick(ActionEvent event) {
        mediRepoutputTextArea.setText("");
        File f=null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        String str="";
        try{
            f = new File("src/Files/MedicalStaff/"+cadetIDWatchTextField.getText()+"Report.bin");
            if(!f.exists()){
                mediRepoutputTextArea.setText("Opps!File isn't Found");
            }
            else{
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                while(true){
                    str+= "Report Of "+cadetIDWatchTextField.getText()+"\n"
                    +"Test 1 : "+dis.readUTF()+"\n"
                    +"Test 2 : "+dis.readUTF()+"\n"
                    +"Test 3 : "+dis.readUTF()+"\n";
                   
                }
            }
        }catch (IOException ex) {
            mediRepoutputTextArea.setText(str);
            Logger.getLogger(CreateReportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                Logger.getLogger(CreateReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
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


