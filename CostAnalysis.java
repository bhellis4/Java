import javax.swing.JOptionPane;

/*
 * CostAnalysis
 * To analyze the cost of advertisement expenditures for 2 products
 * Developed By:			Ben Ellis
 * Created On:				3/3/2022
 * Last Modified:			3/6/2022
 */

// FIXME
// add validation for input


public class CostAnalysis {
	
	// Class Level Variables to use throughout the program
	
	// Product Names
	static String product1 = null;
	static String product2 = null;
	
	// Totals
	static double product1CostTotal = 0;
	static double product2CostTotal = 0;
	
	// Array of advertisement outlets
	static final String[] outlets = new String[] { "Radio", "Newspaper", "Website and Search Engine", "Social Media" };
	
	// List of expenditures, set by name in main
	static double[] product1Expenditure = new double[4];
	static double[] product2Expenditure = new double[4];
	

	// Method 1
	public static String totalCostPerProduct() {
		
		// Totals for products
		double totalCostOfBothProducts = 0;
		
		// Loop to increment product 1 total
		for(int i = 0; i < product1Expenditure.length; i++) {
			product1CostTotal += product1Expenditure[i];
		}
		
		// Loop to increment product 2 total
		for(int i = 0; i < product2Expenditure.length; i++) {
			product2CostTotal += product2Expenditure[i];
		}
		
		// Set the total of both products
		totalCostOfBothProducts = product1CostTotal + product2CostTotal;
		
		// String return
		return 	"Total Advertisement Cost per Product: "
				+ "\n"
				+ "     " + product1 + " $" + String.format("%.2f", product1CostTotal)
				+ "\n"
				+ "     " + product2 + " $" + String.format("%.2f", product2CostTotal)
				+ "\n" 
				+ "Advertisement Total: $" + String.format("%.2f", totalCostOfBothProducts);
	}
	
	// Method 2
	public static String totalCostPerExpenditure() {
		
		// Declare and Initialize totals
		double radio = (product1Expenditure[0] + product2Expenditure[0]);
		double newspaper = (product1Expenditure[1] + product2Expenditure[1]);
		double web = (product1Expenditure[2] + product2Expenditure[2]);
		double socialMedia = (product1Expenditure[3] + product2Expenditure[3]);
		
		// Return totals
		return "Totals by Expenditure:"
				+ "\n"
				+ "     " + outlets[0] + ": $" + String.format("%.2f", radio)
				+ "     " + outlets[1] + ": $" + String.format("%.2f", newspaper)
				+ "     " + outlets[2] + ": $" + String.format("%.2f", web)
				+ "     " + outlets[3] + ": $" + String.format("%.2f", socialMedia);
	}
	
	// Method 3
	public static String  highestCostCalculator() {
		
		// Declare and initialize variables
		double highestExpenditure = 0;
		int locationOfHighest = 0;
		double product1Highest = 0;
		double product2Highest = 0;
		int locationOfProduct1Highest = 0;
		int locationOfProduct2Highest = 0;
		
		product1Highest = product1Expenditure[0];
		product2Highest = product2Expenditure[0];
		
		// For to set product 1 highest
		for(int i = 0; i < product1Expenditure.length; ++i) {
			if(product1Expenditure[i] > product1Highest) {
				product1Highest = product1Expenditure[i];
				locationOfProduct1Highest = i;
			}
		}
		
		// For to set product 2 highest
		for(int i = 0; i < product2Expenditure.length; ++i) {
			if(product2Expenditure[i] > product2Highest) {
				product2Highest = product2Expenditure[i];
				locationOfProduct2Highest = i;
			}
		}
		
		// If/else to set highest total
		if(product1Highest > product2Highest) {
			highestExpenditure = product1Highest;
			locationOfHighest = locationOfProduct1Highest;
		}
		else {
			highestExpenditure = product2Highest;
			locationOfHighest = locationOfProduct2Highest;
		}
		
		// Return formatted info
		return "Highest Expenditures: " 
				+ "\n"
				+ "     " + product1
				+ "\n"
				+ "          $" + String.format("%.2f", product1Highest)
				+ "\n"
				+ "          Spent On: " + outlets[locationOfProduct1Highest]
				+ "\n"
				+ "\n"
				+ "     " + product2
				+ "\n"
				+ "          $" + String.format("%.2f", product2Highest)
				+ "\n"
				+ "          Spent On: " + outlets[locationOfProduct2Highest]
				+ "\n"
				+ "\n"
				+ "Highest Expenditure ($" + String.format("%.2f", highestExpenditure) + ") spent on " + outlets[locationOfHighest];
	}
	
