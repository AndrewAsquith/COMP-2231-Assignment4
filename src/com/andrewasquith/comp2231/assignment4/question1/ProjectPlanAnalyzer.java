package com.andrewasquith.comp2231.assignment4.question1;

import java.io.*;

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
