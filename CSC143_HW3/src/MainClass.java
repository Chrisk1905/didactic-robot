import java.awt.Color;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      buildGUI();
    });
  }

  private static void buildGUI() {
    JFrame frame = new JFrame();
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Viewer panel = new Viewer();
    frame.add(panel);

    frame.setVisible(true);

    DrawingModel model = new DrawingModel();
    //add level test
    //grandpa
    Shape gp = new FibonacciSquare(350, 250, Color.BLUE, 3, 1);
    
    gp.addLevel();
    
    //the first deep child dc 
    Shape dc = gp.getChildren()[0];
    gp.addLevel();
    Shape dc2 = dc.getChildren()[0];
    gp.addLevel();
    Shape dc3 = dc2.getChildren()[0];
    gp.addLevel();
    Shape dc4 = dc3.getChildren()[0];
    gp.addLevel();
    Shape dc5 = dc4.getChildren()[0];
    
    
    gp.addLevel();
    Shape dc6 = dc5.getChildren()[0];
    
    System.out.println( dc4.toString() );
    System.out.println( dc6.toString() );
    
    //draw method test
    for(int i = 0; i<10;i++) {
      gp.addLevel();
    }
    model.addShape(gp);
    
    //test removeLevel
    gp.removeLevel();
    System.out.println(Arrays.toString(dc5.getChildren()));
    
    //testing H createChildren
    Shape h1 = new HShape(100,100, Color.GREEN, 800);
    //model.addShape(h1);
    
    h1.addLevel();
    Shape[] gen1 = h1.getChildren(); 
    
    for(int i=0;i<7;i++) {
      h1.addLevel();
    }
   
    model.addShape(h1);
    
    //toString test 
    System.out.println(gen1[0].toString());
    System.out.println(gen1[3].getChildren()[5].toString());
    for(int i = 0; i<7; i++) {
      System.out.println(Arrays.toString(gen1[i].getChildren()));
    }

    
    model.addView(panel);
  }
}
