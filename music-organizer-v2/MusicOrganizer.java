import java.util.*;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    public void listAllTracks(){
        for(String fileName: files){
            System.out.println(fileName);
        }
    }

    public int indexOfTrackV1(String searchString){
        int counter = 0;
        for(String fileName: files){
            if (fileName.equals(searchString)){
                return counter;
            }
            counter ++;
        }
        return -1;
    }

    public int indexOfTrackV2(String searchString){
        int counter = 0;
        while(counter < files.size()){
            if (searchString.equals(files.get(counter))){
                return counter;
            }
            counter++;
        }
        return -1;
    }

    public int indexOfTrackV3(String searchString){
        for(int counter = 0;counter < files.size(); counter++){
            if (searchString.equals(files.get(counter))){
                return counter;
            }
        }
        return -1;
    }

    public void removeTrackFirst(String searchString){
        int counter = 0;
        boolean found = false;
        while((counter < files.size()) && !found){
            if (searchString.equals(files.get(counter))){
                files.remove(counter);
                found = true;
            }
            counter++;
        }
        // could do more things here!      

    }

    public void removeTrackAll(String searchString){
        int counter = 0;
        while(counter < files.size()){
            if (searchString.equals(files.get(counter))){
                files.remove(counter);        
            } else {
                counter++;
            }
        }
        // could do more things here!      

    }

    public void removeTrackWithIterator(String searchString){

        Iterator<String> iterator = files.iterator();
        while(iterator.hasNext()){
            if (searchString.equals(iterator.next())){
                iterator.remove();        
            }
        }

    }

}
