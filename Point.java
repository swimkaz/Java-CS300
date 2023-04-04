import processing.core.PApplet;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Point class that creates Point objects, which can be used by the TrianglePen
// class
// Files: PApplet
// Course: CS 300 Fall 2019
//
// Author: Karen Zhou
// Email: kmzhou2@wisc.edu
// Lecturer's Name: Professor Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: NONE
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * * creates Points Objects * @author Karen Zhou
 */
public class Point {
  int PositionX;
  int PositionY;
  private static final int POINT_DIAMETER = 8;
  PApplet processing;

  /**
   * * creates Triangle Objects * @param mouseX of point to be created * @param mouseY of point to
   * be created
   */
  public Point(int X, int Y) {
    PositionX = X;
    PositionY = Y;
  }

  /**
   * * gets the PositionX of the point * @return mouseX of the point
   */
  public int getX() {
    return PositionX;
  }

  /**
   * * gets the PositionY of the point * @return mouseY of the point
   */
  public int getY() {
    return PositionY;
  }

  /**
   * * sets the PositionX and PositionY of the point * @param changed mouseX of point * @param
   * changed mouseY of point
   */
  public void setPosition(int mousex, int mousey) {
    PositionX = mousex;
    PositionY = mousey;
  }

  /**
   * * draws the point * @param PApplet processing
   */
  public void draw(PApplet drawTo) {
    processing = drawTo;
    processing.fill(-1);
    processing.circle(getX(), getY(), POINT_DIAMETER);
  }

  /**
   * *check if a position is within the circle * @param mouseX position that is checked * @param
   * mouseY position that is checked
   */
  public boolean isOver(int x, int y) {
    int point1Y = y;
    int point1X = x;
    int point2Y = PositionY;
    int point2X = PositionX;
    int radius = POINT_DIAMETER / 2;
    int a = ((point1X - point2X) * (point1X - point2X));
    int b = ((point1Y - point2Y) * (point1Y - point2Y));
    double c = (double) a + b;
    int distance = (int) Math.sqrt(c);
    if (distance < radius) {
      return true;
    } else
      return false;
  }


}
