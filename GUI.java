import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.*;

public class GUI implements ActionListener
{
    private static JLabel success;
    private static JTextField userText;
    private static JTextField passwordText;
    private static ImageIcon icon;
    private static JLabel label;
    
    public static void main(String[] args)
    {
        /*JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);*/
        JPanel panel = new JPanel();
        panel = panel(500, 500);
        

        icon = new ImageIcon("images/bear.png");
        image(panel, icon, 10, 120, 250, 250);
        

        //label = new JLabel(icon);
        //label.setBounds(10, 120, 80, 25);
        //panel.add(label);

        panel.setLayout(null);
        
        labl(panel, "User",10,20, 80, 25);
        userText = text(panel,100,20,165,25);
        
        labl(panel, "Password",10,50,80,25);
        passwordText = text(panel,100,50,165,25);
        
        JButton button1 = new JButton();
        button1 = butt(panel, "log in", 10,80,80,25);
        button1.setVisible(true);
        button1.addActionListener(new GUI());
        success = new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);
                       
    }
    
    public static JPanel panel(int x, int y)
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        return panel;
    }

    public static void labl(JPanel panel, String message, int x, int y, int zx, int zy)
    {
        JLabel label = new JLabel(message);
        label.setBounds(x, y, zx, zy);
        panel.add(label);
    }

    public static void image(JPanel panel, ImageIcon icon, int x, int y, int zx, int zy)
    {
        JLabel label = new JLabel(icon);
        label.setBounds(x, y, zx, zy);
        panel.add(label);
    }
    
    public static JTextField text(JPanel panel, int x, int y, int zx, int zy)
    {
        JTextField userText = new JTextField(20);
        userText.setBounds(x,y,zx,zy);
        panel.add(userText);
        return userText;
    }
    
    public static JButton butt(JPanel panel, String message, int x, int y, int zx, int zy)
    {
        JButton button = new JButton(message);
        button.setBounds(x,y,zx,zy);
        panel.add(button);
        return button;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String buttonName = e.getActionCommand();
        if (buttonName.equals("join"))
        {
          System.out.println("JOINING");
        }
        else if (buttonName.equals("exit"))
        {
          Main.exit();
          System.exit(0);
        }
        else
        {
          System.out.println("AHHH");
        }
    }
}








/*

public class GUI implements ActionListener{
  private int count = 0;
  private JFrame frame;
  private JPanel panel;
  private JLabel label;
  private JLabel label2;
  private ImageIcon icon;
  

//trying gui with image
  public GUI(String image, String message, String title) 
  {
   //creating new objects of type frame and panel and button
    frame = new JFrame();
    icon = new ImageIcon(image);
    label = new JLabel(icon);
    label2 = new JLabel(message);


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
    frame.setTitle(title);

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
    new GUI("majestic_bear.jpg","hello there matey", "test");


  }


}
*/