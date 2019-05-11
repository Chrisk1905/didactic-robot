import java.awt.Color;
import java.awt.Graphics;

/**
 * FibonacciSquare, with the (x,y) being the upper-left corner.
 * The size of the square is the nth term of the Fibonacci sequence. 
 * Size does not use scaling.  
 */
public class FibonacciSquare extends AbstractShape {

  int quadrant;
  int n;
  /**
   * 
   * @param x coordinate upper-left corner of the square
   * @param y coordinate upper-left corner of the square
   * @param color of the shape 
   * @param quadrant of the square. Affects how the arc is drawn.  
   * @param n The size of the box will be the nth Fibonacci term
   *  
   */
  public FibonacciSquare(int x, int y, Color c, int quadrant, int n) {
    this.x = x;
    this.y = y;
    this.c = c;
    this.quadrant = quadrant;
    this.n = n;
    this.size = FibonacciNumber(n);
  }
  
  //xₐ = (φⁿ - ψⁿ) / √5
  public static int FibonacciNumber(int n) {
    int n1 = 0;
    int n2 = 1;
    int n3;
    for (int i = 0; i < n; i++) {
      n3 = n1 + n2;
      n1 = n2;
      n2 = n3;
    }
    return n = n1;
  }
  @Override
  public void draw(Graphics g) {
    // draw a square
    g.setColor(c);
    g.drawRect(x, y, size, size);
    switch (quadrant) {
    case 1:
      g.drawArc(x-size, y, size*2, size*2, 0, 90);
      break;
    case 2:
      g.drawArc(x, y, size*2, size*2, 90, 90);
      break;
    case 3:
      g.drawArc(x, y-size, size*2, size*2, 180, 90);
      break;
    case 4:
      g.drawArc(x-size, y-size, size*2, size*2, 270, 90);
      break;
      
    }
  }
  
  public Shape deepCopy() {
    int x = this.x;
    int y = this.y;
    Color c = this.c;
    int quadrant = this.quadrant;
    int n = this.n;
    return new FibonacciSquare(x, y, c, quadrant, n);
  }
  
  @Override
  public boolean equals(Object o) {
    if(o!=null&&o.getClass()==this.getClass()) {
      FibonacciSquare f = (FibonacciSquare)o;
      if(this.c == f.c && this.x == f.x && this.y == f.y 
          && this.quadrant == f.quadrant && this.n == f.n) {
        return true;
      }
    }
    return false;
   }
  
  @Override
  public String toString() {
    return ("Fib square: {" + "x: " + this.x + ", y: " + this.y + ", color: " + this.c.toString()
      + ", quadrant: " + this.quadrant + ", n: " + this.n +"}");
  }
  
  
  //
}