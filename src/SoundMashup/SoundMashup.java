//package com.company;

/*
Mizuki Hashimoto
02/11/2019

Write a program to load n sound clips into an array and then randomly generate a mashup of these clips 
for a total of t seconds (input) by choosing clips from the array. After loading the n unique sound clips, 
you randomly play a sound clip and pause between the playing of each clip of 250 milliseconds 
for an audible transitional sense until you have played at least t*1000 milliseconds.
*/ 

import java.util.Scanner;

public class SoundMashup {
  public static void main (String [] args) {
        int nFiles; // Number of the sound files
        Sound [] sounds = null; // Array holds sound files

        Scanner sc = new Scanner (System.in);
        System.out.println ("Enter the number of sound files: ");

        nFiles = sc.nextInt (); // Input the number of sound files
        sounds = new Sound[nFiles]; // Instanciation

        for( int i=0; i<nFiles; i++){
            String fileName = FileChooser.pickAFile(); // Choose the sound files to play
            sounds[i] = new Sound(fileName); // Put chosen sound files into an array
        }
        
        System.out.println ("How many seconds do you want to listen the sound file?: ");
        double t = sc.nextDouble() * 1000; // Convert seconds to milliseconds
        
        while (t > 0) {
            int c = (int)(Math.random()*nFiles);
            System.out.println ("Time remaining is " + t + "."); // Show the time remaining
            System.out.println ("File playing is '" + sounds[c].getFileName() + "."); // Show which file now playing
            System.out.println ("This sound clip is " + sounds[c].getLength()/22.05 + "milliseconds.");
            // Length of the sound file
            t = t - (sounds[c].getLength()/22.05 + 250); // Decrease the time
            sounds[c].blockingPlay();
           
            try {
                Thread.sleep(250); // Wait a quarter sec
            } catch (Exception e) {
                System.err.println ("Exception: " + e.getMessage());
                System.err.println ("Stack Trace is:");
                e.printStackTrace();
            }
        }
        System.out.println ("Done.");
    }
}

/*
Enter the number of sound files:  
 7
How many seconds do you want to listen the sound file?:  
 10
Time remaining is 10000.0. 
File playing is 'C:\Users\‚Í‚µ‚à‚Æ\Documents\Courses\Computer Science II\DrJava\media-source\ducks-thames.wav. 
This sound clip is 6730.430839002267milliseconds. 
Time remaining is 3019.569160997733. 
File playing is 'C:\Users\‚Í‚µ‚à‚Æ\Documents\Courses\Computer Science II\DrJava\media-source\Elliot-hello.wav. 
This sound clip is 2483.356009070295milliseconds. 
Time remaining is 286.21315192743805. 
File playing is 'C:\Users\‚Í‚µ‚à‚Æ\Documents\Courses\Computer Science II\DrJava\media-source\preamble.wav. 
This sound clip is 19097.95918367347milliseconds. 
Done. 
 */ 