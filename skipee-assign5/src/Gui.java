/* -------------------------------------------- *\
 *  Welcome to Jack Dacey's SWING Chat Program  *
 *             Written by: Jack Dacey           *
\* -------------------------------------------- */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener {
	static JFrame everything;		//
	static JPanel pan;			// Static Declaration
	static JLabel text1, text2, timr;	// of GUI Components
	static JTextField box1, box2;		//  needed for this 
	static Timer tim;			//      program
	static JButton btn1, btn2;		//
	static JSlider vol;			//

	int secs, mins, hours;			// Declaration of various
	boolean connected;			// variables used in components

	public Gui() {
		//Initializing the variables declared above
		secs = 0;
		mins = 0;
		hours = 0;
		connected = false;
		pan = new JPanel(new GridLayout(4,2));
		this.add(pan);
		
		//Initializing the components + JPanel to what we want
		text1 = new JLabel("IP Address: ");
		text2 = new JLabel("Port: ");
		box1 = new JTextField(1);
		box2 = new JTextField(1);
		btn1 = new JButton("Connect");
		btn1.addActionListener(this);
		btn1.setActionCommand("connbutton");
		btn2 = new JButton("Disconnnect");
		btn2.addActionListener(this);
		btn2.setActionCommand("discbutton");
		timr = new JLabel("");
		tim = new Timer(1000, this);
		vol = new JSlider();
		
		//Adding the components to the JPanel
		pan.add(text1);
		pan.add(box1);
		pan.add(text2);
		pan.add(box2);
		pan.add(btn1);
		pan.add(btn2);
		pan.add(timr);
		pan.add(vol);
		
		//Starting the timer
		tim.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("timer")==0){	//If the action event is for the timer,
			if (connected){					// First, check if we are connected, if so,
				secs++;					// Increment Seconds
				if (secs==60){				// Unless that makes it 60, in which case,
					mins++;				// Increment Minutes by one, and then
					secs=0;				// Reset seconds to 0
				}
				if (mins==60){				//Then, if minutes becomes 60 from the above,
					hours++;			// Increment hours and then
					mins=0;				// Reset minutes to 0
				}
			}
			timr.setText(hours + ":" + mins + ":" + secs);	// Set the timr label's text
		}
		if (e.getActionCommand().compareTo("connbutton")==0){	//If the action event is for the connect button,
			//Connect					// Well... Not done yet...
		}
		if (e.getActionCommand().compareTo("discbutton")==0){	//If the action event is for the disconnect button,
			//Disconnect					// Ooh, this is embarassing... Do this too...
		}
	}
}

//TODO in Gui:
//   -Implement the Connect button
//   -Implement the Disconnect button
//   -Spice up the UI, aka, design
