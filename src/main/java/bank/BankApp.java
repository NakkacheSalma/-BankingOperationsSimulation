package bank;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

//public class BankApp {
//
//    public static void main(String[] args) {
//
//
//        BusinessAccount accB = new BusinessAccount(2000,"id1");
//        SavingsAccount accS = new SavingsAccount(4000,"id2");
//        CheckingAccount accC = new CheckingAccount(6000,"id3");
//
//        accB.displayInfo();
//        accS.displayInfo();
//        accC.displayInfo();
//
//        accB.deposit(100);
//        try{
//            accS.withdraw(5000);
//        }catch(Exception e){
//            System.out.println(e);
//        }
//
//    }
//}



public class BankApp extends Application {

    BusinessAccount accB;
    SavingsAccount accS;
    CheckingAccount accC;
    BankAccount selectedAccount;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bank Application");

        // Welcome label
        Label welcomeLabel = new Label("Welcome to My Bank!");

        // Dropdown for account type
        ComboBox<String> accountOptions = new ComboBox<>();
        accountOptions.getItems().addAll("BusinessAccount", "SavingsAccount", "CheckingAccount");

        // TextField for initial balance input
        TextField balanceInput = new TextField();
        balanceInput.setPromptText("Enter initial balance");

        // Label to display account info
        Label accountInfoLabel = new Label();

        // Buttons for actions
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        TextField amountInput = new TextField();
        amountInput.setPromptText("Enter amount");

        // Layout setup
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                welcomeLabel,
                accountOptions,
                balanceInput,
                accountInfoLabel,
                amountInput,
                depositButton,
                withdrawButton
        );

        // Event for selecting an account type and entering balance
        accountOptions.setOnAction(event -> {
            String accountType = accountOptions.getValue();
            if (accountType != null) {
                try {
                    // Parse balance input
                    double balance = Double.parseDouble(balanceInput.getText());

                    // Instantiate the selected account type
                    switch (accountType) {
                        case "BusinessAccount" -> {
                            accB = new BusinessAccount(balance, "idB");
                            selectedAccount = accB;
                        }
                        case "SavingsAccount" -> {
                            accS = new SavingsAccount(balance, "idS");
                            selectedAccount = accS;
                        }
                        case "CheckingAccount" -> {
                            accC = new CheckingAccount(balance, "idC");
                            selectedAccount = accC;
                        }
                    }

                    // Display account information
                    accountInfoLabel.setText("Selected Account: " + accountType + "\nBalance: " + balance);
                } catch (NumberFormatException e) {
                    accountInfoLabel.setText("Please enter a valid balance amount.");
                }
            }
        });

        // Deposit button action
        depositButton.setOnAction(event -> {
            if (selectedAccount != null) {
                try {
                    double amount = Double.parseDouble(amountInput.getText());
                    selectedAccount.deposit(amount);
                    accountInfoLabel.setText("Deposited: " + amount + "\nNew Balance: " + selectedAccount.getBalance());
                } catch (NumberFormatException e) {
                    accountInfoLabel.setText("Please enter a valid deposit amount.");
                }
            } else {
                accountInfoLabel.setText("Please select an account first.");
            }
        });

        // Withdraw button action
        withdrawButton.setOnAction(event -> {
            if (selectedAccount != null) {
                try {
                    double amount = Double.parseDouble(amountInput.getText());
                    selectedAccount.withdraw(amount);
                    accountInfoLabel.setText("Withdrew: " + amount + "\nNew Balance: " + selectedAccount.getBalance());
                } catch (NumberFormatException e) {
                    accountInfoLabel.setText("Please enter a valid withdrawal amount.");
                } catch (Exception e) {
                    accountInfoLabel.setText("Error: " + e.getMessage());
                }
            } else {
                accountInfoLabel.setText("Please select an account first.");
            }
        });

        // Set up the scene
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}