package project4;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;

import javax.swing.*;//We must import the javax.swing class to use the JOptionPane pop up dialog/prompt
//Noor Salim CS212 Lab Section 11H

// Purpose of scanner is to read the file and implement the dimensions of the box into the program
public class Project4 {
	public static String unsorted_string;
	  public static String sorted_string;
	  public static TreeMap<Box, Integer> sorted_boxes;
	  public static HashMap<Box, Integer> unsorted_boxes;
	  public static void main(String args[]) {
		
		
	File f = new File("Boxes.txt");
	Scanner sc = null;
//try will catch any errors or mistakes and be able to report them
	try {
	 	sc = new Scanner(f);
	}
	catch(Exception e) {
	}

//This array will be used to hold whatever input the text file holds. 
//It will scan it and make sure that it does not hold more than 100 lines of "boxes" 
	
	HashMap<Box,Integer> uList = new HashMap<>();
	TreeMap<Box,Integer> sList = new TreeMap<>(new BoxComparator());
	unsorted_boxes = uList;
	sorted_boxes = sList;
	String line;
	int index = 0;
		while(sc.hasNextLine() && index < 100) {
			line = sc.nextLine();
			String[] s  = line.split(",");
			int length = Integer.parseInt(s[0]);
			int height = Integer.parseInt(s[1]);
			int width = Integer.parseInt(s[2]);	
			try {
			uList.put(new Box(height,width,length), length*height*width);	
			sList.put(new Box(height,width,length), length*height*width);
			index++;
			}
			catch(illegalBoxException ibe)
			{
				System.err.println(ibe.getMessage());
			}
		}
		BoxGUI Gui = new BoxGUI(uList, sList);	
		sc.close();
	}
	public static void readNumber(String fileath){
	    //scan the input.txt
	    HashMap<Box, Integer> unsorted = new HashMap<>();
	    TreeMap<Box, Integer> sorted = new TreeMap<>(new BoxComparator());
	    try {
	     Scanner scan = new Scanner(new File(fileath));
	     String line;
	     while(scan.hasNextLine()) {
	    	  line = scan.nextLine();
	      StringTokenizer myTokens = new StringTokenizer(line,",");
	      int length = Integer.parseInt(myTokens.nextToken());
	      int width  = Integer.parseInt(myTokens.nextToken());
	      int height = Integer.parseInt(myTokens.nextToken());
	      try {
	      Box boxOnUnsorted = new Box(length,width,height);
	      Box boxOnSorted = new Box(length,width,height);
	      unsorted.put(boxOnUnsorted, 1);
	      sorted.put(boxOnSorted,1);
	     }
	     catch(illegalBoxException ibe) {
	    	  System.err.println(ibe.getMessage());
	     }
	    }
	    }
	    catch(Exception e)
	    {
	    		System.out.println("No such file");
	    }
	    //[box1,box2,box3]
	    Project4.unsorted_string = unsorted.toString();
	    Project4.sorted_string= sorted.toString();
	    sorted_boxes = sorted;
	    unsorted_boxes = unsorted;
	    // BoxGUI.start(unsorted_string ,sorted_string);
	    // I store data into my program
	  }
	  public static void reDisplayContent(){
		  unsorted_string = "";
		  sorted_string = "";
		  for (Box box : unsorted_boxes.keySet()) {
		      unsorted_string += box.toString() + "\n";
		  }
		  for(Box box : sorted_boxes.keySet()) {
			  sorted_string += box.toString() + "\n";
		  }
	      BoxGUI.setTextArea(unsorted_string, sorted_string);
	  }
	  public static String getBoxStringLessThanVolume(int volume){
	    return toStringLessThanVolume(volume, sorted_boxes);
	  }
	  public static String toStringLessThanVolume(int volume, TreeMap<Box, Integer> sorted_boxes) {
		  String s = "";
		  for (Box box : sorted_boxes.keySet()) {
			  if(box.Volume() > volume)
				s += box.toString() + "\n";
			}
		  return s;
	  }
}