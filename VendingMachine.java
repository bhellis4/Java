import javax.swing.JOptionPane;

/*
 *Class:					VendingMachine
 *Description:				To simulate a common vending machine
 *Developed By:				Ben Ellis
 *Created On:				2/9/2022
 *Last Modified on:			2/10/2022 
 */

public class VendingMachine {

	public static void main(String[] args) throws Exception {
		
		// declare and initialize variables
		double money = 0; // wallet
		String itemName = null; // name of item
		double itemPrice = 0; // price
		int itemNumber = 0; // vending machine number
		double insertedBill = 0; // inserted money
		int change5 = 0; // change in 5's
		int change1 = 0; // change in 1's
		int changeHalf = 0; // change in half dollars
		int changeQuarter = 0; // change in quarters
		double tempChange = 0; // used to display total change in the transaction summary
		
		
		// try/catch to validate vending machine selection
		try {
			itemNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Trail Mix                   $1.25" + "\n"
								+ "2. Snickers                   $2.00" + "\n"
								+ "3. Chewing Gum          $0.50" + "\n"
								+ "4. Cheetos                    $5.75", "MY VENDING MACHINE OPTIONS", 1));
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Not a valid numerical entry" + "\n" + "System Abort", "ERROR", 0);
			System.exit(0);
		}
		
		
		// switch to establish item details or further validate machine selection
		switch (itemNumber) {
		case (1) :
			itemName = "Trail Mix";
			itemPrice = 1.25;
			break;
		case (2) :
			itemName = "Snickers";
			itemPrice = 2.00;
			break;
		case (3) :
			itemName = "Chewing Gum";
			itemPrice = 0.50;
			break;
		case (4) :
			itemName = "Cheetos";
			itemPrice = 5.75;
			break;
		default :
			JOptionPane.showMessageDialog(null, "You entered: " + itemNumber + "\n" + "Not a valid option! System Abort", "ERROR", 0);
			System.exit(0);
			break;
		} // end switch
		

		// try/catch to validate inserted money
		try {
			insertedBill = Double.parseDouble(JOptionPane.showInputDialog(null, "Please insert money for " + itemName + "\n"
					+ "Expected amount is " + String.format("%.2f", itemPrice) + "\n"
					+ "$1, $5, and $10 bills only" + "\n"
					+ "Cards and change not accepted", "INSERT BILL", JOptionPane.PLAIN_MESSAGE));
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Must Deposit Money", "ERROR", 0);
			System.exit(0);
		} // end try/catch
		
		
		// if statement to validate amount of money
		if (insertedBill < itemPrice) {
			JOptionPane.showMessageDialog(null, "Not enough credits. Transaction Terminated.", "ERROR", 0);
			System.exit(0);
		} // end if
		
		
		// if statement to validate size of bill
		if (insertedBill == 1.00) {
			money += insertedBill;
		}
		else if (insertedBill == 5.00) {
			money += insertedBill;
		}
		else if (insertedBill == 10.00) {
			money += insertedBill;
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid amount. Transaction Terminated.", "ERROR", 0);
			System.exit(0);
		} // end if/elif
		
		
		// purchase item
		money = money - itemPrice;
		tempChange = money;
		
		// series of if statements to count individual change
		if (money >= 5) {
			change5++;				money -= 5;
		}
		
		if(money >= 1 && money < 5) {
			while (money >= 1) {
				change1++;
				money -= 1;
			}
		}
			
		if (money >= 0.50 && money < 1) {
			while (money >= 0.50) {
				changeHalf++;
				money -= 0.50;
			}
		}
		
		if (money >= 0.25 && money < 0.50) {
			changeQuarter++;
			money -= 0.25;
		} // end if/elif
		

		// transaction summary
		JOptionPane.showMessageDialog(null, "You selected item number " + itemNumber + " which is " + itemName + "\n"
								+ "This item costs:           $" + String.format("%.2f", itemPrice) + "\n"
								+ "You inserted:               $" + String.format("%.2f", insertedBill) + "\n"
								+ "Your change is            $" + tempChange + "\n"
								+ "\n"
								+ "Change Deposited: " + "\n"
								+ "           " + change5 + " $5 Bills" + "\n"
								+ "           " + change1 + " $1 Bills" + "\n"
								+ "           " + changeHalf + " Half Dollars" + "\n"
								+ "           " + changeQuarter + " Quarters", "Transaction Summary", JOptionPane.PLAIN_MESSAGE);
		
	} // end main
} // end class
