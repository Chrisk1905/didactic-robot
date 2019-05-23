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
    model.addShape(gp);
    
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
    
    model.addShape(dc);
    model.addShape(dc2);
    model.addShape(dc3);
    model.addShape(dc4);
    model.addShape(dc5);
    
    gp.addLevel();
    Shape dc6 = dc5.getChildren()[0];
    model.addShape(dc6);
    
    System.out.println( dc4.toString() );
    System.out.println( dc6.toString() );
    
    //test removeLevel
    gp.removeLevel();
    System.out.println(Arrays.toString(dc5.getChildren()));
    
    //testing H createChildren
    Shape h1 = new HShape(500,200, Color.GREEN, 400);
    //model.addShape(h1);
    
    h1.addLevel();
    Shape[] gen1 = h1.getChildren(); 
    h1.addLevel();
    for(int i = 0; i<7; i++) {
      System.out.println(Arrays.toString(gen1[i].getChildren()));
    }
    
    for(Shape s: gen1) {
      for(Shape ss: s.getChildren()) {
        model.addShape(ss);
      }
    }
    
    model.addView(panel);
  }
}
