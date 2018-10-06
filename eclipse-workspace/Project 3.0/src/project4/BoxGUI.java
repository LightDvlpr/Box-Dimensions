package project4;
import java.awt.*;
import java.util.TreeMap;
import java.util.HashMap;

import javax.swing.*;
public class BoxGUI extends JFrame {
	static JFrame myFrame;
	static Container cPane;
	static TextArea sorted, unsorted;
	public BoxGUI(HashMap<Box,Integer> boxes, TreeMap<Box,Integer> b) {
		initialize();
		createMenu();
		myFrame.setLayout(new GridLayout(1,2));
		myFrame.setTitle("Project 1");
		cPane = myFrame.getContentPane();
		cPane.add(unsorted);
		cPane.add(sorted);
		BoxGUI.unsorted.append("Unsorted"+"\n");
		BoxGUI.sorted.append("Sorted"+ "\n");
		BoxNode ptr1,ptr2;
		
		// attempting to go through the hashmap, or treemap collection
		 HashMap<Integer, Box> unsorted = new HashMap<>();
		 TreeMap<Integer, Box> sorted = new TreeMap<>();
		 for (Box box : boxes.keySet()) {
			BoxGUI.unsorted.append(box.toString() + "\n");
		 }
		for(Box box : b.keySet()) {
			BoxGUI.sorted.append(box.toString() + "\n");
		}
		BoxGUI.myFrame.setVisible(true);
	}

	  public static void setTextArea(String left, String right){

	    unsorted.setText(left);
	    sorted.setText(right);
	  }
	
	public void createMenu() {
		JMenuBar jmb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu toolsMenu = new JMenu("Tools");
		JMenuItem item;
		fileMenuHandler fmh = new fileMenuHandler(this);
		ToolsMenuHandler tmh = new ToolsMenuHandler();
		item = new JMenuItem("Open");
		fileMenu.add(item);
		item.addActionListener(fmh);
		fileMenu.addSeparator();
		item = new JMenuItem("Quit");
		fileMenu.add(item);
		item.addActionListener(fmh);
		item = new JMenuItem("Search");
		toolsMenu.add(item);
		item.addActionListener(tmh);
		jmb.add(fileMenu);
		jmb.add(toolsMenu);
		myFrame.setJMenuBar(jmb);
		
	}

	

	public static void initialize() {
		sorted = new TextArea();
		unsorted = new TextArea();
		myFrame = new JFrame();
		myFrame.setSize(400,400);
		myFrame.setLocation(200, 200);
		myFrame.setTitle("");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	   
}