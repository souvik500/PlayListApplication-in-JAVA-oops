package com.playList;

import java.util.*;

public class Main
{
    /**
     * Here "Album" class of ArrayList which mention that for particular album few song present
     * like songAlbumList [0] = few song present like way songAlbumList [1] = few song present and
     * so on.....
     */
    public static ArrayList<Album> songAlbumList = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Radio1", "HoneySing");

        album.addSong("abc", 4.50);  //1st trackNumber
        album.addSong("dfg", 5.62);  //2nd trackNumber
        album.addSong("tyu", 9.30);  //3rd trackNumber
        album.addSong("ert", 8.5);   //4th trackNumber
        /**
         * Adding all song and their duration to 1st Album class constructor
         * songAlbumList [0]th index;
         */
        songAlbumList.add(album);

        album = new Album("Radio2", "Jackson");

        album.addSong("hoho", 2.30);  //1st trackNumber
        album.addSong("ghhh", 5.60);  //2nd trackNumber
        album.addSong("bad",  6.54);  //3rd trackNumber
        album.addSong("qwe", 8.96);   //4th trackNumber

        /**
         * Adding all song and their duration to 2nd Album class constructor.
         * songAlbumList [1]st index;
         */
        songAlbumList.add(album);

        album = new Album("Kill Em All", "ACDC");

        album.addSong("Seek & Destory", 12.3);     //1st trackNumber
        album.addSong("Ride The Lightin", 13.20); //2nd trackNumber
        album.addSong("Seek & Destory", 14.20);  //3rd trackNumber
        /**
         * Adding all song and their duration to 2nd Album class constructor.
         * songAlbumList [2]nd index;
         */
        songAlbumList.add(album);

        album = new Album("Death Magnectis", "Metallica");

        album.addSong("The Day That Never Comes", 123);  //1st trackNumber
        album.addSong("All NIghtmare Long", 123);       //2nd trackNumber
        album.addSong("Blood and scared", 123);         //3rd trackNumber
        /**
         * Adding all song and their duration to 2nd Album class constructor.
         * songAlbumList [3]rd index;
         */
        songAlbumList.add(album);


        LinkedList<Song> playList_1 = new LinkedList<>();

        songAlbumList.get(0).addSongToPlayList("abc",playList_1);
        songAlbumList.get(0).addSongToPlayList("tyu",playList_1); //that song is not present in our first album
        songAlbumList.get(0).addSongToPlayList(4,playList_1);
        songAlbumList.get(1).addSongToPlayList("bad",playList_1);
        songAlbumList.get(1).addSongToPlayList("qwe",playList_1);
        songAlbumList.get(2).addSongToPlayList("Seek & Destory", playList_1);
        songAlbumList.get(2).addSongToPlayList(2, playList_1);
        songAlbumList.get(3).addSongToPlayList(2, playList_1);
        songAlbumList.get(3).addSongToPlayList(3, playList_1);
        printListPlaylist(playList_1);

        playMusic (playList_1);
    }

    private static void playMusic (LinkedList<Song> playingSong)
    {
        Scanner sc = new Scanner(System.in);
        /**
         * Iterate through each song either forward or backward or remove from our playList
         * or replace(SET method in iterator) or add
         */
        ListIterator<Song> iterator= playingSong.listIterator();

        if (playingSong.size() == 0) System.out.println("There is empty Music");

        else {
            System.out.println("Now playing: " +iterator.next().toString());

        }

        boolean quit = false;
        boolean backward = true;

        do {
            openOption();

            System.out.println("Now Please Press any Number Between [0-5] Ranges :: ");
            int action = sc.nextInt();

            switch (action) {
                case 0:
                    System.out.println("PlayList Completed");
                    quit = true;
                    break;

                case 1:
                    if (!backward)
                    {
                        if (iterator.hasNext()) iterator.next();
                        backward = true;
                    }

                    if (iterator.hasNext()) System.out.println("Now Playing: " + iterator.next().toString());

                    else {
                        System.out.println("No song available, You reach to end song");
                    }
                    break;

                case 2:
                    if (backward)
                    {
                        if (iterator.hasPrevious()) iterator.previous();
                        backward = false;
                    }
                    if (iterator.hasPrevious()) System.out.println("Now Playing: " + iterator.previous().toString());

                    else {
                        System.out.println("You are at 1st song, press 1 for listen next song.");
                        backward = false;
                    }
                    break;

                case 3:
                    if (backward) {
                        if (iterator.hasPrevious()){
                            System.out.println("Now Playing: " + iterator.previous().toString());
                            backward = false;
                        }

                        else {
                            System.out.println("This is our First song");
                        }
                    }
                    else {
                        if (iterator.hasNext()) {
                            System.out.println("Now Playing: " + iterator.next().toString());
                            backward = true;
                        }

                        else {
                            System.out.println("This is our very Last song");
                        }
                    }
                    break;

                case 4:
                    iterator = playingSong.listIterator();
                    System.out.println("-----------------");

                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }

                    System.out.println("-----------------");
                    break;

                case 5:
                    if (playingSong.size() > 0) {
                        iterator.remove();

                        if (iterator.hasNext()) System.out.println("Now Play: " + iterator.next().toString());

                        else if (iterator.hasPrevious())
                            System.out.println("Now Play: " + iterator.previous().toString());
                    }
                    break;

//                case 6 :
//                    System.out.println("Enter The name of the Song: ");
//                    sc.nextLine();//Just to eliminate to enter otherwise it will be stored as a input
//                    String songname = sc.nextLine();
//                    System.out.println("Enter The Name of the artist");
//                    String artist = sc.nextLine();
//                    System.out.println("Enter The Duration of the song: ");
//                    String duration = sc.nextLine();
//                    Song s=new Song(songname,duration);
//                    songs.add(s);
//                    System.out.println(songname+" song is added to playlist "+playlistname+"!!!\n");
//                    break;

            }
        } while (!quit);
    }

    protected static void openOption()
    {
        System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Available options between 0 to 5 Ranges \n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - delete current song \n");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    /**
     *
     * @param playlist show all added playList music
     */

    public static void printListPlaylist(LinkedList<Song> playlist) {
        System.out.println("============ playlist =================");
//        System.out.println("List of song in album: " + albumName);

        Iterator<Song> i = playlist.iterator();
        int j = 0;
        while (i.hasNext()) {

            j++;
            Song currentSong = i.next();
            System.out.println(j + ": " + currentSong.getTitle());
        }
        System.out.println("=============================");

    }
}
