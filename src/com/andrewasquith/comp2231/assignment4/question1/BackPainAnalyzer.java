/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 4
 * Question 1 - BackPainAnalyzer
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
 * BackPainAnaylyzer demonstrates the use of a binary decision tree to 
 * diagnose back pain.
 */
public class BackPainAnalyzer
{
    /**
     *  Asks questions of the user to diagnose a medical problem.
     */
    public static void main (String[] args) throws FileNotFoundException
    {
        System.out.println ("So, you're having back pain.");

        DecisionTree expert = new DecisionTree("backpain-input.txt");
        expert.evaluate();
    }
}
