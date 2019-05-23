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
import java.util.ArrayList;
import java.util.List;

public class DrawingModel {
  private List<Shape> shapes = new ArrayList<Shape>();
  private List<View> views = new ArrayList<View>();

  public void addView(View v) {
    views.add(v);
    v.update(this);
  }

  public void updateAll() {
    for (View v : views) {
      v.update(this);
    }
  }

  public void addShape(Shape s) {
    shapes.add(s);
    updateAll();
  }
  
  /**
   * @return a deep copy of all shapes in the model
   */
  public List<Shape> getShapes() {
    return shapes;
  }
}