package project4;
import javax.swing.*;
import java.io.File;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class fileMenuHandler implements ActionListener{
    JFrame jframe;

    public fileMenuHandler(JFrame jf){
      this.jframe = jf;
    }
    public void actionPerformed(ActionEvent event){
      String menuName = event.getActionCommand();
      if(menuName.equals("Open")){
        final JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file  = fc.getSelectedFile();
        String input = file.getPath();
        Project4.readNumber(input);
        Project4.reDisplayContent();
      }else if (menuName.equals("Quit"))
       System.exit(0);
    }

}