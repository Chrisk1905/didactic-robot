import java.awt.Color;

/**
 * the parent class of all shapes
 * Includes the fields: 
 * int x,y for (x,y) coordinates,
 * Color c for the color of the shape, and
 * int size used to calculate the height and width values of the instantiated shape.
 * Shape[] children to store a level of child shapes.
 */
public abstract class AbstractShape implements Shape {
  //geometric properties
  int x, y;
  Color c;
  int size;
  //an array of children shapes a level below the parent shape
  protected Shape[] children;
  //generation of shape. 1 by default
  int gen;

  public AbstractShape(int x, int y, Color c, int size) {
    this.x = x;
    this.y = y;
    this.c = c;
    this.size = size;
  }

  /**
   * add a level of children shapes 
   * @return
   */
  public boolean addLevel() {
    boolean b = false;
    if (children[0] == null) {
      b = createChildren();
      return b;
    } else {
      for (Shape s:children) {
        b = s.addLevel();
      }
    }
    return b;
  }
  
  public boolean removeLevel() {
    boolean b = false;
    if(this.gen==1 && children[0]==null) {
      //cannot remove level when there is only 1 level
      return b;
    }else if(children[0].getChildren()[0]==null){
      //if the children array of the index 0 child in this object's children array is null 
      for(int i = 0; i<children.length;i++) {
        children[i]=null;
      }
      b = true;
      return b;
    }else {
      //go a level deeper deeper
      for(Shape s:children) {
        b = s.removeLevel();
      }
    }
    return b;
  }

  public int getLevel() {
    if(children[0]==null) {
      return 1;
    }else {
      return children[0].getLevel() + 1;
    }
  }

  public Shape[] getChildren() {
    return children;
  }


  public String toString() {
    return ("[" + this.getClass() + ", x: " + this.x + ", y: " + this.y
        + ", color: " + this.c.toString() + ", level: " + getLevel() + "];");
  }

}
