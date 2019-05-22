import java.awt.Color;

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
    Shape s2 = new FibonacciSquare(350, 250, Color.BLUE, 3, 3);
    model.addShape(s2);
    
    s2.createChildren();
    s2.getChildren()[0].createChildren();
    s2.getChildren()[0].getChildren()[0].createChildren();
    model.addShape(s2.getChildren()[0]);
    model.addShape(s2.getChildren()[0].getChildren()[0]);
    model.addShape(s2.getChildren()[0].getChildren()[0].getChildren()[0]);
    
    //the first deep child dc the first
    Shape dc = s2.getChildren()[0].getChildren()[0].getChildren()[0];
    dc.createChildren();
    Shape dc2 = dc.getChildren()[0];
    dc2.createChildren();
    Shape dc3 = dc2.getChildren()[0];
    dc3.createChildren();
    Shape dc4 = dc3.getChildren()[0];
    dc4.createChildren();
    Shape dc5 = dc4.getChildren()[0];
    
    model.addShape(dc2);
    model.addShape(dc3);
    model.addShape(dc4);
    model.addShape(dc5);
    
    //Shape addLevel() test
    dc5.addLevel();
    Shape dc6 = dc5.getChildren()[0];
    model.addShape(dc6);
    
    model.addView(panel);
  }
}
