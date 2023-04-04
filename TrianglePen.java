import java.util.ArrayList;
import processing.core.PApplet;

///////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: TrianglePen creates pens that draws Triangles
// Files: Point Class, PApplet, TriangleClass
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
// Persons: CS LEARNING CENTER TUTOR helped me with the HandleMouseDrag() method
// and allowed me to be able to drag a point and change the triangle
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * * creates TrianglePen Objects * @author Karen Zhou
 */
public class TrianglePen {
  ArrayList<Point> PointList;
  ArrayList<Triangle> TriangleList;
  private PApplet processing;
  private boolean showPoints;
  private Point drag;

  /**
   * * creates a TrianglePen object * @param PApplet processing * @param whether points are shown
   */
  public TrianglePen(PApplet processing, boolean showPoints) {
    PointList = new ArrayList<Point>();
    TriangleList = new ArrayList<Triangle>();
    this.processing = processing;
    this.showPoints = showPoints;
  }

  private boolean mouseWasPressed = false; // mousePressed from previous update() call
  private char keyWasPressed = '0'; // keyPressed from previous update() call

  /**
   * * Updates TrianglePen objects * @param mouseX position of the pens * @param mouseY position of
   * the pens * @param whether the mouse is pressed * @param key that is pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    if (mousePressed != mouseWasPressed) {
      if (mousePressed)
        handleMousePress(mouseX, mouseY);
      else
        handleMouseRelease(mouseX, mouseY);
    }
    if (mousePressed)
      handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;
    
    // process keyboard-based user input
    if (keyPressed != keyWasPressed)
      handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;

    // draw everything in its current state
    draw();
  }


  // process mouse-based user input

  /**
   * * handles pressing of the mouse: adds points or begins mouse drag * @param mouseX position
   * * @param mouseY position
   */
  private void handleMousePress(int mousex, int mousey) {
    int ans = 0;
    if (PointList.size() == 0) {
      Point p = new Point(mousex, mousey);
      PointList.add(p);
    } else {
      for (int i = 0; i < PointList.size(); i++) {

        if (PointList.get(i).isOver(mousex, mousey)) {
          ans = ans + 1;
          drag = PointList.get(i);
          handleMouseDrag(processing.mouseX, processing.mouseY);
        }
      }
      if (ans == 0) {
        Point p = new Point(mousex, mousey);
        PointList.add(p);
        if (PointList.size() % 3 == 0 && PointList.size() >= 3) {
          Triangle t = new Triangle(PointList.get(PointList.size() - 3),
              PointList.get(PointList.size() - 2), PointList.get(PointList.size() - 1), 0);
          TriangleList.add(t);
        }
      }
    }

  }

  /**
   * * handles dragging of the mouse: sets drag to null * @param mouseX position * @param mouseY
   * position
   */
  private void handleMouseRelease(int mousex, int mousey) {
    if (drag != null) {
      for (int i = 0; i < PointList.size(); i++) {
        int xp = PointList.get(i).getX();
        int yp = PointList.get(i).getY();
        if (xp == drag.getX() && yp == drag.getY()) {
          PointList.get(i).setPosition(mousex, mousey);
        }
      }
      drag = null;

    }
  }

  /**
   * * handles dragging of the mouse: continuously sets a new position for the dragged point
   * * @param mouseX position * @param mouseY position
   */
  private void handleMouseDrag(int mousex, int mousey) {
    if (drag != null) {
      for (int i = 0; i < PointList.size(); i++) {
        int xp = PointList.get(i).getX();
        int yp = PointList.get(i).getY();
        if (xp == drag.getX() && yp == drag.getY()) {
          PointList.get(i).setPosition(mousex, mousey);
          drag.setPosition(mousex, mousey);
        }
        draw();
      }
    }
  }

  /**
   * * handles pressing of a key: changes the color of the triangle the mouse is over * @param
   * mouseX position * @param mouseY position * @param key, between 0 and 7, that is pressed, which
   * is the index of the color array
   */
  private void handleKeyPress(int mousex, int mousey, char keyPressed) {

    for (int i = 0; i < TriangleList.size(); i++) {
      if (TriangleList.get(i).isOver(mousex, mousey) && keyPressed <= '7' && keyPressed >= '1') {
        int color = keyPressed - '0';
        TriangleList.get(i).setColor(color);
      }
    }
  }

  /**
   * * draws the points and triangles from those points
   */
  private void draw() {
    for (int i = 0; i < TriangleList.size(); i++) {
      TriangleList.get(i).draw(processing);
    }
    if (showPoints)
    for (int i = 0; i < PointList.size(); i++) {
      PointList.get(i).draw(processing);
    }

  }



}
