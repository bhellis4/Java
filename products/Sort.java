import javax.swing.JOptionPane;

/*
 * Sort
 * Accept 2 arrays and sort them in ascending order
 * Developed By:			Ben Ellis
 * Created On:				3/3/2022
 * Last Modified:			3/5/2022
 */

public class Sort {
	public static void selectionSort(String[] pName, Double[] pPrice) {
		
		// Loop to iterate both arrays
		for (int i = 0; i < pPrice.length; i++) {
			
			// Loop to iterate next array element
			for (int j = i + 1; j < pPrice.length; j++) {
				
				// Comparison variables
				double priceTemp = 0;  
				String nameTemp = null;
				
				// If to compare and set both arrays in ascending order
				if (pPrice[i] > pPrice[j]) {  
					priceTemp = pPrice[i];  
					pPrice[i] = pPrice[j];  
					pPrice[j] = priceTemp;  
					
					nameTemp = pName[i];
					pName[i] = pName[j];
					pName[j] = nameTemp;
				}  
			}
		}
	}
}

