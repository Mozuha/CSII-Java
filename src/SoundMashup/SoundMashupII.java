/*
Mizuki Hashimoto
02/15/2019

Write a program to load a sequence of Sound clips similar to what you did on the previous assignment. 
You will enter and edit the order of play by having the options to:
insert a clip into any position of the existing list, 
append a clip to the existing list, 
or delete a clip from the set in the array. 
The mashup is then played according to the order of the clips.
*/

import java.util.Scanner;
/*
public class SoundMashupII {
      public static void main (String [] args) {
          Scanner sc = new Scanner(System.in);
          SoundsArray clipsArray = new SoundsArray(100);
          Sound clip = null;  // clip
          int pos = 0;        // Position in array
          String fileName = ""; // Filename

          System.out.print("SoundMashupII\n Type:\n A to add the sound file\n I to insert the sound file\n"); 
          System.out.print(" D to delete the sound file\n P to play\n Q to quit\n");
          char command = Character.toUpperCase(sc.next().charAt(0));

          while (command != 'Q'){
              switch (command) {
                  case 'A': // Append
                      fileName = FileChooser.pickAFile();// Choose the sound file to play
                      clip = new Sound(fileName);
                      clip = reverse_scale(clip);
                      clipsArray.Append(clip);
                      break;
                  case 'I': // Insert
                      do {
                          fileName = FileChooser.pickAFile();
                          clip = new Sound(fileName);
                          System.out.print("Where do you want to insert?: ");
                          try {
                              pos = sc.nextInt();
                              clip = reverse_scale(clip);
                          } catch (Exception e) {
                              System.out.println("Inappropriate value.");
                              pos = -1;
                              sc.next();
                          }
                      } while (clipsArray.Insert(clip, pos - 1));
                      break;
                  case 'D': // Delete
                      do {
                          System.out.print("Which sound do you want to delete?: ");
                          try {
                              pos = sc.nextInt();
                          } catch (Exception e) {
                              System.out.println("Inappropriate value.");
                              pos = -1;
                              sc.next();
                          }
                      } while (clipsArray.Delete(pos - 1));
                      break;
                  case 'P': // Play
                      clipsArray.Play();
                      break;
                  default:
                      System.out.println("Command " + command + " did not found.");
                      break;
              }
              System.out.print("SoundMashupII");
              command = Character.toUpperCase(sc.next().charAt(0));
          }
          System.out.println("Quit.");
      }

      public static Sound reverse_scale(Sound clip){
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to reverse the sound? (y/n): ");
        char reverse = Character.toLowerCase(sc.next().charAt(0));
        if(reverse == 'y'){
            clip = clip.reverse();
        }
        System.out.print("How much scaling should be applied?: ");
        double scaling = sc.nextDouble();
        clip = clip.scale(scaling);
        return clip;
    }
}

/*
SoundMashupII
 Type:
 A to add the sound file
 I to insert the sound file
 D to delete the sound file
 P to play
 Q to quit
A
Do you want to reverse the sound? (y/n):  n
How much scaling should be applied?:  1
Successfully appended. 
SoundMashupII A
Do you want to reverse the sound? (y/n):  y
How much scaling should be applied?:  1
Successfully appended. 
SoundMashupII A
Do you want to reverse the sound? (y/n):  n
How much scaling should be applied?:  1
Successfully appended. 
SoundMashupII A
Do you want to reverse the sound? (y/n):  n
How much scaling should be applied?:  2
Successfully appended. 
SoundMashupII P
Now playing No.1 
Now playing No.2 
Now playing No.3 
Now playing No.4 
The total play time: 10.502857142857144 seconds. 
SoundMashupII I
Where do you want to insert?:  3
Do you want to reverse the sound? (y/n):  n
How much scaling should be applied?:  1
Successfully inserted. 
You must pass in a valid file name.  Please tryagain. 
Exception during load of file null 
Where do you want to insert?:  n
Inappropriate value. 
Rejected. 
SoundMashupII P
Now playing No.1 
Now playing No.2 
Now playing No.3 
Now playing No.4 
Now playing No.5 
The total play time: 13.236258503401361 seconds. 
SoundMashupII D
Which sound do you want to delete?:  3
Successfully deleted. 
Which sound do you want to delete?:  n
Inappropriate value. 
Rejected. 
SoundMashupII P
Now playing No.1 
Now playing No.2 
Now playing No.3 
Now playing No.4 
The total play time: 10.502857142857144 seconds. 
SoundMashupII D
Which sound do you want to delete?:  1
Successfully deleted. 
Which sound do you want to delete?:  1
Successfully deleted. 
Which sound do you want to delete?:  n
Inappropriate value. 
Rejected. 
SoundMashupII P
Now playing No.1 
Now playing No.2 
The total play time: 8.000136054421768 seconds. 
SoundMashupII K
Command K did not found. 
SoundMashupII 2
Command 2 did not found. 
SoundMashupII Q
Quit. 
*/