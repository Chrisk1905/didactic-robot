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
    frame.setSize(800, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Viewer panel = new Viewer();
    frame.add(panel);

    frame.setVisible(true);

    DrawingModel model = new DrawingModel();
    Shape s1 = new FibonacciSquare(0, 50, Color.RED, 1, 14);
    Shape s2 = new FibonacciSquare(250, 50, Color.BLUE, 2, 11);
    Shape s3 = new FibonacciSquare(550, 50, Color.GREEN, 3, 10);
    Shape s4 = new FibonacciSquare(650, 150, Color.YELLOW, 4, 9);
    model.addShape(s1);
    model.addShape(s2);
    model.addShape(s3);
    model.addShape(s4);
    Shape s5 = new HShape(400, 200, Color.GREEN, 200);
    Shape s6 = new HShape(600, 300, Color.BLUE, 100);
    model.addShape(s5);
    model.addShape(s6);
    model.addView(panel);
  }
}
