public class BoxNode{
  public Box data;
  public BoxNode next;
  public BoxNode(Box d){
    this.data = d;  //this is copied by reference  *******
    next = null;
  }
  public Box data(){
    return data;
  }

  public BoxNode next(){
    return next;
  }
}
