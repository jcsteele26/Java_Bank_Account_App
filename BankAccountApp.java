import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    
    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();
                
        // Read CSV file and create accounts based on data
        String file = "C:\\Users\\Andre\\Documents\\JavaBankAccount\\newAccounts.txt";

        List<String[]> newCustomer = CSV.read(file);
        for(String[] holder : newCustomer) {
            //System.out.println("NEW ACCOUNT: ");
            String name = holder[0];
            String ssn = holder[1];
            String accountType = holder[2];
            double initDeposit = Double.parseDouble(holder[3]);
            //System.out.println(name + " " + ssn + " " + accountType + " " + initDeposit);

            if (accountType.trim().equals("Savings")) {   // Trim method to eliminate white space
                //System.out.println("Open a Savings Account");
                accounts.add(new Savings(name, ssn, initDeposit));
            } 
            else if (accountType.trim().equals("Checking")) {   // Trim method to eliminate white space
                //System.out.println("Open a Checking Account");
                accounts.add(new Checking(name, ssn, initDeposit));
            } 
            else {
                System.out.println("Error Reading Account Type");
            }
        }
        
        //accounts.get(5).showInfo();    Test the get info

        for (Account acc : accounts) {
            System.out.println("\n***********************************************************");
            acc.showInfo();

        }


    }
    
}