import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Project3{
  public static String unsorted_string;
  public static String sorted_string;
  public static SortedBoxList sorted_boxes;
  public static UnSortedBoxList unsorted_boxes;
  public static void main(String[] args){
    BoxGUI.initialization("Project3", 500, 500);
  }

  public static void readNumber(String fileath){
    //scan the input.txt
    UnSortedBoxList unsorted = new UnSortedBoxList();
    SortedBoxList sorted = new SortedBoxList();

    TextFileInput input = new TextFileInput(fileath);
    String line;
    line = input.readLine();
    while((line!= null)) {
      StringTokenizer myTokens = new StringTokenizer(line,",");
      int length = Integer.parseInt(myTokens.nextToken());
      int width  = Integer.parseInt(myTokens.nextToken());
      int height = Integer.parseInt(myTokens.nextToken());
      Box boxOnUnsorted = new Box(length,width,height);
      Box boxOnSorted = new Box(length,width,height);
      unsorted.add(boxOnUnsorted);
      sorted.add(boxOnSorted);
      line = input.readLine();
   }
    //[box1,box2,box3]
    Project3.unsorted_string = unsorted.toString();
    Project3.sorted_string= sorted.toString();
    sorted_boxes = sorted;
    unsorted_boxes = unsorted;
    // BoxGUI.start(unsorted_string ,sorted_string);
    // I store data into my program
  }
  public static void reDisplayContent(){
      BoxGUI.setTextArea(unsorted_string, sorted_string);
  }
  public static String getBoxStringLessThanVolume(int volume){
    return sorted_boxes.toStringLessThanVolume(volume);
  }

}
