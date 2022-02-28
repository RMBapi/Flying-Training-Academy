package users;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import core.User;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class cadet extends User { 

    private static final long serialVersionUID = 1L;

    public cadet(String name, String username, String password, String usertype, String contact, String address) { 
        super(name, username, password, usertype, contact, address);
    }

    public cadet()
    {
        //todo
    }

    public void applyForSchlorship(String name1,String id2,String address3,String incomeSource,String salaryTextField, String persentage)
    {
        File f = null;
        FileWriter fw = null;
        try {
          
            f = new File("src/Files/Cadet/schlorship.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
                name1+","
                +id2+","	
                +address3+","
                +incomeSource+","
                +salaryTextField+","	
                +persentage+"\n"	
            );           
           
        } catch (IOException ex) {
            //TODO
        } finally {
          try {
              if(fw != null) fw.close();
          } catch (IOException ex) {
              //TODO
          }
      }
    }

    public void evaluationbycadet(String optionChosen,String s)
    {
        if (optionChosen == "Trainer")
        {
            File f = null;
            FileWriter fw = null;
            try {
              
                f = new File("src/Files/Cadet/Trainer.txt");
                if(f.exists()) fw = new FileWriter(f,true);
                else fw = new FileWriter(f);
               
                fw.write(
                     s
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
              
                f = new File("src/Files/Cadet/Academy.txt");
                if(f.exists()) fw = new FileWriter(f,true);
                else fw = new FileWriter(f);
               
                fw.write(
                   s	
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

    public void viewCourse(TextArea outputTxtArea)
    {
        File file = new File("src/Files/CourseAdmin/offered.txt");
        Scanner sc; String str=null;
        try {
            sc = new Scanner(file);
            outputTxtArea.setText(null);
            while(sc.hasNextLine()){
                str=sc.nextLine();
                outputTxtArea.appendText(str+"\n");         
            }
        } catch (FileNotFoundException ex) {
           //todo
        }   
    }

    public void addinCourse(String c,String s)
    {
        File f = null;
        FileWriter fw = null;
        try {
          
            f = new File("src/Files/Cadet/applycourse.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
               c+
               ","+s	
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


    public void viewcontacts(Label HeadoftheAca,Label addoff,Label reg)
    {
          
        File f = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("src/Files/CourseAdmin/contectInfo.txt");
            sc = new Scanner(f);
            if(f.exists()){

                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    HeadoftheAca.setText(tokens[0]);
                    addoff.setText(tokens[1]);
                    reg.setText(tokens[2]);
                                      
                    
                }
            }
            

        } 
        catch (IOException ex) {
         //todo
        } 
        finally {
            //todo
        }
    }



    
      

}