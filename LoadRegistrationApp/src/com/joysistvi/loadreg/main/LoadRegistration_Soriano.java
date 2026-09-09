package com.joysistvi.loadreg.main;

import java.util.Scanner;

public class LoadRegistration_Soriano {

    public class LoadRegistration {

        static Scanner scanner = new Scanner(System.in);

        static double balance = 500.00;
        static double borrowedLoad = 0.00;

        public static void main(String[] args) {

            validateUssdCode();
            mainMenu();

        }


        public static void validateUssdCode() {

            while (true) {

                System.out.println("Dial *143# to access Smart Services");
                System.out.print("Enter USSD Code: ");

                String ussdCode = scanner.next();

                if (ussdCode.equals("*143#")) {

                    System.out.println();
                    System.out.println("USSD Code accepted!");
                    return;

                } else {

                    System.out.println();
                    System.out.println("Invalid USSD Code. Please try again.");
                    System.out.println();
                }
            }
        }


        public static void mainMenu() {

            while (true) {

                System.out.println();
                System.out.println("*** Load Registration ***");
                System.out.println("        [1] New SAYA ALL");
                System.out.println("        [2] BOOSTER");
                System.out.println("        [3] PANALO");
                System.out.println("        [4] SURFSAYA");
                System.out.println("        [5] MAGIC");
                System.out.println("        [6] ALLDATA");
                System.out.println("        [7] Check Balance");
                System.out.println("        [8] Borrow Load");
                System.out.println("        [0] Exit");

                System.out.print("Enter your Choice: ");
                int mainMenuChoice = scanner.nextInt();

                switch (mainMenuChoice) {

                    case 1:
                        sayaAllMenu();
                        break;

                    case 2:
                        boosterMenu();
                        break;

                    case 3:
                        panaloMenu();
                        break;

                    case 4:
                        surfSayaMenu();
                        break;

                    case 5:
                        magicMenu();
                        break;

                    case 6:
                        allDataMenu();
                        break;

                    case 7:
                        checkBalance();
                        break;

                    case 8:
                        borrowLoad();
                        break;

                    case 0:
                        exitProgram();
                        break;

                    default:
                        System.out.println();
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }


        public static void sayaAllMenu() {

            while (true) {

                System.out.println();
                System.out.println("*** NEW SAYA ALL ***");
                System.out.println("    [1] 9GB, 3D, P50");
                System.out.println("    [2] 20GB, 7D, P99");
                System.out.println("    [3] UNLI, 10GB, 7D, P109");
                System.out.println("    [4] UNLI, 19GB, 7D, P149");
                System.out.println("    [5] UNLI, 35GB, 28D, P449");
                System.out.println("    [6] UNLI, 3GB, 3D, P50");
                System.out.println("    [7] NEW20GB, CPlay, 7D, P109");
                System.out.println("    [0] EXIT");

                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        subscriptionConfirmation("Get total 9GB: 3GB Tiktok + 3GB FB + 3GB + Unli Calls and Texts for 3 Days", 50.00);
                        break;

                    case 2:
                        subscriptionConfirmation("Get 10GB TikTok, FB, MLBB +3GB 5G + 7GB + Unli Calls/Texts, 7D", 99.00);
                        break;

                    case 3:
                        subscriptionConfirmation("Get UNLI TikTok, FB and MLBB + 3GB 5G + 7GB + Unli Calls/Texts, 7D", 109.00);
                        break;

                    case 4:
                        subscriptionConfirmation("Get UNLI TikTok, FB and MLBB + 7GB 5G + 12GB + Unli Calls/Texts, 7D", 149.00);
                        break;

                    case 5:
                        subscriptionConfirmation("Get UNLI TikTok, FB and MLBB + 15GB 5G DATA + 20GB + Unli Calls/Texts, 28 days", 449.00);
                        break;

                    case 6:
                        subscriptionConfirmation("Get UNLI Tiktok + 3 GB + Unli Calls/Texts, 3 Days", 50.00);
                        break;

                    case 7:
                        subscriptionConfirmation("Get 10GB TikTok, FB and MLBB + 3GB 5G + 7GB + Unli Calls/Texts w/ CPlay Lite, 7D", 109.00);
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println();
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }


        public static void boosterMenu() {

            while (true) {

                System.out.println();
                System.out.println("*** BOOSTER ***");
                System.out.println("    [1] MAX SAYA");
                System.out.println("    [2] WATCHAPP");
                System.out.println("    [3] WATCHVIVA");
                System.out.println("    [4] WATCHVMX");
                System.out.println("    [5] WATCHPLAY");
                System.out.println("    [0] Exit");

                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        subscriptionConfirmation("Enjoy HIGH-SPEED DATA for all sites! 2 GB, 1 Day", 30.00);
                        break;

                    case 2:
                        subscriptionConfirmation("Watch via watchapp.ph Premium Movie, 12 Hrs", 15.00);
                        break;

                    case 3:
                        subscriptionConfirmation("Subscription to Viva One + Data for ALL sites 1GB, 3 Days", 50.00);
                        break;

                    case 4:
                        subscriptionConfirmation("Subscription to VMX + Data for ALL sites 500 MB, 7 Days", 75.00);
                        break;

                    case 5:
                        subscriptionConfirmation("Get Subscription to Cignal Play Premium + Data for ALL sites, 1 GB, 7 days", 75.00);
                        break;

                    case 0:
                        exitProgram();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }


        public static void panaloMenu() {

            while (true) {

                System.out.println();
                System.out.println("*** PANALO DATA ***");
                System.out.println("ENJOY MORE DATA + CALLS/TEXTS");
                System.out.println("    [1] 300MB, 60 Mins/Texts, 1D, P10");
                System.out.println("    [2] 600MB, 120 Mins/Texts, 1D, P15");
                System.out.println("    [3] 1GB, 250 Mins/Texts, 1D, P20");
                System.out.println("    [4] 2GB, 500 Mins/Texts, 2D, P30");
                System.out.println("    [5] Back");
                System.out.println("    [0] Exit");

                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        subscriptionConfirmation("Get 300 MB + 60 Mins Calls to Mobile and 60 Texts, 1 Day", 10.00);
                        break;

                    case 2:
                        subscriptionConfirmation("Get 600 MB + 120 Mins Calls to Mobile and 120 Texts, 1 Day", 15.00);
                        break;

                    case 3:
                        subscriptionConfirmation("Get 1 GB + 250 Mins Calls to Mobile and 250 Texts, 1 Day", 20.00);
                        break;

                    case 4:
                        subscriptionConfirmation("Get 2 GB + 500 Mins Calls to Mobile and 500 Texts, 2 Day", 30.00);
                        break;

                    case 5:
                        return;

                    case 0:
                        exitProgram();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }



        public static void surfSayaMenu() {

            while (true) {

                System.out.println();
                System.out.println("*** SURFSAYA ***");
                System.out.println("    [1] TOTAL 600MB, 2D, P20");
                System.out.println("    [2] TOTAL 900MB, 2D, P25");
                System.out.println("    [3] TOTAL 1.35GB, 3D, P30");
                System.out.println("    [4] TOTAL 2.4GB, 3D, P35");
                System.out.println("    [5] TOTAL 1.2GB, 7D, P49");
                System.out.println("    [6] Back");
                System.out.println("    [0] Exit");

                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        subscriptionConfirmation("GET 600 MB: 150 MB ARAW-ARAW for TikTok, IG, FB, ML (300 MB) + Unli Calls / Texts, 2 Days", 20.00);
                        break;

                    case 2:
                        subscriptionConfirmation("GET 900 MB: 250 MB ARAW-ARAW for TikTok, IG, FB, ML (500 MB) + Unli Calls / Texts, 2 Days", 25.00);
                        break;

                    case 3:
                        subscriptionConfirmation("GET 1.35 GB: 250 MB ARAW-ARAW for TikTok, IG, FB, ML (750 MB) + 600 MB + Unli Calls / Texts, 3 Days", 30.00);
                        break;

                    case 4:
                        subscriptionConfirmation("GET 2.4 GB: 500 MB ARAW-ARAW for TikTok, IG, FB, ML (1.5 GB) + Unli Calls / Texts, 2 Days", 35.00);
                        break;

                    case 5:
                        subscriptionConfirmation("GET 1.2 GB: 100 MB ARAW-ARAW for TikTok, IG, FB, ML (700 MB) + Unli Calls / Texts, 7 Days", 49.00);
                        break;

                    case 6:
                        return;

                    case 0:
                        exitProgram();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }


        public static void magicMenu() {

            while (true) {

                System.out.println();
                System.out.println("*** MAGIC ***");
                System.out.println("NO EXPIRY DATA FOR ALL SITES.");
                System.out.println("    [1] 3 GB, P149");
                System.out.println("    [2] 8 GB, P249");
                System.out.println("    [3] 16 GB, P349");
                System.out.println("    [4] Back");
                System.out.println("    [0] Exit");

                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        subscriptionConfirmation("Get 3 GB NO EXPIRY DATA", 149.00);
                        break;

                    case 2:
                        subscriptionConfirmation("Get 8 GB NO EXPIRY DATA", 249.00);
                        break;

                    case 3:
                        subscriptionConfirmation("Get 16 GB NO EXPIRY DATA", 349.00);
                        break;

                    case 4:
                        return;

                    case 0:
                        exitProgram();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }


        public static void allDataMenu() {

            while (true) {

                System.out.println();
                System.out.println("*** ALLDATA ***");
                System.out.println("    [1] 2GB, 3 Days, P50");
                System.out.println("    [2] 6GB, 7 Days, P99");
                System.out.println("    [3] 24GB, 30 Days, P299");
                System.out.println("    [4] Back");
                System.out.println("    [0] Exit");

                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        subscriptionConfirmation("Get 2 GB SHAREABLE DATA, 3 Days", 50.00);
                        break;

                    case 2:
                        subscriptionConfirmation("Get 6 GB SHAREABLE DATA, 7 Days", 99.00);
                        break;

                    case 3:
                        subscriptionConfirmation("Get 24 GB SHAREABLE DATA, 30 Days", 299.00);
                        break;

                    case 4:
                        return;

                    case 0:
                        exitProgram();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        public static void subscriptionConfirmation(String promoName, double price) {

            while (true) {

                System.out.println();
                System.out.println("*** Subscription Confirmation ***");
                System.out.printf("%s, P%.2f%n", promoName, price);

                // Check balance
                if (balance < price) {

                    System.out.println();
                    System.out.println("Insufficient balance!");
                    System.out.printf("You need P%.2f more.%n",
                            price - balance);

                    System.out.println();
                    System.out.println("    [0] Back");

                    System.out.print("Enter Choice: ");
                    int choice = scanner.nextInt();

                    if (choice == 0) {
                        return;
                    } else {
                        System.out.println("Invalid choice.");
                    }

                } else {

                    System.out.println();
                    System.out.println("    [1] Subscribe");
                    System.out.println("    [0] Back");

                    System.out.print("Enter Choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {

                        case 1:

                            balance -= price;

                            System.out.println();
                            System.out.println("=================================");
                            System.out.println("     SUBSCRIPTION SUCCESSFUL!");
                            System.out.println("=================================");
                            System.out.println("Promo: " + promoName);
                            System.out.printf("Amount deducted: P%.2f%n", price);
                            System.out.printf("Remaining balance: P%.2f%n", balance);
                            System.out.println();
                            System.out.println("Thank you for subscribing!");
                            System.out.println("Enjoy your promo!");
                            System.out.println("Thank you for using Smart Services!");
                            System.out.println("=================================");

                            exitProgram();

                        case 0:

                            System.out.println();
                            System.out.println("Subscription cancelled.");
                            System.out.println("Returning to promos...");

                            return;

                        default:

                            System.out.println();
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }



        public static void checkBalance() {

            System.out.println();
            System.out.println("*** Check Balance ***");
            System.out.printf("Current Balance : P%.2f%n", balance);
            System.out.printf("Borrowed Load   : P%.2f%n", borrowedLoad);

            if (borrowedLoad > 0) {

                System.out.println();
                System.out.println("You currently have an unpaid loan.");
                System.out.println("Please repay your borrowed load first.");

            } else {

                System.out.println();
                System.out.println("No outstanding borrowed load.");
            }
        }


        public static void borrowLoad() {

            // Prevent another loan if there is already an unpaid loan
            if (borrowedLoad > 0) {

                System.out.println();
                System.out.println("*** Borrow Load ***");
                System.out.println("You already have an outstanding loan.");
                System.out.printf("Current Loan: P%.2f%n",
                        borrowedLoad);

                System.out.println();
                System.out.println("You cannot borrow another load.");
                System.out.println("Please repay your current loan first.");

                System.out.println();
                System.out.println("[1] Repay Loan");
                System.out.println("[0] Back");

                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    repayLoan();
                }

                return;
            }

            while (true) {

                System.out.println();
                System.out.println("*** Borrow Load ***");
                System.out.println("    [1] Borrow P10");
                System.out.println("    [2] Borrow P20");
                System.out.println("    [3] Back");

                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        processBorrow(10.00);
                        return;

                    case 2:
                        processBorrow(20.00);
                        return;

                    case 3:
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }


        public static void processBorrow(double amount) {

            System.out.println();
            System.out.printf("Borrow P%.2f?%n", amount);
            System.out.println("    [1] Confirm");
            System.out.println("    [0] Back");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {

                borrowedLoad = amount;
                balance += amount;

                System.out.println();
                System.out.println("=================================");
                System.out.println("       LOAD SUCCESSFULLY BORROWED!");
                System.out.println("=================================");
                System.out.printf("Borrowed Load : P%.2f%n",
                        amount);
                System.out.printf("New Balance   : P%.2f%n",
                        balance);
                System.out.println();
                System.out.println("Reminder:");
                System.out.println("You cannot borrow again");
                System.out.println("until this loan is repaid.");
                System.out.println("=================================");

            } else if (choice == 0) {

                System.out.println();
                System.out.println("Borrow request cancelled.");
                System.out.println("No load was added.");

            } else {

                System.out.println();
                System.out.println("Invalid choice.");
                System.out.println("Borrow request cancelled.");
            }
        }


        public static void repayLoan() {

            if (borrowedLoad <= 0) {

                System.out.println();
                System.out.println("You don't have an outstanding loan.");
                return;
            }

            System.out.println();
            System.out.println("*** Repay Loan ***");
            System.out.printf("Outstanding Loan : P%.2f%n",
                    borrowedLoad);
            System.out.printf("Current Balance  : P%.2f%n",
                    balance);

            if (balance < borrowedLoad) {

                System.out.println();
                System.out.println("Insufficient balance to repay the loan.");
                System.out.printf("You need P%.2f more.%n",
                        borrowedLoad - balance);

                return;
            }

            System.out.println();
            System.out.printf("Repay P%.2f?%n", borrowedLoad);
            System.out.println("    [1] Repay");
            System.out.println("    [0] Back");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {

                balance -= borrowedLoad;

                double amountPaid = borrowedLoad;

                borrowedLoad = 0.00;

                System.out.println();
                System.out.println("=================================");
                System.out.println("        LOAN FULLY REPAID!");
                System.out.println("=================================");
                System.out.printf("Amount Paid : P%.2f%n",
                        amountPaid);
                System.out.printf("New Balance : P%.2f%n",
                        balance);
                System.out.println();
                System.out.println("You can now borrow load again.");
                System.out.println("Thank you for using Smart Services!");
                System.out.println("=================================");

            } else if (choice == 0) {

                System.out.println();
                System.out.println("Loan repayment cancelled.");

            } else {

                System.out.println();
                System.out.println("Invalid choice.");
                System.out.println("Loan repayment cancelled.");
            }
        }


        public static void exitProgram() {

            System.out.println("Exiting . . .");

            scanner.close();
            System.exit(0);
        }
    }

}
