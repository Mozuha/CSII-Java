/*
Mizuki Hashimoto
03/01/2019

LinkedList class for SoundMashupIII. 
Has functions of append, insert, delete, and play the sound file.
 */

public class LLSoundList {
    private LLNode<Sound> head;
    private int nSounds;

    public LLSoundList() {
        head = null;
        nSounds = 0;
    }

    public void Append(Sound s) {
        LLNode<Sound> temp = new LLNode<Sound>(s);
        if (nSounds == 0) {  //simply new first node
            head = temp;
            nSounds = 1;
            return;
        }
        LLNode<Sound> prior = head; //start at head
        for (int i = 1; i < nSounds; i++) { //walk down to end of list
            prior = prior.getLink();
        }
        prior.setLink(temp); //old last sound now points to new last sound
        nSounds++;
        return;
    }

    //insert s before k-th node (counting from 1)
    public boolean Insert(Sound s, int k) {
        if (k >= nSounds) {
            return false;
        }
        LLNode<Sound> temp = new LLNode<Sound>(s);
        if (k <= 1) {  //simply new first node
            temp.setLink(head);
            head = temp;
            nSounds++;
            return true;
        }
        LLNode<Sound> prior = head; //start at head
        for (int i = 1; i < k; i++) { //walk down list k-1 steps
            prior = prior.getLink();
        }
        temp.setLink(prior); //new node inserted
        prior = temp; //prior node points at new node
        nSounds++;
        return true;
    }

    //delete k-th node (counting from 1)
    public boolean Delete(int k) {
        LLNode<Sound> temp = head;
        if (k > nSounds || head == null) {
            return false;
        }
        if (k <= 1) { //delete first node
            head = temp.getLink();
            nSounds--;
            return true;
        }
        LLNode<Sound> prior = head; //start at head
        for (int i = 1; i < k; i++) { //walk down list k-1 steps
            prior = prior.getLink();
        }
        prior.setLink(prior.getLink().getLink()); //prior node points at next next node
        nSounds--;
        return true;
    }
    
    //play sound file from ath node to bth node
    public void Play(int a, int b) {
        LLNode<Sound> temp = head;
        try {
            for (int i = 1; i <= b; i++) {
                if (i < a) { //skip to a
                    temp = temp.getLink();
                } else if (i >= a && i <= b) { //play a to b
                    System.out.println("Now playing: " + temp.getInfo()); //log the filename
                    temp.getInfo().blockingPlay();
                    temp = temp.getLink();
                }
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
     public int getNSounds(){ return nSounds; }
}
 