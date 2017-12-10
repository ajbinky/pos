package menu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * 
 * @author AJ Behncke
 *
 */
public class MenuTest {
	
	Menu m;
	File menuFile;
	
	@Test
	public void testMenuCreation() throws FileNotFoundException {
		String expected, actual;
		menuFile = new File("src/test/menu/menu.txt");
		m = new Menu(menuFile);
		actual = m.toString();
		expected = "this - $1.1\nthat - $2.2\nthe other - $3.3\n";
		assertEquals("Menu isn't correct", actual, expected);
	}

}
