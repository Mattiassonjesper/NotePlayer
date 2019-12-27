package jespermattiasson;

// Import classes
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



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
	firstButton.addActionListener(new Sound1());
	secondButton.addActionListener(new Sound2());
		
}
	
//Display Frame.
public void launchFrame(){
	
	setTitle("NotePlayer");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allow frame to close.
	setSize(200,200); // Set frame size.
	setVisible(true); // Allow frame to be visible.
}
	
//Create class to play a note.
public class MidiSynthesizer {
	
	// Array containing values for MIDI notes.
	int[] notes = new int[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83};
		
	// Method to access, play and stop a note.
	void playIt(int playnote){
		
	// Enclose a block of code that can generate errors, create catches.
	try 
	{
		//Kolla mer på synthesizer så ljudet inte. Ljudhanteringen, öppna och stänga ljudfilen. 
		//När man spammar knappen ska ljudet inte vara kvarliggande i flera sekunder efter
		// Create synthesizer to generate tone.
		Synthesizer synthesizer = MidiSystem.getSynthesizer();
		// Open the synthesizer so it can acquire any resources it needs.
		synthesizer.open();
		// Obtains the set of MIDI channels controlled by this synthesizer.
		MidiChannel channel = synthesizer.getChannels()[0];
		// Starts the specified note sounding.
		channel.noteOn(playnote, 100);
		// Enclose a block of code that can generate errors, create catches.
		try 
		{
		
		channel.noteOff(playnote);
		}
		finally 
		{
		// Turns the specified note off.
	        channel.noteOff(playnote);
	         }
		} 
           // Thrown when a MIDI tone unavailable.
		catch(MidiUnavailableException e) 
		{
			// Print error message to console window.
			e.printStackTrace();
		}
	}
}
//Class for First button
public class Sound1 implements ActionListener{
	
	// Create instance of class.
	MidiSynthesizer midisynthesizer = new MidiSynthesizer();
		
	// Method to pass relevant note to the MidiSynthesizer class.
	public void playNote(){
		
	// Set the index of the note associated with this button.  
	int playnote = midisynthesizer.notes[0];
	// Send index to array of notes to play.
	midisynthesizer.playIt(playnote);
	}
		
	// Method to perform an action when the button is clicked.
	public void actionPerformed(ActionEvent e)
	{
	// Call the playNote method..
	playNote();
	}
	
	}
	
//Class for Second button
public  class Sound2 implements ActionListener{
	
	// Create instance of class.
	MidiSynthesizer midisynthesizer = new MidiSynthesizer();
		
	// Method to pass relevant note to the MidiSynthesizer class.
	public void playNote()
	{	
	// Set the index of the note associated with this button.
   
	int playnote = midisynthesizer.notes[20];
	// Send index to array of notes to play.
	midisynthesizer.playIt(playnote);
	}
		
	// Method to perform an action when the button is clicked.
	public void actionPerformed(ActionEvent e)
	{
	// Call the playNote method..
	playNote();
	}
	
	
}

		public static void main(String args[])
		{  
			// Create object for GUI.
			UserInterface frame = new UserInterface();
			// Display GUI.
			frame.launchFrame();
	   
		}
}
		
	
	
