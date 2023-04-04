import processing.core.PApplet;

////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           Triangle class that creates Triangle objects, which can be used by the 
//                 TrianglePen Class
//Files:           PApplet
//Course:          CS 300 Fall 2019
//
//Author:          Karen Zhou
//Email:           kmzhou2@wisc.edu
//Lecturer's Name: Professor Gary Dahl
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    NONE
//Partner Email:   NONE
//Partner Lecturer's Name: NONE
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//___ Write-up states that pair programming is allowed for this assignment.
//___ We have both read and understand the course Pair Programming Policy.
//___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
//Persons:         NONE
//Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**  * creates Triangle Objects
 * * @author Karen Zhou
 * */
public class Triangle {
  
  private Point position1;
  private Point position2;
  private Point position3;
  private int colorIndex;
  PApplet processing;
  
  private static final int[] COLORS = new int[] { // int packed w/8 bits of ARGB
      //  WHITE, RED,     ORANGE,  YELLOW,  GREEN,     BLUE,      INDIGO,   VIOLET     
      -1,    -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476 };
  
  /**  * Triangle Constructor; it creates a Triangle object
   *  * * @param Point 1 object of triangle
   *  * * @param Point 2 object of triangle
   *  * * @param Point 3 object of triangle*/
  public Triangle (Point p1, Point p2, Point p3, int colorIndex)
  {
    position1 = p1;
    position2 = p2;
    position3 = p3;
    this.colorIndex = colorIndex;
  }
  
  /**  * sets the color of Triangle Object
   * * @param index of color array */
  public void setColor(int colorIndex)
  {
    this.colorIndex = colorIndex;
  }
  
  /**  * draws the Triangle Object
   * * @param PApplet processing*/
  public void draw(PApplet drawTo) // draw a triangle at this points position 
  {
    processing= drawTo;
    processing.fill(COLORS[colorIndex]);
    int oneX = position1.getX();
    int oneY = position1.getY();
    int twoX = position2.getX();
    int twoY = position2.getY();
    int threeX = position3.getX();
    int threeY = position3.getY();
    processing.triangle(oneX, oneY, twoX, twoY, threeX, threeY);
  }
  /**  * checks whether a point is in the triangle
   * * @param mouseX position that is checked
   * * @param mouseY position that is checked
   * * @param mouseX position of first point of triangle
   * * @param mouseY position of first point of triangle
   * * @param mouseX position of second point of triangle
   * * @param mouseY position of second point of triangle
   * * @param mouseX position of third point of triangle
   * * @param mouseY position of third point of triangle
   * * @return true or false
   */
  private static boolean isPointInTriangle(int px, int py, int t1x, int t1y, int t2x, int t2y,
      int t3x, int t3y) 
  {   px -= t1x; // don't worry about this arithmetic   
      py -= t1y;   
      t2x -= t1x;   
      t2y -= t1y;   
      t3x -= t1x;   
      t3y -= t1y;   
      double dotp2 = px*t2x+py*t2y;   
      double dotp3 = px*t3x+py*t3y;   
      double dot22 = t2x*t2x+t2y*t2y;   
      double dot23 = t2x*t3x+t2y*t3y;   
      double dot33 = t3x*t3x+t3y*t3y;   
      double invDen = 1 / (dot33 * dot22 - dot23 * dot23);   
      double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;   
      double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;   
      return (a >= 0) && (b >= 0) && (a + b < 1);     
  }
  /**  *  returns true when the position x,  y
  // is within the triangle drawn to visualize this point, otherwise returns false 
   * * @param x position of the mouse to be checked if within triangle
   * * @param y position of the mouse to be checked if within triangle 
   * * @return true or false  */ 
  public boolean isOver(int x, int y) // returns true when the position x,  y
  // is within the triangle drawn to visualize this point, otherwise returns false 
  
  {
    int oneX = position1.getX();
    int oneY = position1.getY();
    int twoX = position2.getX();
    int twoY = position2.getY();
    int threeX = position3.getX();
    int threeY = position3.getY();
    
      if (isPointInTriangle(x, y,oneX, oneY, twoX, twoY, threeX, threeY))
      {
        return true;
      }
      else
        return false;
  }
  
}
