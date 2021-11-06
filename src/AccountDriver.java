
import java.util.Scanner;

public class AccountDriver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Account accounts []= new Account[10];
        int numAccounts = 0;
        int choise;
        do{
            choise =menu(keyboard);
            System.out.println();
            if(choise ==1){
                accounts[numAccounts++] =createAccount(keyboard);
            }else if(choise == 2)
            {
                doDeposit(accounts, numAccounts, keyboard);
            }else if(choise == 3){
                doWithdraw(accounts,numAccounts,keyboard);
            }else if(choise ==4){
                applyInterest(accounts,numAccounts,keyboard);
            }
            else{
                System.out.println("GooodBye");
            }
        }while (choise != 5);

    }
    public static int accountMenu(Scanner keyboard){
        System.out.printf("Select Account Type");
        System.out.printf("1. Checking Account");
        System.out.printf("2. Saving Account");

        int choise;
        do{
            System.out.printf("Enter chosie");
            choise = keyboard.nextInt();

        } while(choise < 1 || choise > 2);
        return choise;
    }
    public static int searchAccount(Account accounts[], int count, int accountnumber){
        for (int i=0;i<count; i++){
            if(accounts[i].getAccountNumber() == accountnumber){
                return i;
            }
        }
        return -1;
    }
    /**
     * Function to perform Deposit on i selected account
     */
    public static void doDeposit(Account accounts [], int count, Scanner keyboard){
        //Get the account number
        System.out.printf("Please enter account number: ");
       int accountNumber =keyboard.nextInt();

       //search for account
        int index = searchAccount(accounts,count ,accountNumber);

        //Amount
        if(index >= 0){
            System.out.printf("Please enter deposit amount: ");
            double amount = keyboard.nextDouble();
            accounts[index].deposit(amount);
        }else{
            System.out.printf("No acccount exist with Account number: "+accountNumber);
        }
    }
    public static void doWithdraw(Account accounts[] , int count, Scanner keyboard)
    {
        //Get the account number
        System.out.printf("Please enter account number: ");
        int accountNumber =keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts,count ,accountNumber);

        //Amount
        if(index >= 0){
            System.out.printf("Please enter withdraw amount: ");
            double amount = keyboard.nextDouble();
            accounts[index].withdraw(amount);
        }else{
            System.out.printf("No acccount exist with Account number: "+accountNumber);
        }
    }
    public static void applyInterest(Account accounts[], int count, Scanner keyboard){
        //Get the account number
        System.out.printf("Please enter account number: ");
        int accountNumber =keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts,count ,accountNumber);

        //Amount
        if(index >= 0){
            if(accounts[index] instanceof SavingAccount) {
                ((SavingAccount)accounts[index]).applyInterest();
            }
        }else{
            System.out.printf("No acccount exist with Account number: "+accountNumber);
        }

    }


    public static Account createAccount(Scanner keyboard)
    {
        Account account = null;
        int choise = accountMenu(keyboard);
        int accountNumber;
        System.out.printf("Enter your number: ");
        accountNumber = keyboard.nextInt();
        if(choise == 1){//Checking account
            System.out.printf("Enter transaction fee: ");
            double fee = keyboard.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        }
        else{ //Saving Account
            System.out.printf("Please enter Interest Rate: ");
            double ir = keyboard.nextDouble();
            account = new SavingAccount(accountNumber, ir);
        }
        return account;
    }

    public static int menu(Scanner keyboard){
        System.out.printf("Bank Account Menu");
        System.out.printf("1. Create New Account");
        System.out.printf("2. Deposit Funds");
        System.out.printf("3. Withdraw Funds");
        System.out.printf("4.Apply Interest");
        System.out.printf("5.Quit");
        int choise;
        do{
            System.out.printf("Enter chosie");
            choise = keyboard.nextInt();

        } while(choise < 1 || choise > 5);
        return choise;
    }
}
