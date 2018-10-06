public abstract class BoxList{
  protected BoxNode first;
  protected BoxNode last;
  protected int length;
  //constructor
  public BoxList(){
    first = new BoxNode(null);
    last = first;
    length = 0;

  }
  public void append(Box b){
      BoxNode n = new BoxNode(b);
      last.next = n;
      last = n;
      length++;
  }

  public String toString(){
      String boxStringResult = "";
      BoxNode curBoxPointer = this.first.next();
      while(curBoxPointer != null ){
        boxStringResult += curBoxPointer.data.toString() + "\n";
        curBoxPointer = curBoxPointer.next;
      }
      return boxStringResult;

  }

}
