package scnce.login;

import users.Administrator;
import users.CourseAdmin;
import users.HeadOfTheAcad;
import users.MedicalStaff;
import users.Trainer;
import users.cadet;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import core.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import scnce.Administrator.AdministratorController;
import scnce.Cadet.cadetController;
import scnce.CourseAdmin.CAController;
import scnce.HeadOfTheAcademy.HeadOfTheAcadController;
import scnce.Trainer.TrainerController;


public class loginController implements Initializable {
   
    @FXML public ComboBox<String> user_type;
    @FXML public Button signInBtnOnClick;
    @FXML public TextField usernamefil;
    @FXML public TextField passwordfil;

    ObservableList<String> list1 = FXCollections.observableArrayList("HeadOfTheAcademy", "Trainer",
    "Cadet", "Administrator", "MedicalStaff", "Register","CourseAdmin");

    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
          user_type.setItems(list1);
    }

    public void signInBtnOnClick(ActionEvent event) throws Exception {
       // System.out.println("Working");
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/users/loginUsers.bin"));
            User d;
            while (true) {
                d = (User) in.readObject();
                if (d.isUsername(usernamefil.getText())&&d.isPassword(passwordfil.getText())&&d.isUsertype(this.user_type.getValue()))
                {
                    System.out.println("Log in Successful");
                    String optionChosen = this.user_type.getValue();
                    if(optionChosen.equalsIgnoreCase("Administrator")){
                        Administrator j1= new Administrator(d.getName(),d.getUsername(),d.getPassword(),d.getUsertype(),d.getContact(),d.getContact());
                        logAdministrator(j1);
                    }
                    if(optionChosen.equalsIgnoreCase("Trainer")){ 
                        Trainer l1= new Trainer(d.getName(),d.getUsername(),d.getPassword(),d.getUsertype(),d.getContact(),d.getContact());
                        logTrainer(l1);
                    }
                    if(optionChosen.equalsIgnoreCase("HeadOfTheAcademy")){
                        HeadOfTheAcad w1= new HeadOfTheAcad(d.getName(),d.getUsername(),d.getPassword(),d.getUsertype(),d.getContact(),d.getContact());
                        logHeadOfTheAcademy(w1);
                    }

                    if(optionChosen.equalsIgnoreCase("Cadet")){
                        cadet m1= new cadet(d.getName(),d.getUsername(),d.getPassword(),d.getUsertype(),d.getContact(),d.getContact());
                        logCadet(m1);
                    }
                    if(optionChosen.equalsIgnoreCase("CourseAdmin")){
                        CourseAdmin c1= new CourseAdmin(d.getName(),d.getUsername(),d.getPassword(),d.getUsertype(),d.getContact(),d.getContact());
                        logCourseAdmin(c1);
                    }
                    if(optionChosen.equalsIgnoreCase("MedicalStaff")){
                        MedicalStaff m1= new MedicalStaff(d.getName(),d.getUsername(),d.getPassword(),d.getUsertype(),d.getContact(),d.getContact());
                        logMedicalStaff(m1);
                    }

                    break;
                }
                else{
                    // status.setText("Not Found");
                    System.out.println("Not Found");
                }
                System.out.println(d.toString());
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void  logAdministrator(Administrator u)throws Exception {
        
        Stage stage = (Stage) usernamefil.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scnce/Administrator/Administrator.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Administrator");
        Scene scene = new Scene(root,956,630);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void logTrainer(Trainer u)throws Exception {
        Stage stage = (Stage) usernamefil.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scnce/Trainer/Trainer.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Trainer");
        Scene scene = new Scene(root, 1029, 604);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void logHeadOfTheAcademy(HeadOfTheAcad u)throws Exception {
        Stage stage = (Stage) usernamefil.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scnce/HeadOfTheAcademy/headOftheAcademy.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("HeadOfTheAcademy");
        Scene scene = new Scene(root, 918, 518);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void logCadet(cadet u)throws Exception {
        Stage stage = (Stage) usernamefil.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scnce/Cadet/cadet2.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Cadet");
        Scene scene = new Scene(root, 877, 663);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void logCourseAdmin(CourseAdmin u)throws Exception {
        Stage stage = (Stage) usernamefil.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scnce/CourseAdmin/CourseAdmin.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("CourseAdmin");
        Scene scene = new Scene(root, 833, 635);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void logMedicalStaff(MedicalStaff u)throws Exception {
        Stage stage = (Stage) usernamefil.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scnce/MedicalStaff/medicalStaff.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("MedicalStaff");
        Scene scene = new Scene(root, 833, 635);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
