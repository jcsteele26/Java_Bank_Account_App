public class Savings extends Account{

    // List properties specific to Savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    // Constructor to initialize Savings account properties
    public Savings(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        acctNumber = "1" + acctNumber;
        setSafetyDepositBox();
    }

    // Access to interface interest base rate
    @Override
    public void setRate(){
        rate = getBaseRate() - .25;
    }

    // List any methods specific to Savings account
    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));

    }


    public void showInfo(){
        //System.out.println("Account Type: Savings");
        super.showInfo();
        System.out.println("Your Savings Account Features: " + 
                           "\n   Safety Deposit Box ID: " + safetyDepositBoxID + 
                           "\n   Safety Deposit Box KEY: " + safetyDepositBoxKey);
        
    }
    
}