import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements Actionlistener {
	static JFrame everything;
	static JPanel pan;
	static JLabel text1, text2;
	static JTextField box1, box2;
	static Timer tim;
	static JButton btn1, btn2;
	static JSlider vol;

	int sec, min, hour;
	sec = 0; min = 0; hour = 0;

	public Gui() {
		pan = new JPanel(new GridLayout(4,2))
		this.add(pan);
		
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
		timer = new Timer(1000, this);
		vol = new JSlider();

		this.add(text1);
		this.add(text2);
		this.add(box1);
		this.add(box2);
		this.add(btn1);
		this.add(btn2);
		this.add(timer);
		this.add(vol);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("timer")==0){
			sec++;
			if (sec==60){
				min++;
				sec=0;
			}
			if (min==60){
				hour++;
				min=0;
			}
		}
		if (e.getActionCommand().compareTo("connbutton")==0){
			//Connect
		}
		if (e.getActionCommand().compareTo("discbutton")==0){
			//Disconnect
		}
	}
}
