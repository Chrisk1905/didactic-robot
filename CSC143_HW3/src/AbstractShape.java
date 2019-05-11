import java.awt.Color;

/**
 * the parent class of all shapes
 * Includes the fields: 
 * int x,y for (x,y) coordinates,
 * Color c for the color of the shape, and
 * int size used to calculate the height and width values of the instantiated shape.
 */
public abstract class AbstractShape implements Shape {
  
  int x, y;
  Color c;
  int size;
  
}
