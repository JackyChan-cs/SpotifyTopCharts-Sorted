import java.util.*;

class TopSongs {                                            //Artist LinkedList

    Stack<Song> lastListened = new Stack<Song>();

    private Song first;

    public Song getFirst(){
        return first;
    }

    TopSongs(){
        first = null;
    }
    TopSongs(Song song){
        first = song;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void display() {                                      //display method (prints out LinkedList)
        Song n = first;
        while (n != null) {
            System.out.println(n.getTitle() + ", " + n.getArtist());
            n = n.getNext();
        }
    }

    public void insert(Song song) {                       //insert method (adds a new value to the linkedList)
//        Song song = new Song(title, artist);

        if(first == null){
            first = song;
            return;
        }

        Song cursor = first;
        while(cursor.getNext()!= null){
            cursor = cursor.getNext();
        }
        cursor.setNext(song);
    }

    public void deQueue(){                          //deQueue method removes the next output of the queue and stores it in a stack
        lastListened.push(first);
        first = first.getNext();
    }

    public void lastSong(){                                             //lastSong method pops the stack of stored songs to check for last listened song.
        System.out.println(lastListened.pop());
    }
}