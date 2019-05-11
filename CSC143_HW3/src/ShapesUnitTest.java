import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Test;

import java.util.List;

public class ShapesUnitTest {
  
  @Test
  public void HShapeTest() {
    //deep copy test
    Shape h = new HShape(9000, 9001, Color.BLACK, 100);
    Shape copy = h.deepCopy();
    
    assertFalse(h==copy);
    assertTrue(copy.equals(h));
  }
  
  @Test
  public void fibonacciSquareTest() {
    Shape fib = new FibonacciSquare(600, 300, Color.CYAN, 3, 7);
    
    //deepcopy test
    assertFalse(fib.equals(null));
    assertTrue(fib.equals(fib.deepCopy()));
    assertFalse(fib == fib.deepCopy());
    
    //FibonacciNumber test
    
    assertTrue(FibonacciSquare.FibonacciNumber(3)==2);
    assertTrue(FibonacciSquare.FibonacciNumber(12)==144);
    assertTrue(FibonacciSquare.FibonacciNumber(20)==6765);
  }
  
  
  @Test
  public void modelTest() {
    
    
    Shape fib = new FibonacciSquare(0, 250, Color.RED, 4, 5);
    Shape fib2 = new FibonacciSquare(200,200, Color.GREEN, 2, 10); 
    Shape h = new HShape(100,100, Color.BLUE, 200);
    
    DrawingModel model = new DrawingModel();
    model.addShape(fib);
    model.addShape(fib2);
    model.addShape(h);
    
    List<Shape> modelCopy = model.getShapes();
    
    //addShape test
    assertTrue(modelCopy.size()==3);

    //deepcopy test
    //System.out.println(+modelCopy.get(0).toString());
    //System.out.println(modelCopy.get(1).toString());
    assertFalse(modelCopy.get(0)==fib);
    assertTrue(modelCopy.get(0).equals(fib));
    assertFalse(modelCopy.get(1)==fib2);
    assertTrue(modelCopy.get(1).equals(fib2));
    assertFalse(modelCopy.get(2)==h);
    assertTrue(modelCopy.get(2).equals(h));
    
  }
  
}
