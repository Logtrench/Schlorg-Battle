import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Schlorganrt");
    frame.setSize(300, 300);
    frame.setLocation(100, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


String bitte = "bitteschön und dankeschön";
    JLabel label = new JLabel(bitte,SwingConstants.CENTER);
    frame.add(label);

    frame.show();
    
    System.out.println(bitte);
  }
}

/*
manifesto
sitrng bitte = please / your're welcome
scheisse du mensch du
dankeschön = thankyou very much
bitteschön = bitte very much
moutarde = mustard indeed

*/