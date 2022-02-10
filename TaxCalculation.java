import javax.swing.JOptionPane;

/*
 *Class:					TaxCalculation
 *Description:				To compute personal income tax based on income and filing status
 *Developed By:				Ben Ellis
 *Created On:				2/8/2022
 *Last Modified on:			2/10/2022 
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
			if (incomeInDouble <= 0) {
				incomeValidation = false;
				JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
			}
			else {
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

		 	
		 	// if to determine the appropriate tax for Single status
			if (statusInInt == 0) {
				if (incomeInDouble > 372951) {
		 			tax += (8350 * 0.10);
					tax += (25599 * 0.15);
					tax += (48299 * 0.25);
					tax += (89299 * 0.28);
					tax += (201399 * 0.33);
					tax += (incomeInDouble - 372951) * 0.35;
		 		}
		 		else if (incomeInDouble > 171551) {
					tax += (8350 * 0.10);
					tax += (25599 * 0.15);
					tax += (48299 * 0.25);
					tax += (89299 * 0.28);
					tax += (incomeInDouble - 171551) * 0.33;
				}
				else if (incomeInDouble > 82251) {
					tax += (8350 * 0.10);
					tax += (25599 * 0.15);
					tax += (48299 * 0.25);
					tax += (incomeInDouble - 82251) * 0.28;
				}
				else if (incomeInDouble > 33951) {
					tax += (8350 * 0.10);
					tax += (25599 * 0.15);
					tax += (incomeInDouble - 33951) * 0.25;
				}
				else if (incomeInDouble > 8351) {
					tax += (8350 * 0.10);
					tax += (incomeInDouble - 8351) * 0.15;
				}
				else {
					tax += incomeInDouble * 0.10;
				} // end nested if
			} // end if
			
			// if to determine appropriate tax for Married status
			if (statusInInt == 1) {
				if (incomeInDouble > 372951) {
		 			tax += (16700 * 0.10);
					tax += (51199 * 0.15);
					tax += (69149 * 0.25);
					tax += (71799 * 0.28);
					tax += (164099 * 0.33);
					tax += (incomeInDouble - 372951) * 0.35;
		 		}
		 		else if (incomeInDouble > 208851) {
					tax += (16700 * 0.10);
					tax += (51199 * 0.15);
					tax += (69149 * 0.25);
					tax += (71799 * 0.28);
					tax += (incomeInDouble - 208851) * 0.33;
				}
				else if (incomeInDouble > 137051) {
					tax += (16700 * 0.10);
					tax += (51199 * 0.15);
					tax += (69149 * 0.25);
					tax += (incomeInDouble - 71799) * 0.28;
				}
				else if (incomeInDouble > 67901) {
					tax += (16700 * 0.10);
					tax += (51199 * 0.15);
					tax += (incomeInDouble - 69149) * 0.25;
				}
				else if (incomeInDouble > 16701) {
					tax += (16700 * 0.10);
					tax += (incomeInDouble - 16701) * 0.15;
				}
				else {
					tax += incomeInDouble * 0.10;
				} // end nested if
			} // end if
			
			
			// display and format all variables
			JOptionPane.showMessageDialog(null, "Income = $"+ String.format("%.2f", incomeInDouble) + "\n"+
											" Status = "+ statusInString  + "\n"+ 
											"Tax = $" + String.format("%.2f", tax));	
	} // end main
} // end class

