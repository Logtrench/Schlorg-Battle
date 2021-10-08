import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
  private int count = 0;
  private JFrame frame;
  private JPanel panel;
  private JLabel label;
  private JLabel label2;
  private ImageIcon icon;
  

//trying gui with image
  public GUI() 
  {
   //creating new objects of type frame and panel and button
    frame = new JFrame();
    icon = new ImageIcon("majestic_bear.jpg");
    label = new JLabel(icon);
    label2 = new JLabel("sup ma boy");


    panel = new JPanel();

    //setting border of panel ()
    panel.setBorder(BorderFactory.createEmptyBorder(100, 200, 50, 70));

    //making layout, aka
    panel.setLayout(new GridLayout(0, 1));


    //add panel to frame
    frame.add(panel, BorderLayout.CENTER);

    //add  label
    panel.add(label);
    panel.add(label2);

    //set closing behaviour
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //title
    frame.setTitle("Gui");

    //set window to match certain size
    frame.pack();

    //make it visible.
    frame.setVisible(true);


  }


  
  @Override
  public void actionPerformed(ActionEvent e)
  {
      count++;
      label.setText("Number of clicks: " + count);
  }
  
  
  public static void main (String[] args)
  {
    new GUI();


  }


}
