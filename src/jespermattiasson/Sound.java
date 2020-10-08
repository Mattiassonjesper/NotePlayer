package jespermattiasson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//Class for First button
public class Sound implements ActionListener{
	
	// Create instance of class.
	MidiSynthesizer midisynthesizer = new MidiSynthesizer();
		
	// Method to pass relevant note to the MidiSynthesizer class.
	public void playNote(int note){
		
	// Set the index of the note associated with this button.  
	int playnote = midisynthesizer.notes[note];
	// Send index to array of notes to play.
	midisynthesizer.playIt(playnote);
	}
		
	// Method to perform an action when the button is clicked.
	public void actionPerformed(ActionEvent e)
	{
		// Call the playNote method..
				Object o = e.getSource();
				JButton b = null;
				
				if(o instanceof JButton) b = (JButton)o;
				//System.out.println(b.getText());
				if (b.getText().equals("Sound1"))playNote(0);
				if (b.getText().equals("Sound2"))playNote(20);
			}
	
	
	}
