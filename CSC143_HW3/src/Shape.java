
import java.awt.Graphics;

/**
 * Interface Shape. The minimal interface of a shape.  
 * Includes draw() method for drawing the shape
 * and a deepCopy() method to return a deep copy of the shape.
 */
public interface Shape {
  /**
   * draw the shape onto the view
   * @param g Graphics object to be drawn
   */
  void draw(Graphics g);
  /**
   * returns a deep copy of the shape
   */
  Shape deepCopy();
  
  /**
   * initializes the children array
   * 
   */
  boolean createChildren();
  /**
   * adds a level of children to the bottom level 
   */
  boolean addLevel();
  /**
   * removes a level of children to the bottom level
   */
  boolean removeLevel();
  
  Shape[] getChildren();

}
