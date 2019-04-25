/*
Mizuki Hashimoto
03/01/2019

Modify the SoundMashupII class so it uses LinkedList as a sound strage instead of Array.
In the Play function, the user can choose the range of playing by entering the first node and the last node to play.
*/

import java.util.Scanner;

public class SoundMashupIII {
      public static void main (String [] args) {
          Scanner sc = new Scanner(System.in);
          LLSoundList clipsList = new LLSoundList();
          Sound clip = null;  // clip
          int pos = 0;        // Position in list
          String fileName = ""; // Filename

          System.out.print("SoundMashupIII\n Type:\n A to add the sound file\n I to insert the sound file\n");
          System.out.print(" D to delete the sound file\n P to play\n Q to quit\n");
          char command = Character.toUpperCase(sc.next().charAt(0));

          while (command != 'Q'){
              switch (command) {
                  case 'A': // Append
                      fileName = FileChooser.pickAFile(); // Choose the sound file to play
                      clip = new Sound(fileName);
                      clip = reverse_scale(clip);2
                      clipsList.Append(clip);
                      break;
                  case 'I': // Insert
                      fileName = FileChooser.pickAFile();
                      clip = new Sound(fileName);
                      System.out.print("Where do you want to insert?: ");
                      try {
                          pos = sc.nextInt();
                          clip = reverse_scale(clip);
                          if (pos <= clipsList.getNSounds() && pos >= 1) {
                              clipsList.Insert(clip, pos - 1);
                          }
                      }catch (Exception e) {
                              System.out.println("Inappropriate value.");
                              pos = -1;
                              sc.next();
                      }
                      break;
                  case 'D': // Delete
                      System.out.print("Which sound do you want to delete?: ");
                      try {
                          pos = sc.nextInt();
                          clipsList.Delete(pos - 1);
                      } catch (Exception e) {
                          System.out.println("Inappropriate value.");
                          pos = -1;
                          sc.next();
                      }
                      break;
                  case 'P': // Play
                      System.out.print("Which node do you want to start play from?: ");
                      int a = sc.nextInt(); //first node to play
                      System.out.print("Until which node?: ");
                      int b = sc.nextInt(); //last node to play
                      clipsList.Play(a, b);
                      break;
                  default:
                      System.out.println("Command " + command + " did not found.");
                      break;
              }
              System.out.print("SoundMashupIII");
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