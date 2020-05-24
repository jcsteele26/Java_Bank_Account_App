public abstract class Account implements iBaseRate{

    // List common properties for Checking and Savings
    private String name;
    private String ssn;
    private double balance;

    protected String acctNumber;
    protected double rate;

    private static int index = 10000;

    // Constructor to set base properties and initialize account
    public Account(String name, String ssn, double initDeposit){
        //System.out.println("Name: " + name);
        //System.out.println("New Account");
        this.name = name;
        this.ssn = ssn;
        balance = initDeposit;

       // System.out.println(name + " " + ssn + " " +initDeposit);

        // Set account number
        index++;
        this.acctNumber = setAccountNumber();
        //System.out.println("Account Number : " + this.acctNumber);

        setRate(); // Call for rate instead of children classes calling 
                
    }

    public abstract void setRate(); //Checking and Savings must implement this method

    // Set account number
    private String setAccountNumber(){
        String lastTwoOfSSN = ssn.substring(ssn.length()-2, ssn.length());
        int uniqueID = index;
        int randomNumber = (int)(Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    // Set compound interest rate
    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest = $" + accruedInterest);
        printBalance();
    }
    
    // List common methods transactions
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Deposit = $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdraw Amount = $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfer $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your Balance is: $" + balance);
    }

    public void showInfo(){
        System.out.println("Name: " + name +
                           "\nAccount Number: " + acctNumber +
                           "\nBalance: " + balance + 
                           "\nInterest Rate: " + rate + "%");

    }


}