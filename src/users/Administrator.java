package users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import core.AppendableObjectOutputStream;
import core.BAccount;
import core.SchManTable;
import core.User;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class Administrator extends User { 

    private static final long serialVersionUID = 1L;

    public Administrator(String name, String username, String password, String usertype, String contact, String address) { 
        super(name, username, password, usertype, contact, address);
    }

    public Administrator()
    {
        //todo
    }

    public void accountsInformation(String acc,String trans,String debit,String crdit,String total)
    {
        File f = null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
          
            f = new File("src/Files/Administrator/Accounts.bin");
            if(f.exists()) {
                fos = new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            BAccount s=new BAccount(
                   acc,
                   trans,
                   debit,
                   crdit,
                   total);  
                
            oos.writeObject(s);
             
        } catch (IOException ex) {
            //todo
        } finally {
          try {
              if(oos != null) oos.close();
          } catch (IOException ex) {
              //todo
          }
      }
    }

    public void viewcreatedAccount(TextArea v1)
    {
        ObjectInputStream ois=null;
        try {
           BAccount s;
           ois = new ObjectInputStream(new FileInputStream("src/Files/Administrator/Accounts.bin"));
           while(true){
           s = (BAccount) ois.readObject();
           String r = s.getAccount_Type()+
                     ","+s.getTrasaction()+
                     ","+s.getDebit()+
                    ","+s.getCredit()+
                    ","+s.getTotaltaka()+"\n";
                 v1.appendText(r);
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

    public void annualrepot(String year,String fsemi,String ssemi,String tsemi)
    {
        File f = null;
        FileWriter fw = null;
        try {
          
            f = new File("src/Files/Administrator/annualreport.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	year+","+fsemi+","+ssemi+","+tsemi
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


    public void annualrepot2(String fsemiin1,String ssemiin2,String tsemiin3)
    {
        File f = null;
        FileWriter fw = null;
        try {
          
            f = new File("src/Files/Administrator/annualreport2.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	fsemiin1+","+ssemiin2+","+tsemiin3
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


    public void viewScholarshipApproveList(TextArea viewApplicantTextArea )
    {
        viewApplicantTextArea.setText("");
        File f = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("src/Files/Administrator/schship.txt");
            sc = new Scanner(f);
            if(f.exists()){

                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    viewApplicantTextArea.appendText(
                        tokens[0]
                        +","+tokens[1]
                        +","+tokens[2]+"\n"                   
                    );
                }
            }
            else 
                viewApplicantTextArea.setText("oops! file does not exist...");

        } 
        catch (IOException ex) {
            //todo
        } 
        finally {
            //todo
        }
    }


    public void viewApplicantList(TextArea viewApplicantTextArea)
    {
        viewApplicantTextArea.setText("");
        File f = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("src/Files/Cadet/schlorship.txt");
            sc = new Scanner(f);
            if(f.exists()){

                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    viewApplicantTextArea.appendText(
                        tokens[0]
                        +","+tokens[1]
                        +","+tokens[2]
                        +","+tokens[3]
                        +","+tokens[4]
                        +","+tokens[5]+"\n"                   
                    );
                }
            }
            else 
                viewApplicantTextArea.setText("oops! file does not exist...");

        } 
        catch (IOException ex) {
            //todo
        } 
        finally {
            //todo
        }
    }


public void ViewapplicantList(String addnameColumnTextField,String addidColumnTextField,String addparsentageColumnTextField,TableView<SchManTable> tableView)
{
        SchManTable newPerson = new SchManTable(addnameColumnTextField,
        addidColumnTextField,
        addparsentageColumnTextField
      );
File f = null;
FileWriter fw = null;
try {

f = new File("src/Files/Administrator/schship.txt");
if(f.exists()) fw = new FileWriter(f,true);
else fw = new FileWriter(f);

fw.write(
    addnameColumnTextField+","
    +addidColumnTextField+","	
    +addparsentageColumnTextField+"\n"	
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
tableView.getItems().add(newPerson);
}

public void createNotice(String notice,String descrip)
{
    File f = null;
    FileWriter fw = null;
    try {
      
        f = new File("src/Files/Administrator/"+notice+"Notice.txt");
        if(f.exists()) fw = new FileWriter(f,true);
        else fw = new FileWriter(f);
        fw.write(
            descrip+"\n"	
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
