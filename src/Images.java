import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Images {
	private int imgWidth = 165;
	private int imgHeight = 165;
	private String status;
	private int count;
	private HashMap<String, BufferedImage[]> bfImages = new HashMap<String, BufferedImage[]>();
	
	public Images(Status s){
		this.status = s.getName();
		this.count = s.getCount();
		for(Direction d : Direction.values()){
			bfImages.put(d.getName(), createImages(d.getName()));
		}
	}
	
	public Images(String s, int c){
		this.count = c;
		this.status = s;
		bfImages = s.equalsIgnoreCase("idle")? createIdleImages():null;
	}
	
	public int getCount(){
		return count;
	}
	
	public String getStatus(){
		return status;
	}
	

	public BufferedImage[] getbfImg(String str) {
		return bfImages.get(str);
	}
	
	public HashMap<String, BufferedImage[]> getbhash() {
		return bfImages;
	}
	
	
	   private BufferedImage[] createImages(String dir){
    	BufferedImage bufferedImage;
    	BufferedImage[] imgs = new BufferedImage[count];
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc/orc_"+ status +"_"+ dir + ".png"));
        	for(int i = 0; i < count; i++){
        		imgs[i] = bufferedImage.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
        	}//for
    		return imgs;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }//createStatusImages
	   
	   private HashMap<String, BufferedImage[]> createIdleImages(){
		   HashMap<String, BufferedImage[]> result = new HashMap<String, BufferedImage[]>();
			   result.put("east", createArrayImages("idle", "ewns", 4, 0));			   
			   result.put("west", createArrayImages("idle", "ewns", 4, 1));
			   result.put("north", createArrayImages("idle", "ewns", 4, 2));
			   result.put("south", createArrayImages("idle", "ewns", 4, 3));
			   
			   result.put("northwest", createArrayImages("idle", "nwneswse", 4, 0));			   
			   result.put("northeast", createArrayImages("idle", "nwneswse", 4, 1));
			   result.put("southwest", createArrayImages("idle", "nwneswse", 4, 2));
			   result.put("southeast", createArrayImages("idle", "nwneswse", 4, 3));
			   
		   
		   return result;
	   }//createIdleImages
	   
	   private BufferedImage[] createArrayImages(String status, String dir, int size, int row){
		   BufferedImage[] temp = new BufferedImage[size];
	    	BufferedImage bufferedImage;
	    	try {
	    		bufferedImage = ImageIO.read(new File("images/orc/orc_"+ status +"_"+ dir + ".png"));
	        	for(int i = 0; i < size; i++){
	        		temp[i] = bufferedImage.getSubimage(imgWidth*i, imgHeight *row, imgWidth, imgHeight);
	        	}//for
	    		return temp;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
		   return temp;
	   }

}
