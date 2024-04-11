
import java.util.*;

class SavingGoal {
    int amount;
    String deadline;
    String goalMotive;

    public SavingGoal(int amount, String deadline, String goalMotive) {
        this.amount = amount;
        this.deadline = deadline;
        this.goalMotive = goalMotive;
    }
}

class BudgetPlan {
    int amount;
    int amountnow;
    String event;
    String eventDeadline;

    public BudgetPlan(int amount, int amountnow, String event, String eventDeadline) {
        this.amount = amount;
        this.amountnow = amountnow;
        this.event = event;
        this.eventDeadline = eventDeadline;
    }
}

class Expense {
    int amount;
    String date;
    String reason;

    public Expense(int amount, String date, String reason) {
        this.amount = amount;
        this.date = date;
        this.reason = reason;
    }
}

class SavingChallenge {
    int amount;
    int timeDays;
    String status;

    public SavingChallenge(int amount, int timeDays, String status) {
        this.amount = amount;
        this.timeDays = timeDays;
        this.status = status;
    }
}

class User {
    String name;
    String email;
    String password;
    ArrayList<SavingGoal> savingGoals;
    ArrayList<BudgetPlan> budgetPlans;
    ArrayList<Expense> expenses;
    ArrayList<SavingChallenge> savingChallenges;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.savingGoals = new ArrayList<>();
        this.budgetPlans = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.savingChallenges = new ArrayList<>();
    }

    // Methods to add saving goals, budget plans, expenses, saving challenges, etc.
    // can be added here
}

public class PiggyBank {

    public static ArrayList<User> AllUsers = new ArrayList<>();

