import processing.core.PApplet;

///////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: KaleidoscopePen class creates Triangle pens that draws several Triangles
// Files: Point Class, PApplet, TriangleClass, TrianglePen class
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
// Persons: CS LEARNING CENTER TUTOR helped me with the Update() method
// at the end, I was able to make my points stay after pressing the mouse.
// The tutor told me that new TrianglePens should be created in the constructor
// not in the Update() method.
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * * creates KaleidoscopePen Objects * @author Karen Zhou
 */
public class KaleidoscopePen {
  private static PApplet processing;
  private int numberOfTrianglePens;
  private TrianglePen[] PensList;

  /** * KaleidoscopePen Constructor; it creates a KaleidoscopePen object */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {
    this.processing = drawTo;
    this.numberOfTrianglePens = numberOfTrianglePens;
    PensList = new TrianglePen[numberOfTrianglePens];
    for (int i = 0; i < numberOfTrianglePens; i++) {
      if (i == 0) {
        PensList[i] = new TrianglePen(this.processing, true);

      } else {
        PensList[i] = new TrianglePen(this.processing, false);
      }
    }

  }

  /**
   * * Updates KaleidoscopePen objects * @param mouseX position of the pens * @param mouseY position
   * of the pens * @param whether the mouse is pressed * @param key that is pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    for (int i = 0; i < numberOfTrianglePens; i++) {
      int rposition[] = rotate(mouseX, mouseY, (i * (2 * Math.PI) / numberOfTrianglePens));
      PensList[i].update(rposition[0], rposition[1], mousePressed, keyPressed);


    }
  }

  /**
   * * Rotates a position around the center of an 800x600 screen by the specified * amount, and then
   * returns an array containing the resulting position. * @param x position of the point to be
   * rotated (0 to 800 pixels) * @param y position of the point to be rotated (0 to 600 pixels)
   * * @param angle amount of rotation to apply (angle in radians units: 0 to 2*PI) * @return the
   * rotated position array: x @ index 0, y @ index 1
   */
  private static int[] rotate(int x, int y, double angle) {
    x -= 400; // translate center of screen to origin (0,0)
    y -= 300;
    int[] rotatedPosition = new int[] { // rotate around origin
        (int) (x * Math.cos(angle) - y * Math.sin(angle)),
        (int) (x * Math.sin(angle) + y * Math.cos(angle))};
    rotatedPosition[0] += 400; // return to center of screen
    rotatedPosition[1] += 300;
    return rotatedPosition;
  }

}


