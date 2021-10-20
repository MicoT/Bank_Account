package BankAccount.Bank_Account;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import javax.swing.JOptionPane;

public class POS {
    public static void main(String[] args) {
        String name = "";
        String orders = "";
        String receipt = "\t***ABC Foods***"+
                         "\n\t\t\tDavao City\n\n"+
                         "Items                 Qty                Subtotal\n";
        int choice;
        double qty;
        int index=0; 

        String products[] = {"Burger","French Fries","Coke"};
        double price[] = {100.0,80.0,50.0};
        double total = 0.0;
        double subtotal = 0.0;
        double cash = 0.0;
        double change = 0.0;

        name = JOptionPane.showInputDialog("Please enter your name: ");
        String menu = "Hello "+name+"!\n\n"+
                    "ABC FOODS\n\n"+
                    "\n1 - Burger \t100.00"+
                    "\n2 - FrenchFries \t80.00"+
                    "\n3 - Coke \t50.00"+
                    "\n4 - Exit"+
                    "\n\nEnter your choice: ";
        
        do{
        choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
        
        if(choice!=4){
            qty = Double.parseDouble(JOptionPane.showInputDialog("Enter quantity: "));

            index = choice-1;
            subtotal+=price[index]*qty;
            orders+=products[index]+"             "+qty+"                "+subtotal+"\n";

            total+=subtotal;
        }
        else
            break;
        }while(choice!=4);
        String msg1 = "The total is "+total+".\nEnter Cash Tendered: ";
        cash = Double.parseDouble(JOptionPane.showInputDialog(msg1));
        change = cash - total;

        double exVAT;
        exVAT = (total*8);
         DecimalFormat df2 = new DecimalFormat("0.00");
         String exVATStr =df2.format(exVAT);
         exVAT = Double.valueOf(exVATStr);
        
        double vat;
        vat = (total-exVAT);
         DecimalFormat df3 = new DecimalFormat("0.00");
         String vatStr =df3.format(vat);
         vat = Double.valueOf(vatStr);

        receipt+=orders;
        receipt+="\nTotal:                            "+total;
        receipt+="\nCash Tendered:        "+cash;
        receipt+="\nnexVAT:                     "+exVAT;
        receipt+="\nnVAT:                       "+vat;
        receipt+="\nChange:                       "+change;
        receipt+="\nDate of Purchase:             "+java.time.LocalDate.now();
        JOptionPane.showMessageDialog(null, receipt);

        System.out.println(name);
        System.out.println(choice);
    }
}
