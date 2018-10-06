import javax.swing.*;
import java.io.File;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FileMenuHandler implements ActionListener{
    JFrame jframe;

    public FileMenuHandler(JFrame jf){
      this.jframe = jf;
    }
    public void actionPerformed(ActionEvent event){
      String menuName = event.getActionCommand();
      if(menuName.equals("Open")){
        final JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file  = fc.getSelectedFile();
        String input = file.getPath();
        Project3.readNumber(input);
        Project3.reDisplayContent();
      }else if (menuName.equals("Quit"))
       System.exit(0);
    }

}
