import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.*;

/**
 * Read in spotify top charts csv into a 2d array and formatted the output
 *
 * @author Jacky chan
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream output = new PrintStream("Artists-WeekOfMMDDYYYY.txt");     //Creates  a text file  for the outputs
        String fileName = "regional-global-daily-lastest.csv";
        File file = new File("C:\\Users\\somet\\IdeaProjects\\Spotify top charts\\src\\regional-global-daily-latest.csv");  //creates file path for the Csv file
        String line = "";
        String[][] arr2 = new String[201][5];           //creates 2d array
        String[] arr = new String[100];
        TopStreamingArtists list = new TopStreamingArtists();   //creates Linked List


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));         //creates object that reads the data in the csv file
            int i = 0;
            while ((line = br.readLine()) != null) {           //loop reads through the csv line by line until the end

                String[] values = line.split(",");              //creates a string array that splits the csv data by commans
                arr2[i][0] = values[2];
                i++;
            }

            for(int j = 0; j < arr.length; j++){                              //Removes the quotes from the artists names
                arr[j] = arr2[j][0].replace('"', ' ');
                arr[j] = arr[j].trim();
            }

            for (int x = 0; x < arr.length; x++)                                //Sorting algorithm that sorts artists alphabethically
            {
                for (int h = x + 1; h < arr.length; h++)
                {
                    if (arr[x].compareTo(arr[h]) > 0)
                    {
                        String temp = arr[x];
                        arr[x] = arr[h];
                        arr[h] = temp;
                    }
                }
            }


            for(int k = 0; k < arr.length; k++){                                          //adds names of artists to the linked list as well as to txt output.
                list.insert(arr[k]);
                output.println(arr[k]);
            }

            list.display();                         //prints out LinkedList



        }catch(FileNotFoundException e){                        //exception handling
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}

class Artist {                                        //Artist Node
    public String name;
    public Artist next;

    Artist(String name){
        this.name = name;
        next = null;
    }

}

class TopStreamingArtists{                                            //Artist LinkedList
    private Artist first;
    public void TopStreamingArtists(){
        first = null;
    }
    public boolean isEmpty(){
        return (first == null);
    }
    public void display(){                                      //display method (prints out LinkedList)
        Artist n = first;
        while (n != null) {
            System.out.println(n.name + " ");
            n = n.next;
        }
    }

    public void insert(String artist) {                       //insert method (adds a new value to the linkedList)
        Artist art = new Artist(artist);
        art.next = first;
        first = art;
    }

}