	// Method 4
	public static String lowestCostCalculator() {
		
		// Declare and initialize variables
		double lowestExpenditure = 0;
		double product1Lowest = 0;
		double product2Lowest = 0;
		int locationOfLowest = 0;
		int locationOfProduct1Lowest = 0;
		int locationOfProduct2Lowest = 0;

		product1Lowest = product1Expenditure[0];
		product2Lowest = product2Expenditure[0];
		
		// For to determine product 1 lowest
		for(int i = 0; i < product1Expenditure.length; ++i) {
			if(product1Expenditure[i] < product1Lowest) {
				product1Lowest = product1Expenditure[i];
				locationOfProduct1Lowest = i;
			}
		}
		
		// For to determine product 2 lowest
		for(int i = 0; i < product2Expenditure.length; ++i) {
			if(product2Expenditure[i] < product2Lowest) {
				product2Lowest = product2Expenditure[i];
				locationOfProduct2Lowest = i;
			}
		}
		
		// If/else to set lowest total
		if(product1Lowest < product1Lowest) {
			lowestExpenditure = product1Lowest;
			locationOfLowest = locationOfProduct1Lowest;
		}
		else {
			lowestExpenditure = product2Lowest;
			locationOfLowest = locationOfProduct2Lowest;
		}
		
		// Return formatted info
		return "Lowest Expenditures: " 
		+ "\n"
		+ "     " + product1
		+ "\n"
		+ "          $" + String.format("%.2f", product1Lowest)
		+ "\n"
		+ "          Spent On: " + outlets[locationOfProduct1Lowest]
		+ "\n"
		+ "\n"
		+ "     " + product2
		+ "\n"
		+ "          $" + String.format("%.2f", product2Lowest)
		+ "\n"
		+ "          Spent On: " + outlets[locationOfProduct2Lowest]
		+ "\n"
		+ "\n"
		+ "Lowest Expenditure ($" + String.format("%.2f", lowestExpenditure) + ") spent on " + outlets[locationOfLowest];
	}
	
	// method 5
	public static String percentageCalculator() {
		// TODO -- total percentage cost spent on each expenditure
		// Declare and initialize product 1 variables
		double product1Radio = 0;
		double product1Newspaper = 0;
		double product1Web = 0;
		double product1SocialMedia = 0;
		
		// Declare and initialize product 2 variables
		double product2Radio = 0;
		double product2Newspaper = 0;
		double product2Web = 0;
		double product2SocialMedia = 0;
		
		for(int i = 0; i < product1Expenditure.length; ++i) {
			switch(i) {
				case 0:
					product1Radio = ((product1Expenditure[i]/product1CostTotal) * 100);
					break;
				case 1:
					product1Newspaper = ((product1Expenditure[i]/product1CostTotal) * 100);
					break;
				case 2:
					product1Web = ((product1Expenditure[i]/product1CostTotal) * 100);
					break;
				case 3:
					product1SocialMedia = ((product1Expenditure[i]/product1CostTotal) * 100);
					break;
				default:
					break;
			}
		}
		
		for(int i = 0; i < product2Expenditure.length; ++i) {
			switch(i) {
				case 0:
					product2Radio = ((product2Expenditure[i]/product2CostTotal) * 100);
					break;
				case 1:
					product2Newspaper = ((product2Expenditure[i]/product2CostTotal) * 100);
					break;
				case 2:
					product2Web = ((product2Expenditure[i]/product2CostTotal) * 100);
					break;
				case 3:
					product2SocialMedia = ((product2Expenditure[i]/product2CostTotal) * 100);
					break;
				default:
					break;
			}
		}
		
		return "Percentages Spent on Advertisement"
				+ "\n"
				+ "     " + product1
				+"\n"
				+ "          " + outlets[0] + ": %" + String.format("%.2f", product1Radio)
				+ "\n"
				+ "          " + outlets[1] + ": %" + String.format("%.2f", product1Newspaper)
				+ "\n"
				+ "          " + outlets[2] + ": %" + String.format("%.2f", product1Web)
				+ "\n"
				+ "          " + outlets[3] + ": %" + String.format("%.2f", product1SocialMedia)
				+ "\n"
				+ "\n"
				+ "     " + product2
				+ "\n"
				+ "          " + outlets[0] + ": %" + String.format("%.2f", product2Radio)
				+ "\n"
				+ "          " + outlets[1] + ": %" + String.format("%.2f", product2Newspaper)
				+ "\n"
				+ "          " + outlets[2] + ": %" + String.format("%.2f", product2Web)
				+ "\n"
				+ "          " + outlets[3] + ": %" + String.format("%.2f", product2SocialMedia);
	}
	
