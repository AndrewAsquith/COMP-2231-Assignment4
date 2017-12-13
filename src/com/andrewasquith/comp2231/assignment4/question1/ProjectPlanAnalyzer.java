/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 4
 * Question 1 - ProjectPlanAnalyzer
 * Implementation completed through methods which 
 * were required in jsjf.LinkedBinaryTree
 */
package com.andrewasquith.comp2231.assignment4.question1;

/**
 * Import the io package for reading the input file
 */
import java.io.*;

/**
 * Import the decision tree implementation from jsjf
 */
import jsjf.DecisionTree;

/**
 * ProjectPlanAnalyzer demonstrates the use of a binary decision tree to 
 * determine the feasibility of a project.
 */
public class ProjectPlanAnalyzer
{
    /**
     *  Asks questions of the user to determine if the project can be run.
     */
    public static void main (String[] args) throws FileNotFoundException
    {
        System.out.println ("So, you have an idea for a project.");

        DecisionTree expert = new DecisionTree("projectplan-input.txt");
        expert.evaluate();
    }
}