    private static int choiceasker() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("1. NewUser Register");
        System.out.println("2. Go to Saving Goals");
        System.out.println("3. Go to Budget Plans");
        System.out.println("4. Go to Your expenses");
        System.out.println("5. Check your Saving Challenges");
        choice = sc.nextInt();
        //donot close the scanner
        return choice;
    }

    private static void worker() {
        Scanner sc = new Scanner(System.in);
        int choice = choiceasker();

        switch (choice) {

            /***********************************************************************************/
            case 1: // REGISTERING A NEW USER
                System.out.println("Enter name : ");
                String name = sc.nextLine();
                System.out.println("Enter email : ");
                String email = sc.nextLine();
                System.out.println("Enter your password : ");
                String password = sc.nextLine();
                System.out.println("Confirm password : ");
                String confirmPassword = sc.nextLine();

                if (password.equals(confirmPassword)) {
                    User obj1 = new User(name, email, password);
                    AllUsers.add(obj1);
                    System.out.println(AllUsers.size());
                    System.out.println("USER ADDED SUCCESFULLY!\n" + obj1.name + " " + obj1.email);
                } else {
                    System.out.println("Password confirmation Failed");
                    break;
                }
                break;

            /***********************************************************************************/
            case 2: // SAVING GOALS
                System.out.println("***** WELCOME TO SAVING GOALS *****");

                System.out.println("Enter email to continue : "); // General email entrance for SAVING GOALS
                String userEmail = sc.nextLine();
                User user = null;
                // System.out.println(AllUsers.size());
                for (User u : AllUsers) {
                    // System.out.println(u.email);
                    if (u.email.equals(userEmail)) {
                        user = u;
                        break;
                    }
                }
                // INVALID USER CHECK IN SAVING GOALS
                if (user == null) {
                    System.out.println("No such User!!!");
                    break;
                }
                int choice2 = 0;
                System.out.println("1 . Create Goal");
                System.out.println("2 . Update Goal");
                System.out.println("3 . Delete Goal");
                System.out.println("4 . Display Goals");
                System.out.println("5 . Restart missed Goal (under process...)");
                choice2 = sc.nextInt();

                switch (choice2) {

                    case 1: // Create saving goals
                        if (user != null) {
                            System.out.println("Enter details for the Saving Goals");
                            while (true) {
                                System.out.println("Enter amount: ");
                                int amount = sc.nextInt();
                                sc.nextLine(); // Consume newline char bcoz i din use println
                                System.out.println("Enter deadline (YYYY-MM-DD): ");
                                String deadline = sc.nextLine();
                                System.out.println("Enter goal motive: ");
                                String motive = sc.nextLine();

                                user.savingGoals.add(new SavingGoal(amount, deadline, motive));
                                System.out.println("SAVING GOAL ADDED SUCCESFULLY!!!");

                                System.out.println("Do you want to add another saving goal? (yes/no): ");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }

                        break;

                    case 2: // update saving goals
                        if (user != null) {
                            while (true) {
                                System.out.println("Existing Saving Goals:");
                                for (int i = 0; i < user.savingGoals.size(); i++) {
                                    SavingGoal goal = user.savingGoals.get(i);
                                    System.out.println("Index: " + i + ", Amount: " + goal.amount + ", Deadline: "
                                            + goal.deadline + ", Motive: " + goal.goalMotive);
                                }
                                System.out.println("Enter the index of the Saving Goal to update ");
                                int index = sc.nextInt();
                                if (index >= 0 && index < user.savingGoals.size()) {
                                    System.out.println("Enter details to update");
                                    System.out.println("Enter amount : ");
                                    int amount = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Enter deadline (YYYY-MM-DD): ");
                                    String deadline = sc.nextLine();
                                    System.out.println("Enter goal motive: ");
                                    String motive = sc.nextLine();
                                    SavingGoal updatedGoal = new SavingGoal(amount, deadline, motive);
                                    user.savingGoals.set(index, updatedGoal);
                                    System.out.println("UPDATED SUCCESFULLY!!!");
                                } else {
                                    System.out.println("Index out of Range !");
                                }

                                System.out.println("Do you want to update another saving goal? (yes/no): ");
                                String continueChoice = sc.nextLine();
                                if (!continueChoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }

                        }
                        break;

                    case 3: // Delete saving goals
                        if (user != null) {
                            while (true) {
                                if (user.savingGoals.size() != 0) {
                                    System.out.println("Existing Saving Goals:");
                                    for (int i = 0; i < user.savingGoals.size(); i++) {
                                        SavingGoal goal = user.savingGoals.get(i);
                                        System.out.println("Index: " + i + ", Amount: " + goal.amount + ", Deadline: "
                                                + goal.deadline + ", Motive: " + goal.goalMotive);
                                    }
                                } else {
                                    System.out.println("No existing Saving Goals");
                                    sc.nextLine();
                                    break;
                                }
                                System.out.println("Enter the index of the Saving Goal to Delete ");
                                int index = sc.nextInt();
                                if (index >= 0 && index < user.savingGoals.size()) {
                                    user.savingGoals.remove(index);
                                    System.out.println("SAVING GOAL DELETED SUCCESSFULLY");
                                } else {
                                    System.out.println("Index out of range!!!");
                                }
                                System.out.println("Do you want to delete another saving goal? (yes/no): ");
                                String continueChoice = sc.nextLine();
                                if (!continueChoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }
                        break;

                    case 4: // Display all saving goals

                        if (user != null) {
                            if (user.savingGoals.size() != 0) {
                                System.out.println("Existing Saving Goals:");
                                for (int i = 0; i < user.savingGoals.size(); i++) {
                                    SavingGoal goal = user.savingGoals.get(i);
                                    System.out.println("Index: " + i + ", Amount: " + goal.amount + ", Deadline: "
                                            + goal.deadline + ", Motive: " + goal.goalMotive);
                                }
                            } else {
                                System.out.println("No existing Saving Goals!!!");
                                sc.nextLine();
                                break;
                            }
                            sc.nextLine();
                        }
                        break;

                    case 5: // Restart missed saving goal

                        break;

                    default:
                        System.out.println("INVALID CHOICE");
                        break;
                }
                break;

            /***********************************************************************************/
            case 3: // BUDGET PLANS
                System.out.println("***** WELCOME TO BUDGET PLANNER *****");

                System.out.println("Enter email to continue : "); // GET THE USER FOR WHICH OPERATIONS HAS TO BE DONE
                userEmail = sc.nextLine();
                user = null;
                // System.out.println(AllUsers.size());
                for (User u : AllUsers) {
                    // System.out.println(u.email);
                    if (u.email.equals(userEmail)) {
                        user = u;
                        break;
                    }
                }
                // INVALID USER CHECK IN SAVING GOALS
                if (user == null) {
                    System.out.println("No such User!!!");
                    break;
                }
                int choice3 = 0;
                System.out.println("1 . Create Budget Plan");
                System.out.println("2 . Update Budget Plan");
                System.out.println("3 . Delete Budget Plan");
                System.out.println("4 . Track your budget plans (under process...)");
                choice3 = sc.nextInt();
                switch (choice3) {
                    case 1: // CREATE BUDGET PLAN
                        if (user != null) {
                            System.out.println("Enter details for adding new Budget Plans");
                            while (true) {
                                System.out.println("Enter amount: ");
                                int amount = sc.nextInt();
                                sc.nextLine(); // Consume newline char bcoz i din use println
                                System.out.println("Enter amount currently in hand: ");
                                int amountnow = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter the Event for which you are planning Budget :  ");
                                String event = sc.nextLine();
                                System.out.println("Enter deadline (YYYY-MM-DD) : ");
                                String eventDeadline = sc.nextLine();

                                user.budgetPlans.add(new BudgetPlan(amount, amountnow, event, eventDeadline));
                                System.out.println("BUDGET PLAN ADDED SUCCESFULLY!!!");

                                System.out.println("Do you want to create another budget plan? (yes/no): ");
                                String continueChoice = sc.nextLine();
                                if (!continueChoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }
                        break;

                    case 2: // UPDATE BUDGET PLAN
                        if (user != null) {
                            while (true) {
                                if (user.budgetPlans.size() != 0) {
                                    System.out.println("Existing Budget plans :");
                                    for (int i = 0; i < user.budgetPlans.size(); i++) {
                                        BudgetPlan plan = user.budgetPlans.get(i);
                                        System.out.println("Index: " + i + ", Amount: " + plan.amount + ", Amount Now:"
                                                + plan.amountnow + ", Event : " + plan.event + ", Event Deadline : "
                                                + plan.eventDeadline);
                                    }
                                } else {
                                    System.out.println("No existing Budget Plans");
                                    sc.nextLine();
                                    break;
                                }
                                System.out.println("Enter the index of the Budget Plan to Update ");
                                int index = sc.nextInt();
                                if (index >= 0 && index < user.budgetPlans.size()) {
                                    System.out.println("Enter details to update");
                                    System.out.println("Enter Amount : ");
                                    int amount = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Enter Amount Now: ");
                                    int amountnow = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Enter the Event for which you are planning Budget :  ");
                                    String event = sc.nextLine();
                                    System.out.println("Enter Event deadline (YYYY-MM-DD): ");
                                    String eventDeadline = sc.nextLine();

                                    BudgetPlan updatBudgetPlan = new BudgetPlan(amount, amountnow, event,
                                            eventDeadline);
                                    user.budgetPlans.set(index, updatBudgetPlan);
                                    System.out.println("UPDATED SUCCESFULLY!!!");
                                } else {
                                    System.out.println("INVALID CHOICE");
                                    sc.nextLine();
                                    break;
                                }
                                System.out.println("Do you want to update another Budget Plan ? (yes/no)");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }

                        break;
                    case 3: // DELETE BUDGET PLAN
                        if (user != null) {
                            while (true) {
                                if (user.budgetPlans.size() != 0) {
                                    System.out.println("Existing Budget plans :");
                                    for (int i = 0; i < user.budgetPlans.size(); i++) {
                                        BudgetPlan plan = user.budgetPlans.get(i);
                                        System.out.println("Index: " + i + ", Amount: " + plan.amount + ", Amount Now:"
                                                + plan.amountnow + ", Event : " + plan.event + ", Event Deadline : "
                                                + plan.eventDeadline);
                                    }
                                } else {
                                    System.out.println("No existing Budget Plans");
                                    sc.nextLine();
                                    break;
                                }
                                System.out.println("Enter the index of the Budget Plan to Delete ");
                                int index = sc.nextInt();
                                if (index >= 0 && index < user.budgetPlans.size()) {
                                    user.budgetPlans.remove(index);
                                    System.out.println("BUDGET PLAN DELETED SUCCESFULLY");
                                } else {
                                    System.out.println("Index out of range!!!");
                                }
                                sc.nextLine();
                                System.out.println("Do you want to delete another budget plan? (yes/no): ");
                                String continueChoice = sc.nextLine();
                                if (!continueChoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }

                        break;
                    case 4: // TRACK YOUR BUDGET PLAN

                        break;
                    default:
                        System.out.println("INVALID CHOICE");
                        break;
                }

                break;
            /***********************************************************************************/
            case 4: // EXPENSES
                System.out.println("***** WELCOME TO EXPENSE TRACKER *****");

                System.out.println("Enter email to continue : "); // General email entrance for SAVING GOALS
                userEmail = sc.nextLine();
                user = null;
                // System.out.println(AllUsers.size());
                for (User u : AllUsers) {
                    // System.out.println(u.email);
                    if (u.email.equals(userEmail)) {
                        user = u;
                        break;
                    }
                }
                // INVALID USER CHECK IN SAVING GOALS
                if (user == null) {
                    System.out.println("No such User!!!");
                    break;
                }
                int choice4 = 0;
                System.out.println("1 . Create Expense");
                System.out.println("2 . Update Expense");
                System.out.println("3 . Delete Expense");
                System.out.println("4 . Display Expenses");
                choice4 = sc.nextInt();

                switch (choice4) {

                    case 1: // ADD EXPENSES
                        if (user != null) {
                            System.out.println("Enter details for adding Expenses");
                            while (true) {
                                System.out.println("Enter amount: ");
                                int amount = sc.nextInt();
                                sc.nextLine(); // Consume newline char bcoz i din use println
                                System.out.println("Enter date (YYYY-MM-DD): ");
                                String date = sc.nextLine();
                                System.out.println("Enter reason of expense: ");
                                String reason = sc.nextLine();

                                user.expenses.add(new Expense(amount, date, reason));
                                System.out.println("EXPENSE ADDED SUCCESFULLY!!!");

                                System.out.println("Do you want to add another expense? (yes/no): ");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }
                        break;
                    case 2: // UPDATE EXEPNSE
                        if (user != null) {
                            System.out.println("Enter details for adding Expenses");
                            while (true) {
                                if (user.expenses.size() != 0) {
                                    System.out.println("Existing Saving Goals:");
                                    for (int i = 0; i < user.expenses.size(); i++) {
                                        Expense expense = user.expenses.get(i);
                                        System.out.println("Index: " + i + ", Amount: " + expense.amount + ", Date: "
                                                + expense.date + ", Reason: " + expense.reason);
                                    }
                                } else {
                                    System.out.println("No Expenses available to update !!!");
                                    sc.nextLine();
                                    break;
                                }

                                int index = 0;
                                System.out.println("Enter the index of the Expense to update : ");
                                index = sc.nextInt();
                                if (index >= 0 && index < user.expenses.size()) {
                                    System.out.println("Enter amount: ");
                                    int amount = sc.nextInt();
                                    sc.nextLine(); // Consume newline char bcoz i din use println
                                    System.out.println("Enter date (YYYY-MM-DD): ");
                                    String date = sc.nextLine();
                                    System.out.println("Enter reason of expense: ");
                                    String reason = sc.nextLine();

                                    Expense upadatedexpense = new Expense(amount, date, reason);
                                    user.expenses.set(index, upadatedexpense);
                                    System.out.println("EXPENSE UPDATED SUCCESFULLY");

                                } else {
                                    System.out.println("INVALID CHOICE");
                                    break;
                                }

                                System.out.println("Do you want to update another expense? (yes/no): ");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }

                        break;
                    case 3: // DELETE EXPENSE
                        if (user != null) {
                            while (true) {
                                if (user.expenses.size() != 0) {
                                    System.out.println("Existing Saving Goals:");
                                    for (int i = 0; i < user.expenses.size(); i++) {
                                        Expense expense = user.expenses.get(i);
                                        System.out.println("Index: " + i + ", Amount: " + expense.amount + ", Date: "
                                                + expense.date + ", Reason: " + expense.reason);
                                    }
                                } else {
                                    System.out.println("No Updates on Expenses!!!");
                                    break;
                                }
                                sc.nextLine();
                                int index = 0;
                                System.out.println("Enter the index of the Expense to delete : ");
                                index = sc.nextInt();
                                if (index >= 0 && index < user.expenses.size()) {
                                    user.expenses.remove(index);
                                    System.out.println("EXEPENSE DELETED SUCCESSFULLY !!!");
                                    sc.nextLine();
                                } else {
                                    System.out.println("INVALID CHOICE");
                                    sc.nextInt();
                                    break;
                                }
                                System.out.println("Do you want to delete another expense? (yes/no): ");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }

                        break;
                    case 4: // DISPLAY EXPENSES
                        if (user != null) {
                            if (user.expenses.size() != 0) {
                                System.out.println("Existing Saving Goals:");
                                for (int i = 0; i < user.expenses.size(); i++) {
                                    Expense expense = user.expenses.get(i);
                                    System.out.println("Index: " + i + ", Amount: " + expense.amount + ", Date: "
                                            + expense.date + ", Reason: " + expense.reason);
                                }
                            } else {
                                System.out.println("No Updates on Expenses!!!");
                                sc.nextLine();
                                break;
                            }
                            sc.nextLine();
                        }

                        break;

                    default:
                        System.out.println("INVALID CHOICE");
                        sc.nextLine();
                        break;
                }

                break;

            /***********************************************************************************/
            case 5: // SAVING CHALLENGES
                System.out.println("***** WELCOME TO SAVING CHALLENGES *****");

                System.out.println("Enter email to continue : "); // General email entrance for SAVING GOALS
                userEmail = sc.nextLine();
                user = null;

                for (User u : AllUsers) {
                    if (u.email.equals(userEmail)) {
                        user = u;
                        break;
                    }
                }
                // INVALID USER CHECK IN SAVING GOALS
                if (user == null) {
                    System.out.println("No such User!!!");
                    break;
                }
                int choice5 = 0;
                System.out.println("1 . Create New Challenge");
                System.out.println("2 . Track progress (under process...)");
                System.out.println("3 . Pause Challenge");
                System.out.println("4 . Continue Challenge");
                System.out.println("5 . Exit Challenge");
                System.out.println("6 . Update Completed challenge");
                choice5 = sc.nextInt();
                switch (choice5) {
                    case 1: // Create New Challenge
                        if (user != null) {
                            while (true) {
                                System.out.println("Enter the details of the challenge you want to join");
                                System.out.println("Enter amount: ");
                                int amount = sc.nextInt();
                                sc.nextLine();
                                System.out.println("How many day Challenge is it (from current day) ?");
                                int timeDays = sc.nextInt();
                                String status = "Ongoing";
                                System.out.println("What is the current status of your challenge ?");
                                int st = 0;
                                System.out.println("1.Completed");
                                System.out.println("2.Ongoing");
                                System.out.println("3.Missed");
                                st = sc.nextInt();
                                switch (st) {
                                    case 1:
                                        status = "Completed";
                                        break;
                                    case 2:
                                        status = "Ongoing";
                                        break;
                                    case 3:
                                        status = "Missed";
                                        break;
                                    default:
                                        System.out.println("No such status choice !");
                                        break;
                                }
                                SavingChallenge savingChallenge = new SavingChallenge(amount, timeDays, status);
                                user.savingChallenges.add(savingChallenge);
                                sc.nextLine();

                                System.out.println("Do you want to add another challenge? (yes/no): ");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }
                        break;

                    case 2: // Track progress
                        if (user != null) {
                            if (user.savingChallenges.size() != 0) {
                                System.out.println("Existing Saving Challenges :");
                                for (int i = 0; i < user.savingChallenges.size(); i++) {
                                    SavingChallenge savingChallenge = user.savingChallenges.get(i);
                                    System.out.println("Index: " + i + ", Amount: " + savingChallenge.amount
                                            + ", Days : "
                                            + savingChallenge.timeDays + ", Status : " + savingChallenge.status);
                                }
                                sc.nextLine();
                            } else {
                                System.out.println("No Current Challenges in your profile !!!");
                                sc.nextLine();
                                break;
                            }
                        }
                        break;

                    case 3: // Pause Challenge

                        if (user != null) {
                            while (true) {
                                if (user.savingChallenges.size() != 0) {
                                    System.out.println("Existing Saving Challenges :");
                                    for (int i = 0; i < user.savingChallenges.size(); i++) {
                                        SavingChallenge savingChallenge = user.savingChallenges.get(i);
                                        System.out.println("Index: " + i + ", Amount: " + savingChallenge.amount
                                                + ", Days : "
                                                + savingChallenge.timeDays + ", Status : " + savingChallenge.status);
                                    }
                                } else {
                                    System.out.println("No Current Challenges in your profile !!!");
                                    break;
                                }
                                sc.nextLine();
                                int index = 0;
                                System.out.println("Enter the index of the Saving Challenge to Pause : ");
                                index = sc.nextInt();
                                if (index >= 0 && index < user.savingChallenges.size()) {
                                    user.savingChallenges.get(index).status = "Paused";
                                    System.out.println(
                                            "PAUSED SAVING CHALLENGE SUCCESSFULLY [feel free to continue it any time :) ] !!!");
                                    sc.nextLine();
                                } else {
                                    System.out.println("INVALID CHOICE");
                                    sc.nextInt();
                                    break;
                                }
                                System.out.println(
                                        "Do you want to pause any another Challenge [better not to, it's OK to feel hard but Don't Give Up :)]? (yes/no): ");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }
                        break;

                    case 4: // CONTINUE CHALLENGE
                        if (user != null) {
                            while (true) {
                                if (user.savingChallenges.size() != 0) {
                                    System.out.println("Existing Saving Challenges :");
                                    for (int i = 0; i < user.savingChallenges.size(); i++) {
                                        SavingChallenge savingChallenge = user.savingChallenges.get(i);
                                        System.out.println("Index: " + i + ", Amount: " + savingChallenge.amount
                                                + ", Days : "
                                                + savingChallenge.timeDays + ", Status : " + savingChallenge.status);
                                    }
                                } else {
                                    System.out.println("No Current Challenges in your profile !!!");
                                    break;
                                }
                                sc.nextLine();
                                int index = 0;
                                System.out.println("Enter the index of the Saving Challenge to Continue : ");
                                index = sc.nextInt();
                                if (index >= 0 && index < user.savingChallenges.size()) {
                                    user.savingChallenges.get(index).status = "Ongoing";
                                    System.out.println("CONTINUED SAVING CHALLENGE SUCCESSFULLY !!!");
                                    sc.nextLine();
                                } else {
                                    System.out.println("INVALID CHOICE");
                                    sc.nextInt();
                                    break;
                                }
                                System.out.println(
                                        "Do you want to CONTINUE any another Challenge [Yeah , Common Go for it :) ]? (yes/no): ");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }

                        break;

                    case 5: // Exit Challenge
                        if (user != null) {
                            while (true) {
                                if (user.savingChallenges.size() != 0) {
                                    System.out.println("Existing Saving Challenges :");
                                    for (int i = 0; i < user.savingChallenges.size(); i++) {
                                        SavingChallenge savingChallenge = user.savingChallenges.get(i);
                                        System.out.println("Index: " + i + ", Amount: " + savingChallenge.amount
                                                + ", Days : "
                                                + savingChallenge.timeDays + ", Status : " + savingChallenge.status);
                                    }
                                } else {
                                    System.out.println("No Current Challenges in your profile !!!");
                                    sc.nextLine();
                                    break;
                                }
                                sc.nextLine();
                                int index = 0;
                                System.out.println("Enter the index of the Saving Challenge to EXIT : ");
                                index = sc.nextInt();
                                if (index >= 0 && index < user.savingChallenges.size()) {
                                    user.savingChallenges.remove(index);
                                    System.out.println("EXITED FROM SAVING CHALLENGE SUCCESSFULLY !!!");
                                    sc.nextLine();
                                } else {
                                    System.out.println("INVALID CHOICE");
                                    sc.nextInt();
                                    break;
                                }
                                System.out.println(
                                        "Do you want to exit from another Challenge [better not to, it's OK to feel hard but Don't Give Up :)]? (yes/no): ");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }
                        break;
                    case 6: // Update Completed challenge
                        if (user != null) {
                            while (true) {
                                if (user.savingChallenges.size() != 0) {
                                    System.out.println("Existing Saving Challenges :");
                                    for (int i = 0; i < user.savingChallenges.size(); i++) {
                                        SavingChallenge savingChallenge = user.savingChallenges.get(i);
                                        System.out.println("Index: " + i + ", Amount: " + savingChallenge.amount
                                                + ", Days : "
                                                + savingChallenge.timeDays + ", Status : " + savingChallenge.status);
                                    }
                                } else {
                                    System.out.println("No Current Challenges in your profile !!!");
                                    break;
                                }
                                sc.nextLine();
                                int index = 0;
                                System.out.println("Enter the index of the Saving Challenge to EXIT : ");
                                index = sc.nextInt();
                                if (index >= 0 && index < user.savingChallenges.size()) {
                                    user.savingChallenges.get(index).status = "Ongoing";
                                    System.out.println("UPDATED THE COMPLETION OF SAVING CHALLENGE SUCCESSFULLY !!!");
                                    sc.nextLine();
                                } else {
                                    System.out.println("INVALID CHOICE");
                                    sc.nextInt();
                                    break;
                                }
                                System.out.println(
                                        "Do you want to exit from another Challenge [better not to, it's OK to feel hard but Don't Give Up :)]? (yes/no): ");
                                String continuechoice = sc.nextLine();
                                if (!continuechoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                        }
                        break;

                    default:
                        System.out.println("INVALID CHOICE");
                        break;
                }

                break;

            default:
                System.out.println("INVALID CHOICE");
                break;
        }
        // int exitStatus=0;
        // System.out.println("Do you want to continue 1.yes 0.no (1/0)");
        // exitStatus=sc.nextInt();
        // if (exitStatus == 1) {
        // worker();
        // }
        System.out.println("Do you want to continue? (yes/no): ");
        String continueChoice = sc.nextLine();
        if (continueChoice.equalsIgnoreCase("yes")) {
            worker();
        }
        sc.close();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        worker();
        sc.close();
    }
}
