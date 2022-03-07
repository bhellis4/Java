//*********************************************************************
//*                                                                   
//*   CIS611                 Spring 2022         bhellis4 & emilldr   
//*                                                                   
//*                        Group Project PP01 		    	      
//*                                                                   
//*                    		     Maze		            	      
//* 							  	   
//*								      
//*                           2/15/2022	                              
//*                                                                   
//*                   Saved in: EMILLPP01.zip 			      
//*                                                                   
//*********************************************************************

// This class must have the code in the run() method to solve the maze
// It searches for the Java logo based on the provided path/direction algorithm in Part II

public class Direction extends Thread{

	Maze maze;
	Position location;
	
	Direction(Maze maze, Position location) {
		
		this.maze = maze;
		this.location = location;
	}
	
        public void run(){
        	
        	// while maze is not done loop
        	while(!maze.isDone()) {
        		
        		// for loop to control number of movements in column
        		for(int i = 0; i <= this.maze.getHeight() - 1; i++) {
        			
           			// if even move down, if odd move up
        			if(this.maze.getCurrCol() == 0 || (this.maze.getCurrCol() % 2) == 0) {
        				if(this.maze.moveDown()) {
       						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
       					} // end if
					
        				// else to avoid obstacles
       					else {
       						this.maze.moveRight();
       						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
       						if(this.maze.isDone()) {
       							break;
       						} // end else
       						
        					this.maze.moveDown();
        					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
        					if(this.maze.isDone()) {
        						break;
        					} //end if
        					
        					this.maze.moveDown();
        					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
       						if(this.maze.isDone()) {
       							break;
       						} //end if
       						
        					this.maze.moveLeft();
       						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
       						if(this.maze.isDone()) {
       							break;
       						} // end if
        				} // end else to avoid obstacles
					
        			} // end even column movement
				
				// else if odd move up
        			else if((this.maze.getCurrCol() % 2) != 0) {
           				if(this.maze.moveUp()) {
      						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
    					} // end if
           				
           				// else to avoid obstacles
           				else {
           					this.maze.moveLeft();
       						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
           					if(this.maze.isDone()) {
           						break;
       						} // end else
           					
           					this.maze.moveUp();
           					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
           					if(this.maze.isDone()) {
           						break;
           					} // end if
           					
           					this.maze.moveUp();
           					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
       						if(this.maze.isDone()) {
       							break;
       						} // end if
       						
       						this.maze.moveRight();
       						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
       						if(this.maze.isDone()) {
       							break;
       						} // end  if
           				} // end else to avoid obstacles
        			} // end odd column movement
        			
        			// if to move right at borders
        			if(this.maze.getCurrRow() == (this.maze.getHeight() - 1) || this.maze.getCurrRow() == 0) {
        				this.maze.moveRight();
					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
        			} // end if
        		} // end for loop
        		
        		// if maze is done is true announce logo found and location
        		if(this.maze.isDone()) {				
        			location.textArea.append("You Solved the Maze!\n"
        					+ "Logo Found at\n"
        					+ "row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
        			break;
    			} // end if complete
  
        		// else if end of maze and maze is not done, announce loss
        		else if(this.maze.getCurrCol() == (this.maze.getWidth() - 1) && (this.maze.getCurrRow() == 0 || this.maze.getCurrRow() == this.maze.getHeight() - 1)) {
        			location.textArea.append("You Lost!" + "\n");
        			break;
        		} // end else lost
    				
        	} // end while maze not done loop
		
// Part One
    		
       	/*
		
		//movement test
    		this.maze.moveRight();
    		this.maze.moveLeft();
    		this.maze.moveUp();
    		this.maze.moveDown(); 
        
		//while maze is not done continue
		outer: while(!maze.isDone()) {
				boolean controlDown = true;
				boolean controlUp = true;
				boolean controlRight = true;
			
				while(controlDown == true) {
				
				
					// move down
					if(this.maze.moveDown()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						location.textArea.append("Success" + "\n");
					}
					
					//move around obstacle
					else {
						this.maze.moveRight();
						this.maze.moveDown();
						this.maze.moveDown();
						this.maze.moveLeft();
						controlDown = false;
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						location.textArea.append("Failure" + "\n");
						break;
					}
					//check if done
					if(this.maze.isDone()) {
						break outer;
					}
				}
			
				// move right
				while(controlRight == true) {
				
					// if move right successful
					if(this.maze.moveRight()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						location.textArea.append("Success" + "\n");
					} // end if
					
					// if move right fail
					else {
						controlRight = false;
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						location.textArea.append("Failure" + "\n");
						break;
					} // end else
					
					// check if done
					if(this.maze.isDone()) {
						break outer;
					} // end if
				// move up
				while(controlUp == true) {
					
					// if move up successful
					if(this.maze.moveUp()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						location.textArea.append("Success" + "\n");
					} // end if
					
					// if move up failure
					else {
						controlUp = false;
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						location.textArea.append("Failure" + "\n");
						break;
					} // end else
					
					// check if done
					if(this.maze.isDone()) {
						break outer;
					} // end if
					
				} // end while up
				
			} // end while not done
			
		//announce logo found and location
		location.textArea.append("Logo Found \n");
		location.textArea.append("Found at row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
		
			*/
		
        } // end run
	
} // end direction
