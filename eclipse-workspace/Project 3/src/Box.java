public class Box {     // David Mera  Section 11[22753]

	private int length, width, height;

    public Box() {
	length = width = height = 1;
	}

	public Box(int a, int b, int c) {

	    if (a < 1 || b < 1 || c < 1)
		   throw new IllegalArgumentException("Enter integer(s) no less than 1 ");

		this.length = a;
		this.width = b;
		this.height = c;
	}

	public int getLength() {return length;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}

	public void setLength(int l) {
        if(l < 1)
			throw new IllegalArgumentException("Enter length no less than 1 ");

        length = 1;
	}

	public void setWidth(int w) {
		if(w < 1)
           throw new IllegalArgumentException("Enter width no less than 1 ");

        width = w;
	}

	public void setHeight(int h) {
		if(h < 1)
           throw new IllegalArgumentException("Enter height no less than 1 ");

        height = h;
	}

    public int volume() {
       return(length * width * height);
    }

	public String toString(){
			String ret = "";
			ret += "L:" + getLength() + " W:" + getWidth()+" H:" + getHeight();
			ret += " (V: " + volume() + ")";
			return ret;
		}

	public boolean equals(Box b){
      if(length== b.length && width == b.width &&height == b.height )return true;
			return false;
		}

	public static void main(String[] args){
		Box test = new Box();
		System.out.println(test.toString());
        Box t2 = new Box(1,1,1);
		System.out.println(test.equals(t2));
	}
	public int compareTo(Box otherBox){
    if(this.volume() < otherBox.volume()){
			return -1;
		}else if(this.volume() > otherBox.volume()){
			return 1;
		}else{
			return 0;
		}
	}

}
