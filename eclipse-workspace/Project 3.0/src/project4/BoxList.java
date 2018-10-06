package project4;
public class BoxList {
	BoxNode first;
	BoxNode last;
	int length;
	BoxList(){
		first = new BoxNode();
		last = first;
		length = 0;
	}
	public void append(Box aBox) {
		BoxNode box = new BoxNode(aBox);
		last.next = box; 
		last = box;
	}

	  public String toString(){
	      String boxStringResult = "";
	      BoxNode curBoxPointer = this.first.next;
	      while(curBoxPointer != null ){
	        boxStringResult += curBoxPointer.data.toString() + "\n";
	        curBoxPointer = curBoxPointer.next;
	      }
	      return boxStringResult;

	  }
}
