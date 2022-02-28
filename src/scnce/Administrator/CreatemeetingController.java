package scnce.Administrator;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import users.Administrator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javafx.scene.Node;

import core.AppendableObjectOutputStream;
import core.meeting;
public class CreatemeetingController implements Initializable {

   
    @FXML public TextField  meetingIDTextField;
    @FXML public TextField  purposeTextField;
    @FXML public TextField  timeTextField;
    @FXML public TextField  dateTextField;
    @FXML public TextField  approvalTextField;
    @FXML public TextArea meetingoutputTextArea;
    @FXML public TextArea  meetingEditTextArea;
    @FXML public CheckBox  editmeetingCheckBox;
   
    public void initialize(URL arg0, ResourceBundle arg1) {
        //todo
    }

    @FXML
    public void meetingcreateButtononClick(ActionEvent event) throws IOException{
        File f = null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
          
            f = new File("src/Files/Administrator/Createmeeting.bin");
            if(f.exists()) {
                fos = new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            meeting s=new meeting(
                    meetingIDTextField.getText(),
                    purposeTextField.getText(),
                    timeTextField.getText(),
                    dateTextField.getText(),
                    approvalTextField.getText());  
                
            oos.writeObject(s);
             
            meetingIDTextField.clear();purposeTextField.clear();timeTextField.clear();dateTextField.clear();
            approvalTextField.clear();
        } catch (IOException ex) {
            Logger.getLogger(CreatemeetingController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
          try {
              if(oos != null) oos.close();
          } catch (IOException ex) {
              Logger.getLogger(CreatemeetingController.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }

    @FXML
    private void viewMeetingListOnClick(ActionEvent event) {
        ObjectInputStream ois=null;
        try {
           meeting s;
           ois = new ObjectInputStream(new FileInputStream("src/Files/Administrator/Createmeeting.bin"));
           while(true){
           s = (meeting) ois.readObject();
           String r = s.getMeetingId()+
                     ","+s.getPurpose()+
                     ","+s.getTime()+
                    ","+s.getDate()+
                    ","+s.getAppoval()+"\n";
           meetingoutputTextArea.appendText(r);
           }
           
       } catch (Exception ex) {
           try {
               if(ois!=null)
                   ois.close();
           } 
           catch (IOException e) {
               e.printStackTrace();
           }
           ex.printStackTrace();
       }        
    } 

    @FXML
    private void goBackToAddministrationSceneOnClick(ActionEvent event) throws IOException{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/scnce/Administrator/Administrator.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
        
    

                
    
}