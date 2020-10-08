package jespermattiasson;

// Import classes
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



//Create GUI and its contents
public class UserInterface extends JFrame{
	
//Initialize all swing objects.
private JPanel pnlNorth = new JPanel();  
private JPanel pnlSouth = new JPanel(); 
	
//Create buttons.
private JButton firstButton = new JButton("Sound1");
private JButton secondButton = new JButton("Sound2");


//Constructor for the GUI.
public UserInterface(){
	
	// Add buttons to panels.
	pnlSouth.add(firstButton);
	pnlSouth.add(secondButton);
	
	
	// Setup Main Frame.
	getContentPane().setLayout(new BorderLayout()); // Add layout to frame.
	getContentPane().add(pnlNorth, BorderLayout.NORTH); 
	getContentPane().add(pnlSouth, BorderLayout.SOUTH); 
		
	// Add action listeners.
	firstButton.addActionListener(new Sound());
	secondButton.addActionListener(new Sound());
		
}
	
//Display Frame.
public void launchFrame(){
	
	setTitle("NotePlayer");
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Allow frame to close.
	setSize(200,200); // Set frame size.
	setVisible(true); // Allow frame to be visible.
}
	

		
}
		
	
	
