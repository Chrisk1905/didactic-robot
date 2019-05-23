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
    Shape gp = new FibonacciSquare(450, 250, Color.BLUE, 3, 1);
    
    for(int i=0; i<10;i++) {
      gp.addLevel();
    }
    model.addShape(gp);
    
    //test removeLevel
//    gp.removeLevel();
//    System.out.println(Arrays.toString(dc5.getChildren()));
    
    //testing H createChildren
    Shape h1 = new HShape(100,100, Color.GREEN, 800);
    //model.addShape(h1);
    
    h1.addLevel();
    
    for(int i=0;i<7;i++) {
      h1.addLevel();
    }
   
    model.addShape(h1);
    
    //toString test 
    System.out.println(h1.toString());
    System.out.println(gp.toString());

    
    model.addView(panel);
  }
}
