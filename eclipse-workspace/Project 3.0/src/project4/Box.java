package project4;
public class Box {
	int height;
	int length;
	int width;
	// default constructor with no parameters and assigned values 
	Box(){
		width = 1;
		length = 1;
		height = 1;	
	}
	// Three argument constructor that creates box with the given measurements
	Box(int h, int w, int l){
		if ( (h < 1) || (l< 1) || (w <1)) {
			throw new illegalBoxException("Value cannot be less than 1");
		}
		height = h;
		width = w;
		length = l;
	}
	
	//Volume constructor that returns the volume of the box with given measurements
	public int Volume() {
		return height*length*width; 
	}
	
	
//toString method that is being overridden so that it's specific to my "Box
	
    public String toString(){
      return "L:"+getLength() + " H:" +getHeight()+ " W:"+getWidth()+ " (V: "+Volume()+")" ;
             
    }
        
 
    
    

//equals method that will be used to compare boxes to see if they equal eachother as well as error check
//to make sure that the values are no lower than 1
 public boolean equals(Box b) {
    	   if(b == null )return false;
       if (this.height == b.height && this.width == b.width && this.length == b.length) {
          
          return true;
        }
     return false;
        
    }
	
	
	
//get methods of the instance variables where we return the value of our height, width, and length	
	public int getHeight() {
		return height;		
	}
	public int getWidth() {
		return width;
	}
	public int getLength() {
		return length;
	}
//set methods of the instance variables where we set a value to the height, width and length
	public void setHeight(int x) {
		height = x;
	}
	public void setWidth(int x) {
		width = x;
	}
	public void setLength(int x) {
		length = x;
	}
	
}

	


