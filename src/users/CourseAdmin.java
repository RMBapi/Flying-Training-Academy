package users;

import core.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import users.CourseAdmin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

public class CourseAdmin extends User {
    private static final long serialVersionUID = 1L;

    public CourseAdmin(String name, String username, String password, String usertype, String contact, String address) { 
        super(name, username, password, usertype, contact, address);
    }

    public CourseAdmin() { 
       //todo
    }

    public void addstudentinCourse(String name1,String id1,String section1,String day1,String time1,String optionChosen)
    {
        
        if (optionChosen == "Fly101")
        {
            File f = null;
            FileWriter fw = null;
            try {
              
                f = new File("src/Files/CourseAdmin/Fly101.txt");
                if(f.exists()) fw = new FileWriter(f,true);
                else fw = new FileWriter(f);
               
                fw.write(
                    name1+","
                    +id1+","	
                    +section1+","
                    +day1+","		
                    +time1+"\n"	
                );           
                
            } catch (IOException ex) {
               //todo
            } finally {
              try {
                  if(fw != null) fw.close();
              } catch (IOException ex) {
                 //todo
              }
          }
        }
        else{
            File f = null;
            FileWriter fw = null;
            try {
              
                f = new File("src/Files/CourseAdmin/Fly102.txt");
                if(f.exists()) fw = new FileWriter(f,true);
                else fw = new FileWriter(f);
               
                fw.write(
                    name1+","
                    +id1+","	
                    +section1+","
                    +day1+","		
                    +time1+"\n"		
                );           
               
            } catch (IOException ex) {
               //todo
            } finally {
              try {
                  if(fw != null) fw.close();
              } catch (IOException ex) {
                //todo
              }
          }
        }
    }

    public void offeredCourse(String course,String section,String date,String time )
    {
        File f = null;
        FileWriter fw = null;
        try {
          
            f = new File("src/Files/CourseAdmin/offered.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
                "Course ID: "+course+
                ", Section: "+section+	
                ", Days: "+date+	
                ", Time: "+time+"\n"	
            );           
           
        } catch (IOException ex) {
            //todo
        } finally {
          try {
              if(fw != null) fw.close();
          } catch (IOException ex) {
              //todo
          }
      }
    }

    public void addContectInformation(TextArea informationtakeTextArea)
    {
        File f = null;
        FileWriter fw = null;
        try {
          
            f = new File("src/Files/CourseAdmin/contectInfo.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(	
                informationtakeTextArea.getText()+"\n"	
            );           
            informationtakeTextArea.clear();
        } catch (IOException ex) {
           //todo
        } finally {
          try {
              if(fw != null) fw.close();
          } catch (IOException ex) {
             //todo
          }
      }
    }

    public void viewnotice(Label t)
    {
        t.setText("");
        File file = new File("src/Files/Administrator/AdmissionNotice.txt");
        Scanner sc; String str=null;
        try {
            sc = new Scanner(file);
            t.setText(null);
            while(sc.hasNextLine()){
              str=sc.nextLine();
              t.setText(str+"\n");
                            
            }
        } catch (FileNotFoundException ex) {
           //todo
        }   
    }

    
}
