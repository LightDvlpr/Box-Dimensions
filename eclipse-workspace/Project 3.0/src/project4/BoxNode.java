package project4;
public class BoxNode {
protected Box data = new Box();
protected BoxNode next;
	BoxNode(){
		data = null;
		next = null;
	}
	BoxNode(Box aBox){
		data = aBox;
		next = null;
	}
}
