/*---------------------------------------------------------------
Mizuki Hashimoto
05/03/2019

This is random writer programme using TreeMap as the words container.
This programme will output randomly replaced text of the text file chosen by the user
in the another text file chosen by the user.
The user also can change the output lengths.
-----------------------------------------------------------------*/

package RandomWriter;

import java.io.*;
import java.util.*;

public class randomwriterBST {
    public static void main(String[] args) throws IOException{
        String sourceFileName; //input file name
        String resultFileName; //output file name
        int N = 0; //interactively get this info;;
        int nWords = 0;
        int index = 0;
        long startTime; //for emperical time measurement
        long stopTime;  //elapsed time is difference in millisec

        Scanner sc = new Scanner(System.in);
        System.out.println("This is the random writer using BST.");
        System.out.print("Choose a text file to input: ");
        sourceFileName = sc.next(); //get input file name
        System.out.print("What is the name of file to output?: ");
        resultFileName = sc.next(); //get output file name
        System.out.print("How many words do you want to output?: ");
        N = sc.nextInt(); //get number of words to output

        //Data structure declarations go here
        TreeMap<String, LinkedList<String>> miki = new TreeMap<>(); //key: unique words, value: following words.
        TreeMap<Integer, String> eda = new TreeMap<>(); //for choosing the first word

        //Prepare files
        Scanner dataFile = new Scanner(new FileReader(sourceFileName));
        PrintWriter outFile = new PrintWriter(new FileWriter(resultFileName));
        //Read a line from the source file until end of file
        String current = dataFile.next(); //first word
        String first = current; //current word
        String next; //next word following current word
        startTime = System.currentTimeMillis();

        while(dataFile.hasNext()){
            next = dataFile.next();
            if(miki.containsKey(current) == false){ //if there is no key for current
                miki.put(current, new LinkedList<String>()); //put current as a key and construct LL
                miki.get(current).add(next); //add next word as the value of the key
                eda.put(index, current); //refer the index to the key
                index++;
            } else if(miki.containsKey(current) == true){ //if there is a key for current
                miki.get(current).add(next); //add next word as the value of the key
            }
            current = next;
            nWords++;
            //if(nWords % 1000 == 0)
              //  System.out.println(nWords+" words"); //print number of words each 1000 words
        }
        //Put first word into end of follows
        if(miki.containsKey(current) == false){
            miki.put(current, new LinkedList<String>());
            miki.get(current).add(first);
            eda.put(index, current);
            index++;
        } else if(miki.containsKey(current) == true){
            miki.get(current).add(first);
        }
        nWords++;
        System.out.println(nWords+" words"); //print total number of words

        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed input time = "+(stopTime-startTime)+" msecs.");
        startTime = stopTime;

        outFile.println("\n------------random list----------------");
        outFile.flush();
        Random rand = new Random();
        int rn = rand.nextInt(eda.size()); //get random number
        String firstWord = eda.get(rn); //get a word from eda at random index number
        String nextWord;
        for (int i=0; i<N; i++){
            nextWord = miki.get(firstWord).get(rand.nextInt(miki.get(firstWord).size())); //get a word from miki at random index number
            outFile.print(firstWord + " ");
            firstWord = nextWord;
        }
        outFile.flush();
        outFile.close();
        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed output time = "+(stopTime-startTime)+" msecs.");
    }
}
