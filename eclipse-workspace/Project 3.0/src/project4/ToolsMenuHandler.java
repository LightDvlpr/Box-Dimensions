package project4;
import javax.swing.*;
import java.io.File;
import java.util.StringTokenizer;
import java.awt.TextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolsMenuHandler implements ActionListener{


    public ToolsMenuHandler(){

    }

    public void actionPerformed(ActionEvent event){

      String menuName = event.getActionCommand();
      if(menuName.equals("Search")){
        if(Project4.sorted_boxes == null){
          JOptionPane.showMessageDialog(null,"please open file first");
          return;
        }
        String input = JOptionPane.showInputDialog(null, "please input the dimension of a box with formate xx,xx,xx");
        StringTokenizer tokens =  new StringTokenizer(input,",");
        if(tokens.countTokens()!= 3){
          JOptionPane.showMessageDialog(null,"input is so wrong");
          return;
        }
        int width, length, height;
        try{
          width  = Integer.parseInt(tokens.nextToken());
          length  = Integer.parseInt(tokens.nextToken());
          height = Integer.parseInt(tokens.nextToken());

        }catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null,"please input 3 numbers");
          return;
        }

        if(width < 1 || length < 1 || height < 1 ){
          JOptionPane.showMessageDialog(null,"please input  numbers that are bigger than 1");
          return;
        }

        int volume = width *length * height;
        this.displayBoxLessThanVolume(volume);
      }

    }

    public void displayBoxLessThanVolume(int volume){
      JFrame resultF = new JFrame();
      resultF.setTitle("Box that fits for volume " + volume);
      resultF.setSize(500,500);
      resultF.setLocation(800,200);
      TextArea resultT = new TextArea();
      resultF.getContentPane().add(resultT);
      resultT.setText(Project4.getBoxStringLessThanVolume(volume));
      resultF.setVisible(true);
    }
}
