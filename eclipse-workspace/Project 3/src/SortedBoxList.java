public class SortedBoxList extends BoxList{
  public SortedBoxList(){
    super();  //BoxList()
    //new thing
  }

  public void add(Box a){
    BoxNode temp = new BoxNode(a);
    BoxNode pre = this.first;
    while (pre.next != null && pre.next.data.compareTo(a) < 0){
      pre = pre.next;
    }
    temp.next = pre.next;
    pre.next = temp;
    this.length++;
  }

  public String toStringLessThanVolume(int volume){
    String boxStringResult = "";
    BoxNode curBoxPointer = this.first.next();
    while(curBoxPointer != null ){
      if(curBoxPointer.data.volume() > volume)return boxStringResult;
      boxStringResult += curBoxPointer.data.toString() + "\n";
      curBoxPointer = curBoxPointer.next;
    }
    return boxStringResult;
  }
}
