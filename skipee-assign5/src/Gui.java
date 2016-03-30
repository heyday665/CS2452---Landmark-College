/* -------------------------------------------- *\
 *  Welcome to Jack Dacey's SWING Chat Program  *
 *             Written by: Jack Dacey           *
\* -------------------------------------------- */

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.util.concurrent.Semaphore;

public class Gui extends JFrame implements ActionListener {
	static JFrame 		everything;			//
	static JPanel 		guiPanel;			//    Declaration
	static JLabel 		Label_IPAddress;		//
	static JLabel 		Label_Port;			//
	static JLabel 		Label_callTime;			// of GUI Components
	static JTextField 	Box_IPAddress;			//
	static JTextField 	Box_Port;			//  needed for this 
	static Timer 		callTime;			//      program
	static JButton 		Button_Connect;			//
	static JButton 		Button_Disconnect;		//
	static JSlider 		volumeSlider;			//

	int secs, mins, hours;					// Declaration of various
	boolean connected;					// variables used in components

	Semaphore flg1;
	Socket clientSock;
	int portNumber;
	InetAddress ipAddr;

	public Gui(boolean cs, Semaphore s1) {
		//Initializing the variables declared above
		secs = 0;
		mins = 0;
		hours = 0;
		portNumber = 7658;
		connected = cs;
		flg1 = s1;
		ipAddr = null;
		guiPanel = new JPanel(new GridLayout(4,2));
		this.add(guiPanel);
		this.setTitle("Skipee");
		
		//Initializing the components + JPanel to what we want
		Label_IPAddress	= new JLabel("IP Address: ");
		Label_Port	= new JLabel("Port: ");
		Box_IPAddress	= new JTextField(1);
		Box_Port	= new JTextField(1);

		Button_Connect	= new JButton("Connect");
		Button_Connect.addActionListener(this);
		Button_Connect.setActionCommand("connbutton");
		Button_Disconnect = new JButton("Disconnnect");
		Button_Disconnect.addActionListener(this);
		Button_Disconnect.setActionCommand("disconnbutton");

		Label_callTime 	= new JLabel("", SwingConstants.CENTER);
		callTime 	= new Timer(1000, this);
		volumeSlider	= new JSlider();
		volumeSlider.setMinorTickSpacing(5);
		volumeSlider.setMajorTickSpacing(25);
		volumeSlider.createStandardLabels(25);
		volumeSlider.setPaintLabels(true);
		volumeSlider.setSnapToTicks(true);
		callTime.setActionCommand("timer");		

		//Adding the components to the JPanel
		guiPanel.add(Label_IPAddress);
		guiPanel.add(Box_IPAddress);
		guiPanel.add(Label_Port);
		guiPanel.add(Box_Port);
		guiPanel.add(Button_Connect);
		guiPanel.add(Button_Disconnect);
		guiPanel.add(Label_callTime);
		guiPanel.add(volumeSlider);
		
		//Starting the timer
		callTime.start();
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
			Label_callTime.setText(hours + ":" + mins + ":" + secs);	// Set the timr label's text
			if (connected) {Button_Connect.setEnabled(false); Button_Disconnect.setEnabled(true);}
			if (!connected) {Button_Connect.setEnabled(true); Button_Disconnect.setEnabled(false);}
		}
		if (e.getActionCommand().compareTo("connbutton")==0){	//If the action event is for the connect button,
			if (!connected) {
				connected = true;
				Button_Connect.setEnabled(false);
				Button_Disconnect.setEnabled(true);
				try{ipAddr = InetAddress.getByName(Box_IPAddress.getText());} catch(Exception e1) {e1.printStackTrace(System.out);}
				Box_IPAddress.setText("");
				Box_Port.setText("");
				
				try{flg1.acquire();} catch(Exception e3) {e3.printStackTrace(System.out);}
				if (!connected) {
					try{clientSock = new Socket(ipAddr, portNumber);
						CALL call = new CALL(clientSock);} catch (Exception e2) {e2.printStackTrace(System.out);}
				}
				flg1.release();
			}
			else {
				//do nothing
			}
			secs = (mins = (hours = 0));
		}
		if (e.getActionCommand().compareTo("disconnbutton")==0){//If the action event is for the disconnect button,
			if (connected) {
				connected = false;
				Button_Connect.setEnabled(true);
				Button_Disconnect.setEnabled(false);
				//disconnect from other client
			}
			else {
				//do nothing
			}
		}
	}
}

//TODO in Gui:
//   -Implement the Connect button
//   -Implement the Disconnect button
//   -Spice up the UI, aka, design
