import java.awt.Color;

/**
 * the parent class of all shapes
 * Includes the fields: 
 * int x,y for (x,y) coordinates,
 * Color c for the color of the shape, and
 * int size used to calculate the height and width values of the instantiated shape.
 */
public abstract class AbstractShape implements Shape {
  //geometric properties
  int x, y;
  Color c;
  int size;
  //an array of children shapes a level below the parent shape
  protected Shape[] children;
  
  /**
   * add a level of children shapes 
   * @return
   */
  public boolean addLevel() {
    if(children[0]==null) {
      for(Shape s:children) {
        s.addLevel();
      }
    }else {
      return createChildren();
    }
    return true;
  }
  public boolean removeLevel() {
    //last level of children are deleted 
    return false;
  }
  
}
