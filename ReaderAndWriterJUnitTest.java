import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

public class ReaderAndWriterJUnitTest {
	

	@Test(timeout = 500)
	public void ReaderEmptyStringTest() throws IOException {
		try {
			Reader in = new StringReader(null);
			HighScoreFinder d = new HighScoreFinder(in);
			in.close();
			fail();
		} catch (Exception e) {

		} finally {
		}
	}

	@Test(timeout = 500)
	public void ReaderReadOneLine() throws IOException {
		try {
			Reader in = new StringReader("13:paul");
			HighScoreFinder d = new HighScoreFinder(in);
			assertEquals (13, d.getHighestScore());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
		}
	}
	
	@Test
	public void ReaderReadMultipleLines() throws IOException {
		try {
			Reader in = new FileReader("High Scores List");
			HighScoreFinder d = new HighScoreFinder(in);
			assertEquals (3, d.getHighestScore());
			//System.out.println(d.getHighestScore());
			assertEquals ("yuan", d.getHighestScoreName());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
		}
	}
	
	@Test
	public void WriterSingleLine() throws IOException {
		try {
			Reader in = new FileReader("High Scores List");
			HighScoreFinder d = new HighScoreFinder(in);
			d.updateScoreList(123, "bob");
			assertEquals (123, d.getHighestScore());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
