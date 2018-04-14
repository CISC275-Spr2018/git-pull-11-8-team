import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class BtnPane extends JPanel {
	private JButton pauseBtn;
	private JPanel radioPane;
	private JRadioButton eastBtn;
	private JRadioButton westBtn;	
//	private JRadioButton weNBtn;
	private JRadioButton northBtn;
	private JRadioButton southBtn;
//	private JRadioButton nsNBtn;
	private ActionHandle aHandle = new ActionHandle(); 
	private String startCmd;
	private String directionCmd;
	private String statusCmd = "forward";
	
	private String movDirCmd;
	
	
	public BtnPane(){
		
		
		pauseBtn = new JButton("Pause");
		pauseBtn.setActionCommand("pause");
		startCmd = pauseBtn.getActionCommand();
		pauseBtn.addActionListener(aHandle);
		eastBtn = new JRadioButton("east");
		eastBtn.setActionCommand("east");
		eastBtn.addActionListener(aHandle);
		westBtn = new JRadioButton("west");
		westBtn.setActionCommand("west");
		westBtn.addActionListener(aHandle);
		//weNBtn = new JRadioButton("none");
		//weNBtn.setActionCommand("weNone");
		//weNBtn.addActionListener(ahandle);
		
		northBtn = new JRadioButton("north");
		northBtn.setActionCommand("north");
		northBtn.addActionListener(aHandle);
		southBtn = new JRadioButton("south");
		southBtn.setActionCommand("south");
		southBtn.addActionListener(aHandle);
		//nsNBtn = new JRadioButton("none");
		//nsNBtn.setActionCommand("nsNone");
		//nsNBtn.addActionListener(ahandle);
		
		directionCmd = "southeast";
		movDirCmd = directionCmd;
		
		ButtonGroup we = new ButtonGroup();
		we.add(eastBtn);
		we.add(westBtn);
		//we.add(weNBtn);
		ButtonGroup ns = new ButtonGroup();
		ns.add(northBtn);
		ns.add(southBtn);
		//ns.add(nsNBtn);
		
		radioPane = new JPanel();
		radioPane.setLayout(new GridLayout(2,2));
		radioPane.add(eastBtn);
		radioPane.add(westBtn);
		//radioPane.add(weNBtn);
	
		radioPane.add(northBtn);
		radioPane.add(southBtn);
		//radioPane.add(nsNBtn);
		
		this.add(pauseBtn);
		this.add(radioPane);
		this.addKeyListener(new KeyHandle());
		this.setFocusable(true);
		
	}//constructor
	
	public String getStartCmd(){
		return startCmd;
	}
	
	public String getMovCmd(){
		return movDirCmd;
	}
	
	public String getDirectionCmd(){
		return directionCmd;
	}
	
	public String getStatusCmd(){
		return statusCmd;
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setContentPane(new BtnPane());
		jf.setSize(800, 800);
		jf.setVisible(true);
		
	}//main
	
	public class ActionHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = e.getActionCommand();
			if(str.equalsIgnoreCase("pause")){
				JButton jBtn = (JButton) e.getSource();
				jBtn.setActionCommand("start");
				jBtn.setText("Start");
				startCmd = "Start";
				//System.out.println(startCmd);
			}else if(str.equalsIgnoreCase("start")){
				JButton jBtn = (JButton) e.getSource();
				jBtn.setActionCommand("pause");
				jBtn.setText("Pause");
				startCmd = "Pause";
				//System.out.println(startCmd);
			}else{
				switch(str){
				case "east" : directionCmd = directionCmd.substring(0, 5) + str; break;
				case "west" : directionCmd = directionCmd.substring(0, 5) + str; break;
				//case "weNone" : directionCmd = directionCmd.substring(0, 5); break;
				case "north" : directionCmd = str + directionCmd.substring(5) ; break;
				case "south" : directionCmd = str + directionCmd.substring(5); break;
				//case "nsNone" : directionCmd = directionCmd.substring(5); break;
				default : directionCmd = "southeast"; break;
				}//swithc
				//System.out.println(directionCmd);
				movDirCmd = directionCmd;
			}//if-else if-else
		}

	}
	
	public class KeyHandle implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			char c = e.getKeyChar();
			
			/*switch(i){
			case KeyEvent.VK_DOWN: movDirCmd = "south"; break;
			case KeyEvent.VK_UP: movDirCmd = "north"; break;
			case KeyEvent.VK_RIGHT: movDirCmd = "east"; break;
			case KeyEvent.VK_LEFT: movDirCmd = "west"; break;
			default: movDirCmd = directionCmd;
			}*/
			switch(c){
			case 's': movDirCmd = "south"; break;
			case 'w': movDirCmd = "north"; break;
			case 'd': movDirCmd = "east"; break;
			case 'a': movDirCmd = "west"; break;
			default: movDirCmd = directionCmd;
			}
			System.out.println(movDirCmd);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			movDirCmd = directionCmd;
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getKeyChar());
		}}

}