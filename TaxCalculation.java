import javax.swing.JOptionPane;

/*
 *Class:					TaxCalculation
 *Description:				To compute personal income tax based on income and filing status
 *Developed By:				Ben Ellis
 *Created On:				2/8/2022
 *Last Modified on:			2/9/2022 
 */

public class TaxCalculation {

	public static void main(String[] args) throws Exception {
		
		double tax = 0; // declare and initialize tax variable
		double incomeInDouble = 0; // declare and initialize income variable
		boolean incomeValidation = false; // declare and initialize loop validation condition
		String statusInString = null; // declare and initialize filing status string
		int statusInInt = 0; // declare and initialize filing status integer


		// loop to validate and accept user income input
		while (incomeValidation != true) {
			try {
				incomeInDouble = Double.parseDouble(JOptionPane.showInputDialog("Enter income of one person. "
						+ "Enter value as a whole number, without any decimal, e.g., 15125"));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a number");
			}
			
			if (incomeInDouble != 0) {
				incomeValidation = true;
			}
		} // end loop
		
		
		// prompt and record filing status input to statusInString variable
		statusInString = JOptionPane.showInputDialog("Enter status of person, "
						+ "Enter either the value of Single, or Married.");
				
		// switch case to validate filing status input
		 switch (statusInString) {	   
	            case "Single":
	            	statusInInt = 0;
	                break;
	            case "Married":
	            	statusInInt = 1;
	                break;
	            default:
	        		statusInString = JOptionPane.showInputDialog("Invalid Entry. Please  "
							+ "Enter either the value of Single, or Married.");
	        } // end switch
				 
		 
		 	// if/elif to determine the appropriate tax based on income and filing status
			if (statusInInt == 0) {
				if (incomeInDouble < 8350) {
					tax = incomeInDouble * 0.1;
				}
				else if (incomeInDouble >= 8351 && incomeInDouble <= 33950) {
					tax = incomeInDouble * 0.15;
				}
				else if (incomeInDouble >= 33951 && incomeInDouble <= 82250) {
					tax = incomeInDouble * 0.25;
				}
				else if(incomeInDouble >= 82251 && incomeInDouble <= 171550) {
					tax = incomeInDouble * 0.28;
				}
				else if (incomeInDouble >= 171551 && incomeInDouble <= 372950) {
					tax = incomeInDouble * 0.33;
				}
				else {
					tax = incomeInDouble * 0.35;
				} // end nested if/elif
			}
			else if (statusInInt == 1) {
				
				if (incomeInDouble < 16700) {
					tax = incomeInDouble * 0.1;
				}
				else if (incomeInDouble >= 16701 && incomeInDouble <= 67900) {
					tax = incomeInDouble * 0.15;
				}
				else if (incomeInDouble >= 67901 && incomeInDouble <= 137050) {
					tax = incomeInDouble * 0.25;
				}
				else if(incomeInDouble >= 137051 && incomeInDouble <= 208850) {
					tax = incomeInDouble * 0.28;
				}
				else if (incomeInDouble >= 208851 && incomeInDouble <= 372950) {
					tax = incomeInDouble * 0.33;
				}
				else {
					tax = incomeInDouble * 0.35;
				} // end nested if/elif
			} // end if/elif
			
			// display and format all variables
			JOptionPane.showMessageDialog(null, "Income = "+ incomeInDouble + "\n"+
											" Status = "+ statusInString  + "\n"+ 
											"Tax= " + tax);	
	} // end main
} // end class
