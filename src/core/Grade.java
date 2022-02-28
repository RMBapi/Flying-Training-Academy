package core;

import java.io.Serializable;


public class  Grade implements Serializable {
    String id;
    String sec;  
    String grad;

    public Grade(String id,String sec,String grad) {  
        this.id=id;
        this.sec=sec;
        this.grad = grad;  
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setSec(String sec) {
        this.sec = sec;
    }
    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getId() {
        return id;
    }
    
    public String getSec() {
        return sec;
    }
    public String getGrad() {
        return grad;
    }
    
    
    @Override
    public String toString(){
        return "ID ="+id+",Section="+sec+", Grade="+grad;
    }
    
    public void display(){
        System.out.println("ID ="+id+",Section="+sec+", Grade="+grad);
    }
}