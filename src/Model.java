/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/
/*
 * name : ZhangQingsen
 * name : FengYue
 * */
public class Model{
	private int width;
	private int height;
	private int imWidth;
	private int imHeight;
	private Direction d;
	private int posX;
	private int posY;
	private int xInc = 8;
	private int yInc = 5;
	
	public Model(int wi, int hi, int imWi, int imHei){
		this.width = wi;
		this.height = hi;
		this.imWidth = imWi;
		this.imHeight = imHei;
		this.posX = 0;//imWidth/2 + 1
		this.posY = 0;//imHeight/2 + 1
		this.d = Direction.SOUTHEAST;
	}//Model
	
	
	public void updateLocationAndDirection(String startCmd, String dirCmd){
		if(startCmd.equalsIgnoreCase("Start")){}else{
    	posX += d.getXdir() * xInc;
    	posY += d.getYdir() * yInc;
    	updateDirection(dirCmd);
    	updateDir();}
	}//updateLocationAndDirection 

	public int getX() {
		 return posX;
	}//getX
	
	public int getY() {
		 return posY;
	}//getX
	
	public Direction getDirect() {
		 return d;
	}//getX
	
	public void updateDir(){
		String dirStr = checkYdir() + checkXdir();
		if(dirStr.compareToIgnoreCase(d.getName()) != 0){
			switch(dirStr){
			case "east" : d = Direction.EAST; break;
			case "west" : d = Direction.WEST; break;
			case "south" : d = Direction.SOUTH; break;
			case "north" : d = Direction.NORTH; break;
			case "northeast" : d = Direction.NORTHEAST; break;
			case "northwest" : d = Direction.NORTHWEST; break;
			case "southwest" : d = Direction.SOUTHWEST; break;
			default : d = Direction.SOUTHEAST; break;
			}//switch
		}//if
	}//updateDir
	
	public void updateDirection(String str) {
    	switch(str){
		case "east" : d = Direction.EAST; break;
		case "west" : d = Direction.WEST; break;
		case "south" : d = Direction.SOUTH; break;
		case "north" : d = Direction.NORTH; break;
		case "northeast" : d = Direction.NORTHEAST; break;
		case "northwest" : d = Direction.NORTHWEST; break;
		case "southwest" : d = Direction.SOUTHWEST; break;
		default : d = Direction.SOUTHEAST; break;
		}//switch
    }
	
	public String checkXdir(){
		String str = (d.getXdir() == 0)? "": d.getName().substring(5);
		if(str.equals("")){
		}else if(posX <= 0){
			str = "east";
		}else if(posX > width - imWidth){
			str = "west";
		}
		return str;
	}//checkXdir
	
	public String checkYdir(){
		String str = (d.getYdir() == 0)? "": d.getName().substring(0, 5);
		if(str.equals("")){
		}else if(posY <= 0){
			str = "south";
		}else if(posY >= height - imHeight){
			str = "north";
		}
		return str;
	}//checkYdir
	
}//Model
