package scnce.HeadOfTheAcademy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import users.HeadOfTheAcad;
import javafx.stage.Stage;
import javafx.scene.Node;


public class AnnualController implements Initializable{
     
    @FXML private LineChart<String, Number> lineChart;
    @FXML private Label lineChartLabel;
    @FXML private PieChart pieChart;

    public void initialize(URL url, ResourceBundle rb) { 
     
        viewliveannualreport();
    }

    public void viewliveannualreport()
    {
        HeadOfTheAcad h1 =new HeadOfTheAcad();
        h1.viewlivechartreport(lineChart);
        h1.annualIncome(pieChart);
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