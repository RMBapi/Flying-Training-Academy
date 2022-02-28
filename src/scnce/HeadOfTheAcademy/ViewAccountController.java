package scnce.HeadOfTheAcademy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import core.BAccount;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import users.HeadOfTheAcad;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ViewAccountController implements Initializable{
     
    @FXML private TableView<BAccount> tableView;
    @FXML private TableColumn<BAccount, String> tableacctypeIDColumn;
    @FXML private TableColumn<BAccount, String> tabletrasactionColumn;
    @FXML private TableColumn<BAccount, String> tabledebitcolumn;
    @FXML private TableColumn<BAccount, String> tablecreditcolumn;
    @FXML private TableColumn<BAccount, String> tabletakaColumn;
    
    public void initialize(URL url, ResourceBundle rb) { 
        tableacctypeIDColumn.setCellValueFactory(new PropertyValueFactory<BAccount, String>("account_Type"));
        tabletrasactionColumn.setCellValueFactory(new PropertyValueFactory<BAccount, String>("trasaction"));
        tabledebitcolumn.setCellValueFactory(new PropertyValueFactory<BAccount, String>("debit"));
        tablecreditcolumn.setCellValueFactory(new PropertyValueFactory<BAccount, String>("credit"));
        tabletakaColumn.setCellValueFactory(new PropertyValueFactory<BAccount,String>("totaltaka"));

        loadtakaFileButtonOnClick();
       
        

        
    }

    @FXML
    private void loadtakaFileButtonOnClick() {
        HeadOfTheAcad h1=new HeadOfTheAcad();
        h1.viewaccademicAccount(tableView);
            
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
