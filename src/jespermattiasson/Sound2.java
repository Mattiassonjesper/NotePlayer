package jespermattiasson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
