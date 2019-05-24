/**
 * This is the model that holds the state of the drawing, and will probably be the most complex class.  
 * It should maintain a collection of Shapes. The model should look at all of the shapes as having just a Shape type. 
 * It should not have to distinguish between Triangles and Squares (and other types of shapes if you have them). 
 * When requested by a view, the model should make a deep copy of the collection of its shapes 
 * ( use the deep copy method of the Shape interface implemented in the Triangle and Square classes). 
 * Other behaviors it should support are
 * A client should be able to add a Shape to the model
 *A viewer should be able to register with the model
 * It should notify all viewers when something in the model changes.  (For now, the only changes will be when a new shape is added to the drawing.)
 *
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class DrawingModel {
  // the list of shapes
  private List<Shape> shapes = new ArrayList<Shape>();
  // the list of the views connected to this model
  private List<View> views = new ArrayList<View>();

  private JFrame frame;
  // A client should be able to add a Shape to the model
  public void addShape(Shape s) {
    shapes.add(s);
    updateAll();
  }

  // A viewer should be able to register with the model
  public void addView(View v) {
    views.add(v);
    v.update(this);
  }
  
  public void setFrame(JFrame f) {
    if(frame ==null) {
      frame = f;
    }else {
      System.out.println("Frame is already set");
    }
  }

  /** Updates all views in model
   *  It should notify all viewers when something in the model changes.
   */
  public void updateAll() {
    for (View v : views) {
      v.update(this);
    }
  }

  public List<Shape> getShapes() {
    return shapes;
  }

  public boolean addLevel(int x, int y) {
    boolean b = true;
    for(Shape s : shapes) {
      // if (x,y) is within s, add a level to s
      if (s.contains(x,y)) {
        b = s.addLevel();
        if (b) {
          //fibonacci square DYNAMIC SIZE BOUNDARY CHECK
          //get frame boundary
          //check if frame boundaries meet size requirements of added 
          //fib box and update
          if(s.getClass() == new FibonacciSquare(1,1,Color.BLACK,1,1).getClass()) {
            int frameX = frame.getWidth();
            int frameY = frame.getHeight();
            FibonacciSquare castedFib = (FibonacciSquare)s;
            int[] fibBoundary = castedFib.getBoundary();
            //if the frame size is too small for the fibSquare
            if(frameX<fibBoundary[1] || frameY<fibBoundary[3]) {
              s.removeLevel();
              return false;
            }
          }
          updateAll();
        }
      }
    }
    return b;
  }

  public boolean removeLevel(int x, int y) {
    boolean b = true;
    for(Shape s : shapes) {
      // if (x,y) is within s, remove a level from s
      if (s.contains(x,y)) {
        b = s.removeLevel();
        if (b) {
          updateAll();
        }
      }
    }
    return b;
  }
  
  public void reset() {
    for(Shape s:shapes) {
      int level = s.getLevel();
      for(int i=0; i<level; i++) {
        s.removeLevel();
      }
      
    }
    updateAll();
    
  }
}