import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
/*
 * name : ZhangQingsen
 * name : FengYue
 * */

// this is a test version that shows the image is updated in main


public class View extends JFrame{
	private int imgIdx;
    final int frameCount = 10;
	final static int FWIDTH = 800;
	final static int FHEIGHT = 800;
	private int imgWidth = 165;
	private int imgHeight = 165;
	private int xloc;
	private int yloc;
	private String currentDir;
	private String currentState;	
	private LoadImages lodImg;
	DrawPanel drawPanel = new DrawPanel();
	BtnPane btn = new BtnPane();
	
	public View(){
		imgIdx = 0;
		
		currentDir = "southeast";
		currentState = "forward";
		
		lodImg = new LoadImages();
		
		this.getContentPane().setLayout(new FlowLayout());
		
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(FWIDTH, FHEIGHT);
    	this.getContentPane().add(btn);
    	this.getContentPane().add(drawPanel);
    	setVisible(true);
    	//pack();
	}
	

    
	public int getWidth(){
		return FWIDTH;
	}//getWidth
	
	public int getHeight(){
		return FHEIGHT;
	}//getWidth
	
	public int getImageWidth(){
		return imgWidth;
	}//getWidth
	
	public int getImageHeight(){
		return imgHeight;
	}//getWidth
	
	public BtnPane getBtnPane(){
		return btn;
	} 
	
	public void update(int x, int y, Direction d){

		xloc = x;
		yloc = y;
		currentDir = d.getName();
    	imgIdx = (btn.getStartCmd().equalsIgnoreCase("Start"))? imgIdx:(imgIdx+1) % frameCount;
    	drawPanel.repaint();
	}
	
    @SuppressWarnings("serial")
	private class DrawPanel extends JPanel {
    	int picNum = 0;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			
			//currentState = btn.getStatusCmd();
			
			
	    	//picNum = (btn.getStartCmd().equalsIgnoreCase("Pause"))? picNum: (picNum + 1) % frameCount;
	    	g.drawImage(lodImg.getImages(currentState).getbfImg(currentDir)[imgIdx], xloc, yloc, Color.gray, this);
		}

		public Dimension getPreferredSize() {
			return new Dimension(FWIDTH, FHEIGHT);
		}
	}
	

    public static void main(String[] args) throws InterruptedException{
    	Controller cl = new Controller();
    	cl.start();
    }//main
}//view