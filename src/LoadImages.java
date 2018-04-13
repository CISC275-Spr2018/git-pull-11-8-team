import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class LoadImages {
	private Images forwardPics;
	private Images jumpPics;
	private Images diePics;
	private Images idlePics;
	private Images firePics;
	private HashMap<String, Images> imgPack = new HashMap<String, Images>();
	
	public LoadImages(){
		Images img = null;
		for(Status s: Status.values()){
			img = new Images(s);
			switch(s){
			case FORWARD: forwardPics = img;break;
			case FIRE: firePics = img;break;
			case JUMP: jumpPics = img;break;
			case DIE: diePics = img;break;
			}

			imgPack.put(s.getName(), img);
		}
		
		idlePics = new Images("idle", 4);
		imgPack.put("idle", idlePics);
		
	}
	
	public Images getImages(String str){
		return imgPack.get(str);
	}	
	
	public static void main(String[] args){
		LoadImages lodImg = new LoadImages();
		System.out.println(lodImg.getImages("die").getbhash());

	}//main

}
