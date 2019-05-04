/*---------------------------------------------------------------
Mizuki Hashimoto
04/12/2019

This is random writer programme using Arraylist of Linked List as the words container.
This programme will output randomly replaced text of the text file chosen by the user
in the another text file chosen by the user.
The user also can change the output lengths.
-----------------------------------------------------------------*/

package RandomWriter;

import java.io.*;
import java.util.*;

public class randomwriter{
    public static void main(String[] args) throws IOException{
        String sourceFileName; //input file name
        String resultFileName; //output file name
        int N; //interactively get this info;;
        int nWords = 0;
        int index = 0;
        long startTime; //for emperical time measurement
        long stopTime;  //elapsed time is difference in millisec

        Scanner sc = new Scanner(System.in);
        System.out.println("This is the random writer.");
        System.out.print("Choose a text file to input: ");
        sourceFileName = sc.next(); //get input file name
        System.out.print("What is the name of file to output?: ");
        resultFileName = sc.next(); //get output file name
        System.out.print("How many words do you want to output?: ");
        N = sc.nextInt(); //get number of words to output

        //Data structure declarations go here
        ArrayList <String> unique = new ArrayList<>(); //arraylist of unique words

        //this is an arraylist of linked lists of strings
        ArrayList <LinkedList<String>> follows = new ArrayList <>(); //arraylist of LL of the words following specific unique words

        //Prepare files
        Scanner dataFile = new Scanner(new FileReader(sourceFileName));
        PrintWriter outFile = new PrintWriter(new FileWriter(resultFileName));
        //Read a line from the source file until end of file
        String current = dataFile.next(); //current word
        String first = current; //first word
        String next; //next word following first word
        startTime = System.currentTimeMillis();

        while(dataFile.hasNext()){
            next = dataFile.next();
            if(unique.indexOf(current) == -1){ //if unique is not containing current word
                unique.add(current); //add current word into unique
                follows.add(index, new LinkedList<>()); //construct a LL into follows
                follows.get(index).add(next); //add next word into LL of follows
                index++;
            } else{ //if unique is already containing current word
                follows.get(unique.indexOf(current)).add(next); //add next word into corresponding LL of follows
            }
            current = next;
            nWords++;
            //if(nWords % 1000 == 0)
              //  System.out.println(nWords+" words"); //print number of words each 1000 words
        }
        //Put first word into end of follows
        if(unique.indexOf(current) == -1){
            unique.add(current);
            follows.add(index, new LinkedList<>());
            follows.get(index).add(first);
        } else{
            follows.get(unique.indexOf(current)).add(first);
        }
        nWords++;
        System.out.println(nWords+" words"); //print total number of words

        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed input time = "+(stopTime-startTime)+" msecs.");
        startTime = stopTime;

        //Level 1: choose the next word based on one previous word
        outFile.println("\n------------random list----------------");
        outFile.flush();
        Random rand = new Random();
        int rn = rand.nextInt(unique.size()); //get random number
        String firstWord = unique.get(rn); //get a word from unique at random index number
        String nextWord;
        for (int i=0; i<N; i++){
            nextWord = follows.get(rn).get(rand.nextInt(follows.get(rn).size())); //get a word from follows at random index number
            outFile.print(firstWord + " ");
            firstWord = nextWord;
            rn = unique.indexOf(firstWord); //search unique for nextWord that matches the word from the LL
        }
        outFile.flush();
        outFile.close();
        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed output time = "+(stopTime-startTime)+" msecs.");
    }
}
