public class Checking extends Account{

    // List properties specific to Checking account
    private int debitCardNumber;
    private int debitCardPin;


    // Constructor to initialize Checking account properties
    public Checking(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        acctNumber = "2" + acctNumber;
        setDebitCard();

    }

    // Access to interface interest base rate 
    @Override
    public void setRate(){
        rate = getBaseRate() * .15;

    }

    // List any methods specific to Checking account
    private void setDebitCard(){
        debitCardNumber = (int)(Math.random() * Math.pow(10, 12));
        debitCardPin = (int)(Math.random() * Math.pow(10, 4));
        
    }

    public void showInfo(){
        //System.out.println("Account Type: Checking");
        super.showInfo();        
        System.out.println("Your Checking Account Features: " + 
                           "\n   Debit Card Number: " + debitCardNumber + 
                           "\n   Debit Card PIN: " + debitCardPin);
    }
    
}