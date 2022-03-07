import java.awt.Dimension;
import java.io.*;
import java.util.Scanner;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

/*
 * Product
 * Read, arrange, and write a csv file
 * Developed By:			Ben Ellis
 * Created On:				3/3/2022
 * Last Modified:			3/5/2022
 */

// TODO
// Line 73
// Line 102
// Line 117

public class Product {
	
	// Class Level variables
	
	// Arrays to sort
	static String[] pName = new String[50];
	static Double[] pPrice = new Double[50];
	
	// Name of file as string
	static String toRead;
	
	public static void readFromFile() throws FileNotFoundException {
		
		// Temp array to store price as string
        String[] tempPPrice = new String[50];
        String fileRead = "";
        
        // Declare reader
		BufferedReader reader;
		
		// Try/catch to read file
        try {
        	// Instantiate new reader
            reader = new BufferedReader(new FileReader(toRead));
            
            // String to store each line
            String line = null;

            // Variable to use in array assignment
    		int i = 0;
    		
    		// While loop to iterate each line of file
    		while ((line = reader.readLine()) != null) {
    			
    			// Set each line as an array
    			String[] segmentedLine = line.split(",");
    			
    			// Set array variables
        		pName[i] = segmentedLine[0];
        		tempPPrice[i] = segmentedLine[1];
        		
        		fileRead += line + "\n";
        		
        		// Increment array assignment variable
        		i++;
        	}
            
    		// Close reader
            reader.close();
            
        } catch (IOException e) {
        	// FIXME -- write a more elegant control
            e.printStackTrace();
        }
        
        // For loop to set pPrice to tempPPrice as double
        for(int i = 0; i < pPrice.length; i++) {
        	pPrice[i] = Double.parseDouble(tempPPrice[i]);
        }
        
        // Establish JTextArea to read file to
        JTextArea textArea = new JTextArea(fileRead);
        JScrollPane scrollPane = new JScrollPane(textArea);  
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        scrollPane.setPreferredSize( new Dimension( 100, 200 ));

        // Display product list in JOptionPane
        JOptionPane.showMessageDialog(null,  scrollPane, "Product Information",           
        JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void sortArrays(String[] pName, Double[] pPrice) {
		
		// Call selectionSort on the 2 arrays
		Sort.selectionSort(pName, pPrice);
	}
	
	public static void writeToFile() throws IOException {
		// FIXME -- write to text file
		
		String sortedCSV = "";
		
		try(FileWriter writer = new FileWriter("sortedProducts.txt")){

		    for(int i = 0; i < pName.length; i++){

		        sortedCSV += pName[i] + ", " + pPrice[i].toString() + "\n"; 

		    }
		    
		    writer.write(sortedCSV);
		    
		    writer.close();
		    
		} catch (FileNotFoundException e) {
			// FIXME -- more elegant close
			e.printStackTrace();
		}
		
		
        // Establish JTextArea to read file to
        JTextArea textArea = new JTextArea(sortedCSV);
        JScrollPane scrollPane = new JScrollPane(textArea);  
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        scrollPane.setPreferredSize( new Dimension( 100, 200 ));

        // Display product list in JOptionPane
        JOptionPane.showMessageDialog(null,  scrollPane, "Sorted Product Information",           
        JOptionPane.PLAIN_MESSAGE);
	}

	public static void main(String[] args) throws IOException {
		// TODO 
// Check		// prompt the user to input file path
// Check		// validate file path
// Check		// create pName[50] and pPrice[50] and pass the file contents to the arrays using a comma delimiter
// Check		// readFromFile() which reads the file path and stores the contents in the 2 arrays. also displays both arrays in a text file (products.txt) a JOptionPane
// Check		// sortArrays() which passes the arrays to Sort.java's selectionSort()
		// writeToFile() which saves the new arrays to a text file (sortedProducts.txt) and displays in a JOptionPane

		// Main variables
		String fileName = null;
		boolean breakLoop = false;
		
		
		// While loop to validate file name
		while(breakLoop == false) {
			try {
				fileName = JOptionPane.showInputDialog("Please enter file name or path");
				breakLoop = true;
			}
			catch (Exception e){	
				JOptionPane.showMessageDialog(null, "File not found.");
				breakLoop = false;
			}
		}
		
		// Assign file name to string input
		toRead = fileName;
			
		// Call all methods
		readFromFile();
		sortArrays(pName, pPrice);
		writeToFile();
		
	}

}
