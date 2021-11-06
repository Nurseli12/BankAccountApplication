public class SavingAccount extends Account {
    //interest rate
    private double interestRate;
    public SavingAccount(){
        super();
    }

    /**
     * Parameter constructor to intialize Savings account with a customer account
     * number and interest rate
     */
    public SavingAccount(int accountNumber,double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }
    public double calcInterest(){
        return balance * interestRate;
    }
    public void applyInterest(){
        double interest = calcInterest();
        System.out.printf("Interest amount added to balance",interest);
        deposit(interest);
    }
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if(amount > 0){
            balance += amount;
            System.out.printf("Amount deposited",amount);
            System.out.printf("Current Balance",balance);

        }
        else{
            System.out.println("A negative amount can't be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount >0){
            if((amount) <= balance)
            {
                System.out.printf("Amount of withdrawn from account", amount);
                balance -= amount;
                System.out.printf("Current Balance is :", balance);
            }

        }
        else
        {
            System.out.printf("Negative amount can't be withdraw");
        }


    }
}
