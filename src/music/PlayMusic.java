package music;

import java.util.ArrayList;
import stdlib.StdIn;

public class PlayMusic {
  
  public static ArrayList<Chord> chords = new ArrayList<Chord>();
  
  public static void readChords() {
    StdIn.fromFile("data/fugazi.txt");
    while (!StdIn.isEmpty()) {
        String inputDuration = StdIn.readLine();
        double duration = Double.parseDouble(inputDuration);
        String inputFrequencies = StdIn.readLine();
        String[] frequencyStrings = inputFrequencies.split(" ");
        double[] frequencies = new double[frequencyStrings.length];
        for (int i = 0; i < frequencyStrings.length; i++) {
            frequencies[i] = Double.parseDouble(frequencyStrings[i]);
        }
        Chord chord = new Chord(duration, frequencies);
        chords.add(chord);
    }
  }

  public static void main(String[] args) {
    readChords();
    for (Chord i: chords) {
      System.out.println(i);
      i.play();
    }
  }
}
