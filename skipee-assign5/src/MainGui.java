/* -------------------------------------------- *\
 *  Welcome to Jack Dacey's SWING Chat Program  *
 *             Written by: Jack Dacey           *
\* -------------------------------------------- */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainGui {
	public static void main(String[] args) {
		JFrame everything = new Gui();

		everything.setLocation(0,0);
		everything.setSize(240, 400);
		everything.setVisible(true);
		everything.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


//TODO in MainGui:
//  -Import location/size from a configuration file
