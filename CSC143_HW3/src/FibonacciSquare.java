import java.awt.Color;
import java.awt.Graphics;

/**
 * FibonacciSquare, with the (x,y) being the upper-left corner.
 * The size of the square is the nth term of the Fibonacci sequence. 
 * size uses a scaling of 5 
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
    super(x,y,c,FibonacciNumber(n));
    this.quadrant = quadrant;
    this.n = n;
    children = new Shape[1];
    this.level=1;
  }
  
  /**
   * 
   * @param n as in the nth Fibonacci term
   * @return the nth Fibonacci term scaled by 5. 
   */
  
  public static int FibonacciNumber(int n) {
    int n1 = 0;
    int n2 = 1;
    int n3;
    for (int i = 0; i < n; i++) {
      n3 = n1 + n2;
      n1 = n2;
      n2 = n3;
    }
    n = n1;
    //scaling: n * scale
    return n*10;
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
  //createChildren(),getChildren()
  public boolean createChildren() {
    int childQ = (this.quadrant+1)%5;
    if(childQ == 0) {
      childQ=1;
    }
    int childX=this.x;
    int childY=this.y;
    int childSize=FibonacciNumber(this.n+1);
    
    switch(childQ) {
    case 1:
      //"center" the X 
      childX-=(childSize-this.size);
      childY-=childSize;
      break;
    case 2:
      childX-=childSize;
      break;
    case 3:
      childY+=this.size;
      break;
    case 4:
      childX+=this.size;
      //"center" the Y
      childY-=(childSize-this.size);
      break;
    }
    
    children[0] = new FibonacciSquare(childX, childY, this.c, childQ,this.n+1);
    FibonacciSquare child = (FibonacciSquare) children[0];
    child.level+=this.level;
    return true;
  }
  
  public Shape[] getChildren() {
    return children;
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
  public boolean contains(int x, int y) {
    // TODO Auto-generated method stub
    return false;
  }
  
//  @Override
//  public String toString() {
//    return ("Fib square: {" + "x: " + this.x + ", y: " + this.y + ", color: " + this.c.toString()
//      + ", quadrant: " + this.quadrant + ", n: " + this.n +"}");
//  }
  
  
  //
}