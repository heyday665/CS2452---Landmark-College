/* -------------------------------------------- *\
 *  Welcome to Jack Dacey's SWING Chat Program  *
 *             Written by: Jack Dacey           *
\* -------------------------------------------- */

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Semaphore;

class MainGui {
	public static void main(String[] args) {
		try{ ServerSocket ss = new ServerSocket(7658);
			boolean connstatus = false;
			Semaphore flg1 = new Semaphore(1);
			
			System.out.println("starting hs thread");
			HandShake hs = new HandShake(ss, connstatus, flg1);		
			JFrame everything = new Gui(connstatus, flg1);
	
			everything.setLocation(0,0);
			everything.setSize(240, 400);
			everything.setVisible(true);
			everything.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e37) {e37.printStackTrace(System.out);}
	}
}


//TODO in MainGui:
//  -Import location/size from a configuration file
