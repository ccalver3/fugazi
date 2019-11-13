package music;

import stdlib.StdAudio;

public class Chord {
    
    private double duration;
    private double[] frequencies=new double[5];
    
    public Chord(double duration, double[] frequencies){
        this.duration=duration;
        for(int i=0;i<frequencies.length;i++){
            this.frequencies[i]=frequencies[i];
        }
        
    }
    
    public void play(){
        playChord(duration, frequencies);
        
    }
    
    public String toString(){
        String frequencyValues="";
        for(double i=0;i<frequencies.length;i++){
            frequencyValues+=frequencies[(int)i]+" ";
        }
        return String.format("["+duration+": "+frequencyValues+"]");
        
    }
    
    private void playChord(double duration, double[] frequencies) {
        final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
        final double[] slices = new double[sliceCount+1];
        for (int i = 0; i <= sliceCount; i++) {
            double chord = 0.0;
            for (double frequency: frequencies) {
                chord += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
            }
            slices[i] = chord/frequencies.length;
        }
        StdAudio.play(slices);
    }

}

