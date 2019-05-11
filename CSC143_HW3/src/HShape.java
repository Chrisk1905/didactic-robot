import java.awt.Color;
import java.awt.Graphics;


/**
 * H shape
 */
public class HShape extends AbstractShape {

  /**
   * 
   * @param x x coordinate of top left corner 
   * @param y y coordinate of top left corner
   * @param c the color of the H
   * @param size the length and height of the square containing the H
   */
  public HShape(int x, int y, Color c, int size) {
    this.x = x;
    this.y = y;
    this.c = c;
    this.size = size;
  }

  @Override
  public void draw(Graphics g) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if ((i == 1 & j == 0) || i == 1 & j == 2) {
        } else {
          g.setColor(c);
          g.drawRect(x+(i*(size/3)), y+(j*(size/3)), size/3, size/3);
          g.fillRect(x+(i*(size/3)), y+(j*(size/3)), size/3, size/3); 
        }
      }
    }
  }
  
  public Shape deepCopy() {
    int x = this.x;
    int y = this.y;
    Color c = this.c;
    int size = this.size;
    return new HShape(x, y, c, size);
  }
  
  @Override
  public boolean equals(Object o) {
    if(o!=null&&o.getClass()==this.getClass()) {
      HShape h = (HShape)o;
      if(this.c == h.c && this.x == h.x && this.y == h.y 
          && this.size == h.size) {
        return true;
      }
    }
    return false;
   }
}