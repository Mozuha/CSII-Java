/*---------------------------------------------------------------
Mizuki Hashimoto
04/12/2019

This is random writer programme.
This programme will output randomly replaced text of the text file chosen by the user
in the another text file chosen by the user.
The user also can change the input and the output lengths.
-----------------------------------------------------------------*/

package RandomWriter;

import java.io.*;
import java.util.*;
public class randomwriter
{
    public static void main(String[] args) throws IOException
    {
        //Get file name arguments from command line or interactively as entered by user
        String sourceFileName = "midsum.txt"; //interactively get this info;
        String resultFileName  = "result16978.txt"; //interactively get this info;
        int N = Integer.parseInt("16978"); //interactively get this info;;
        int nWords = 0;
        int nFirst = 100;
        long startTime; //for emperical time measurement
        long stopTime;  //elapsed time is difference in millisec

        //Data structure declarations go here
        //...........
        //this is a simple linked list of all words (strings)
        LinkedList <String> words= new LinkedList <String>();

        //this is an arraylist of linked lists of strings
        ArrayList <LinkedList<String>> byFirstLetter = new ArrayList <LinkedList<String>>(27);
        //initialize this array of linkedlists
        for(int i=0; i<27; i++){
            byFirstLetter.add(i,new LinkedList<String>());
        }

        //Prepare files
        Scanner dataFile = new Scanner(new FileReader(sourceFileName));
        PrintWriter outFile = new PrintWriter(new FileWriter(resultFileName));
        //Read a line from the source file until end of file
        String firstWord = dataFile.next();
        String secondWord;
        startTime = System.currentTimeMillis();
        while(dataFile.hasNext()){
            secondWord = dataFile.next();
            nWords++;
            if(nWords % 1000 ==0) System.out.println(nWords+" words");
            //only print the first N words for debugging
            //remove or comment out when you have built in a
            //a storage structure
            //..............
            if(nWords<= nFirst){
                outFile.print(firstWord+" ");
                outFile.flush();
            }
            words.add(firstWord);//adding word to lone linked list for demo only

            //and put words into lists by their first letter
            char c = Character.toLowerCase(firstWord.charAt(0));
            int ci = (c>='a' && c<='z')? c-'a' : 26;
            ((LinkedList)(byFirstLetter.get(ci))).add(firstWord);

            //look for first word in the structure
            // and add the second word as the follow
            //...........

            firstWord = secondWord;
        }
        //add the final word to the structure
        //it may be the only entry without a follow word
        //but it needs to be in the list of unique words
        //...........
        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed input time = "+(stopTime-startTime)+" msecs.");

        startTime = stopTime;
        //  Let's dump the front of the list to verify same sequence
        outFile.println(N+"\n------------from list----------------");
        outFile.flush();
        System.gc();
        for(int i=0; i<N; i++){
            outFile.print(words.get(i)+" ");
        }
        //   Level 0: random selection of words from lone list
        outFile.println("\n------------random list----------------");
        outFile.flush();
        Random rand = new Random();
        for (int i=0; i<N; i++){
            outFile.print(words.get(rand.nextInt(nWords))+" ");
        }

        //  Random words from each letter category
        outFile.println("\n------------random alpha list----------------");
        outFile.flush();
        for (int i=0; i<27; i++){
            LinkedList ll = (LinkedList)(byFirstLetter.get(i));
            int lllen = ll.size();
            //     outFile.print(ll);
            if(lllen>1)outFile.print(ll.get(rand.nextInt(lllen))+" ");
        }
        outFile.flush();
        outFile.close();
        stopTime = System.currentTimeMillis();
        System.out.println("Elapsed output time = "+(stopTime-startTime)+" msecs.");
    }
}
