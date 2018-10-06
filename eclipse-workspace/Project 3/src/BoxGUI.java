import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BoxGUI{
  static JFrame frame;
  static TextArea rowBoxes, sortedBoxes;
  public static void initialization(String title, int height, int width){

    frame = new JFrame();
    frame.setSize(height,width);
    frame.setLocation(500,300);
    frame.setTitle(title);
    createMenu(frame);
    frame.setLayout(new GridLayout(1,2));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    rowBoxes = new TextArea();
    sortedBoxes = new TextArea();
    frame.getContentPane().add(rowBoxes);
    frame.getContentPane().add(sortedBoxes);
    frame.setVisible(true);
  }

  public static void setTextArea(String left, String right){

    rowBoxes.setText(left);
    sortedBoxes.setText(right);
  }

  public static void createMenu(JFrame jf){
    JMenuItem item;
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    FileMenuHandler fmh = new FileMenuHandler(jf);
    ToolsMenuHandler tmh = new ToolsMenuHandler();

    item = new JMenuItem("Open");
    item.addActionListener(fmh);
    fileMenu.add(item);
    fileMenu.addSeparator();
    item = new JMenuItem("Quit");
    item.addActionListener(fmh);
    fileMenu.add(item);

    JMenu toolsMenu = new JMenu("Tools");
    item = new JMenuItem("Search");
    item.addActionListener(tmh);
    toolsMenu.add(item);
    menuBar.add(fileMenu);
    menuBar.add(toolsMenu);
    jf.setJMenuBar(menuBar);


  }
}
