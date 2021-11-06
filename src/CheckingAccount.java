public class CheckingAccount extends  Account{

    private static double FEE =2.5;
    public CheckingAccount(){
        super();
    }
    public CheckingAccount(int accountNumber, double fee)
    {
       super(accountNumber);
       FEE =fee;
    }
    @Override
    public void deposit(double amount) {
        //FirstCheck
        if(amount > 0){
            balance += amount;
            System.out.printf("Amount deposited",amount);
            balance -= FEE;
            System.out.printf("Fee Applied",FEE);
            System.out.printf("Current Balance",balance);

        }
        else{
            System.out.println("A negative amount can't be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount >0){
            if((amount+FEE) <= balance)
            {
                System.out.printf("Amount of withdrawn from account", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of applied");
                System.out.printf("Current Balance is :", balance);
            }

        }
        else
        {
            System.out.printf("Negative amount can't be withdraw");
        }

    }
}