	// method 5
	public static void display() {
		
		// Set product 1 expenditure variables
		String product1Radio = "$" + String.format("%.2f", product1Expenditure[0]);
		String product1Newspaper = "$" + String.format("%.2f", product1Expenditure[1]);
		String product1Web = "$" + String.format("%.2f", product1Expenditure[2]);
		String product1SocialMedia = "$" + String.format("%.2f", product1Expenditure[3]);
		
		// Set product 2 expenditure variables
		String product2Radio = "$" + String.format("%.2f", product2Expenditure[0]);
		String product2Newspaper = "$" + String.format("%.2f", product2Expenditure[1]);
		String product2Web = "$" + String.format("%.2f", product2Expenditure[2]);
		String product2SocialMedia = "$" + String.format("%.2f", product2Expenditure[3]);
		
		// Display initial product inputs
		JOptionPane.showMessageDialog(null, "Product Expenditures: "
				+ "\n"
				+ "     " + product1
				+ "\n"
				+ "          " + outlets[0] + ": " + product1Radio
				+ "\n"
				+ "          " + outlets[1] + ": " + product1Newspaper
				+ "\n"
				+ "          " + outlets[2] + ": " + product1Web
				+ "\n"
				+ "          " + outlets[3] + ": " + product1SocialMedia
				+ "\n"
				+ "\n"
				+ "     " + product2
				+ "\n"
				+ "          " + outlets[0] + ": " + product2Radio
				+ "\n"
				+ "          " + outlets[1] + ":  " + product2Newspaper
				+ "\n"
				+ "          " + outlets[2] + ": " + product2Web
				+ "\n"
				+ "          " + outlets[3] + ": " + product2SocialMedia, "Cost Per Expernditure", JOptionPane.INFORMATION_MESSAGE);
		
		// Display product totals
		JOptionPane.showMessageDialog(null, totalCostPerProduct(), "Total Product Costs", JOptionPane.INFORMATION_MESSAGE);
		
		// Display expenditure totals
		JOptionPane.showMessageDialog(null, totalCostPerExpenditure(), "Total Expenditure Costs", JOptionPane.INFORMATION_MESSAGE);
		
		// Display highest
		JOptionPane.showMessageDialog(null, highestCostCalculator(), "Highest Costs", JOptionPane.INFORMATION_MESSAGE);
		
		// Display Lowest
		JOptionPane.showMessageDialog(null, lowestCostCalculator(), "Lowest Costs", JOptionPane.INFORMATION_MESSAGE);
		
		// Display percentages
		JOptionPane.showMessageDialog(null, percentageCalculator(), "Percentages", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String[] args) {
		
		// Establish product names
		for(int i = 0; i < 2; i++) {
			if(i == 0) {
				product1 = JOptionPane.showInputDialog(null, "Please enter the name of product " + (i+1), "Product 1", JOptionPane.PLAIN_MESSAGE);
			}
			else {
				product2 = JOptionPane.showInputDialog(null, "Please enter the name of product " + (i+1), "Product 2", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
			
		// Establish product expenditure arrays
		for(int i = 0; i < 2; i++) {
			if(i == 0) {
				for(int j = 0; j < product1Expenditure.length; j++) {
					try {
						switch(j) {
						case 0:
							product1Expenditure[j] = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter "
									+ "cost of Radio Advertisement for " + product1 + ": "));
							break;
						case 1:
							product1Expenditure[j] = Double.parseDouble(JOptionPane.showInputDialog("Please enter "
									+ "cost of Newspaper Advertisement for " + product1 + ": "));
							break;
						case 2:
							product1Expenditure[j] = Double.parseDouble(JOptionPane.showInputDialog("Please enter "
									+ "cost of Website and Search Engine Marketing for " + product1 + ": "));
							break;
						case 3:
							product1Expenditure[j] = Double.parseDouble(JOptionPane.showInputDialog("Please enter "
									+ "cost of Social Media Marketing for " + product1 + ": "));
							break;
						default:
							break;
						}
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Appropriate Number Responses Required", "ERROR", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
			}
			else {
				for(int j = 0; j < product1Expenditure.length; j++) {
					try {
						switch(j) {
						case 0:
							product2Expenditure[j] = Double.parseDouble(JOptionPane.showInputDialog("Please enter "
									+ "cost of Radio Advertisement for " + product2 + ": "));
							break;
						case 1:
							product2Expenditure[j] = Double.parseDouble(JOptionPane.showInputDialog("Please enter "
									+ "cost of Newspaper Advertisement for " + product2 + ": "));
							break;
						case 2:
							product2Expenditure[j] = Double.parseDouble(JOptionPane.showInputDialog("Please enter "
									+ "cost of Website and Search Engine Marketing for " + product2 + ": "));
							break;
						case 3:
							product2Expenditure[j] = Double.parseDouble(JOptionPane.showInputDialog("Please enter "
									+ "cost of Social Media Marketing for " + product2 + ": "));
							break;
						default:
							break;
						}
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Appropriate Number Responses Required", "ERROR", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
			}
		}
		// Call display()
		display();
	}

}
