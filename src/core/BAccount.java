package core;

import java.io.Serializable;


public class BAccount implements Serializable {
    String account_Type;
    String trasaction;  
    String debit;
    String credit;
    String totaltaka;

    
    public BAccount(String account_Type,String trasaction,String debit,String credit,String totaltaka) {  
        this.account_Type=account_Type;
        this.trasaction=trasaction;
        this.debit = debit;  
        this.credit = credit;
        this.totaltaka = totaltaka;
    }
    
    public void setAccount_Type(String account_Type) {
        this.account_Type = account_Type;
    }

    public void setTrasaction(String trasaction) {
        this.trasaction = trasaction;
    }
    public void setDebit(String debit) {
        this.debit = debit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
    
    public void setTotaltaka(String totaltaka) {
        this.totaltaka = totaltaka;
    }
     
    public String getAccount_Type() {
        return account_Type;
    }

    public String getTrasaction() {
        return trasaction;
    }
    public String getDebit() {
        return debit;
    }

    public String getCredit() {
        return credit;
    }
    
    public String getTotaltaka() {
        return totaltaka;
    }
    
    @Override
    public String toString(){
        return "Account_Type="+account_Type+",Trasaction="+trasaction+", Debit="+debit+", Credit="+credit+", Totaltaka="+totaltaka;
    }
    
    public void display(){
        System.out.println("Account_Type="+account_Type+",Trasaction="+trasaction+", Debit="+debit+", Credit="+credit+", Totaltaka="+totaltaka);
    }
}
