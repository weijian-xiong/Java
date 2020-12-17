import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseTest {
  public static void main(String[] args) {
		System.out.println("Test Database Class.");
  }
  private Song song1,song2,song3,song4;
  List<Song> tempSongList1, tempSongList2,tempSongList3;
  Database tempDB1,tempDB2,tempDB3;

  @Before
  public void createTester() {
    song1=new Song("Kadhal Cricket", "Kharesma Ravichandran", 
				"Thani Oruvan", "Cricket.mp3", "Mp3", 214);
	song2=new Song("Kannala Kannala", "Kaushik Krish", 
				"Thani Oruvan", "Kannala.mp3", "Mp3", 215);
	song3=new Song("Kadhal Cricket", "Kharesma Ravichandran",
				"Thani Oruvan", "Cricket.mp3", "Mp3", 214);
	tempSongList1= new ArrayList<Song>();
	tempSongList1.add(song1);
	tempSongList1.add(song2);
	tempSongList1.add(song3);
		
    tempDB1= new Database(tempSongList1);
    song4=new Song("Kannala Kannala", "Kaushik Krish", 
    "Thani Oruvan", "Kannala.mp3", "Mp3", 300);

	tempSongList2= new ArrayList<Song>();
	tempSongList2.add(song1);
	tempSongList2.add(song2);
    tempSongList2.add(song3);
    tempSongList2.add(song4);
		
    tempDB2= new Database(tempSongList2);
    
    tempSongList3= new ArrayList<Song>();
	tempSongList3.add(song1);
	tempSongList3.add(song2);
	tempSongList3.add(song3);
		
    tempDB3= new Database(tempSongList3);
  }
    
  @Test
  public void testGetSongList() {
    System.out.println("Running testGetSongList method(Database class)...");
    tempDB1.setSongList(tempSongList1);
    assertEquals("get Songlist",tempSongList1,tempDB1.getSongList());
  }
  
  @Test
  public void testIsEmpty() {
    System.out.println("Running testIsEmpty method(Database class)...");
    assertEquals("Database is not empty",false,tempDB1.isEmpty());
  }

  @Test
  public void testAddSong() {
    System.out.println("Running testAddSong method(Database class)...");
    tempDB1.addSong(song4);
    assertEquals("get Songlist @ index 2",tempSongList2,tempDB1.getSongList());
  }
  @Test
  public void testRemoveSong() {
    System.out.println("Running testRemoveSong method(Database class)...");
    tempDB1.removeSong(song4);
  assertEquals("get Songlist @ index 2",tempSongList3,tempDB1.getSongList());
}

}