package jespermattiasson;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

//Create class to play a note.
public class MidiSynthesizer {
	
	// Array containing values for MIDI notes.
	int[] notes = new int[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83};
		
	// Method to access, play and stop a note.
	void playIt(int playnote){
		
	// Enclose a block of code that can generate errors, create catches.
	try 
	{
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
