package ackermanCoplanMuscianoAirHockey; //COMMENTED

import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args){
	
		
		MainMenu mainMenu = new MainMenu();
		
		while(!mainMenu.isButtonClicked()){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){}
		}
		
		switch(mainMenu.getButton())
		{
		case '1': singlePlayer();
		break;
		case '2': twoPlayer();
		break;
		case '4': fourPlayer();
		break;
		default: JOptionPane.showMessageDialog(null, "Error with main menu!", "ERROR", JOptionPane.ERROR_MESSAGE);
		break;
		}
		
		/* DONE
		 * Done--Set all catch statements to JOptionPanes
		 * Done--make the goals bigger
		 * Done--teach the computer to account for the puck bouncing off of walls
		 * Done--bound people to their half
		 */
		
		/* FOUR PERSON AND MULTIPLAYER IN GENERAL
		 * AARON--The entire four player game needs written -- a lot of code can be copied from the two person classes
		 * AARON--Also need to catch socket exceptions for when opponent disconnects
		 * AARON--We may have to make the server implement runnable cause you cannot close the window when hosting and waiting for a connection (or we could institute a timeout)
		 */
		
		/* FEATURES TO ADD
		 * AARON--Need to give people option to pick their color of paddle and goal
		 * ACK--still need to do replay of last goal using recorder and playback classes (currently not implemented)
		 * ACK--draw a midline
		 */
		
		/* AI ISSUES
		 * ACK--bound the computer to the game board and its own half
		 */
		
		/* GAMEPLAY ISSUES
		 * AARON--need to change JOptionPane that pops up after game ends
		 * ACK--Change the max speed of the puck (make it lower?)
		 */
	}
	
	public static void singlePlayer(){
		
		new ComputerGAME();
		System.exit(0);
	}
	
	public static void twoPlayer(){
		
		//sets up the two person multiplayer menu
		TwoPlayerMenu twoPlayerMenu = new TwoPlayerMenu();

		//waits until you have clicked either join or host and been connected
		while(!twoPlayerMenu.isButtonClicked()){
			//thread.sleep saves processor space
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){}
		}

		//figures out which button you have pressed and acts accordingly

		switch(twoPlayerMenu.getButton())
		{
		case 'h': new ServerGAME(twoPlayerMenu.getServer()); //host was selected, it starts the ServerGAME using the server from within the menu class
		break;
		case 'j': new ClientGAME(twoPlayerMenu.getClient()); //join was selected, it starts the ClientGAME code using the already connected client from within the menu class
		break;
		default: JOptionPane.showMessageDialog(null, "Error with two-player menu!", "ERROR", JOptionPane.ERROR_MESSAGE);
		break;
		}
		System.exit(0);
	}
	
	public static void fourPlayer(){
		
		FourPlayerMenu fourPlayerMenu = new FourPlayerMenu();
		
		while(!fourPlayerMenu.isButtonClicked()){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){}
		}
		
		switch(fourPlayerMenu.getButton())
		{
		case 'h': JOptionPane.showMessageDialog(null, "Server Game");
		break;
		case 'j': JOptionPane.showMessageDialog(null, "Client Game");
		break;
		default: JOptionPane.showMessageDialog(null, "Error with four-player menu!", "ERROR", JOptionPane.ERROR_MESSAGE);
		break;
		}
		
		System.exit(0);
	}
}
