package com.playList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album
{
    private String albumName;
    private String artistName;

    //private ArrayList<Song> songList;
    LinkedList<Song> albumList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;

        System.out.println("NEW ALBUM ADDED");

        //this.songList = new ArrayList<>();
        this.albumList = new LinkedList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public LinkedList<Song> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(LinkedList<Song> albumList) {
        this.albumList = albumList;
    }

    public void addSong(String name, double duration) {
        albumList.add(new Song(name, duration));
        System.out.println("new song " + name + ": " + duration + "s" + " added to album " + this.albumName);

    }


    public void getSongsFromInside() {

        for (int i = 0; i < this.albumList.size(); i++) {
            System.out.println("    " + this.albumList.get(i).getTitle());
        }
    }

    /**
    public boolean addSong (String songName, double duration)
    {
        if(isSongPresent(songName) == null) {
            songList.add(new Song(songName,duration));
            System.out.println("New Song added successfully : " +songName);
            return true;
        }
        else{
            System.out.println("Song "+songName+ " already exists in the songList");
            return false;
        }
    }
     */

    /**
     *
     * @param songTitle that songTitle checking is song already present or not in arrayList
     * @return
     */
    public Song findingSong (String songTitle)
    {
        for (Song checkedSong : this.albumList)
        {
            if (checkedSong.getTitle().equals(songTitle)) return checkedSong;
        }
        return null;
    }

    /**
     *
     * @param songName Only identified song added to playList from album
     * @param playList album songs added to playList for playing Music
     * @return true means added successfully in playList otherwise not exists in album.
     */
    public boolean addSongToPlayList (String songName, LinkedList<Song> playList)
    {
        Song checkedSong = findingSong(songName);

        if (checkedSong != null)
        {
            playList.add(checkedSong);
            System.out.println("[" + songName +"]" + " That song added to our MusicList");
            return true;
        }
        System.out.println("[" + songName +"]" + " That song is never exists our Album");
        return false;
    }

    /**
     *
     * @param trackNumber also use trackNo we can add songs to playList
     * @param playlist
     * @return
     */

    public boolean addSongToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.albumList.size())) {

            playlist.add(this.albumList.get(index));
            System.out.println("[" + this.albumList.get(index).getTitle() +"]" + " That song added to our MusicList");
            return true;

        }
        System.out.println("this album does not contain track no: " + trackNumber);
        return false;
    }
}
