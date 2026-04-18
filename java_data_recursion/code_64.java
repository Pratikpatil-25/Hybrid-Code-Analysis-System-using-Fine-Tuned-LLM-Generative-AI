public class Song implements Comparable<Song>

{

	private String title;

	private String artist;

	private String album;

	private int year;

	

	

	

	

	public int compareTo(Song anotherSong) 
	{

		System.out.println("Comparing "+title+" with anotherSong's title "+anotherSong.title);

		return anotherSong.title.compareTo(title); 
		
	}

	public Song(String title, String artist, String album, int year) {

		super();

		this.title = title;

		this.artist = artist;

		this.album = album;

		this.year = year;

	}

	@Override

	public String toString() {

		return "Song [title=" + title + ", artist=" + artist + ", album=" + album + ", year=" + year + "]";

	}

	

	

}