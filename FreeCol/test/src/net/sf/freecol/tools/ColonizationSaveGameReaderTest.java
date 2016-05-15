package net.sf.freecol.tools;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ColonizationSaveGameReaderTest</code> contains tests for the class <code>{@link ColonizationSaveGameReader}</code>.
 * @generatedBy CodePro at 5/14/16 8:10 PM
 * @author newsha
 * @version $Revision: 1.0 $
 */
public class ColonizationSaveGameReaderTest {
	/**
	 * Run the ColonizationSaveGameReader(byte[]) constructor test.
	 * @throws Exception
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@Test
	public void testColonizationSaveGameReader_1()
		throws Exception {
		byte[] data = new byte[] {};
		ColonizationSaveGameReader result = new ColonizationSaveGameReader(data);
		
		assertNotNull(result);
	}

	/**
	 * Run the String getString(byte[],int,int) method test.
	 * @throws Exception
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void testGetString_1() 
		throws Exception {
		byte[] data = new byte[] {};
		int start = 1;
		int length = 3;
		String result = ColonizationSaveGameReader.getString(data, start, length);
		
		assertNotNull(result);
	}

	/**
	 * Run the String getString(byte[],int,int) method test.
	 * @throws Exception
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void testGetString_2()
		throws Exception {
		byte[] data = new byte[] {};
		int start = -1 ;
		int length = 3;

		String result = ColonizationSaveGameReader.getString(data, start, length);

		assertNotNull(result);
	}
	
	/**
	 * Run the String getString(byte[],int,int) method test.
	 * @throws Exception
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void testGetString_3()
		throws Exception {
		byte[] data = new byte[] {};
		int start = 0 ;
		int length = 0;

		String result = ColonizationSaveGameReader.getString(data, start, length);

		assertNotNull(result);
	}
	
	/**
	 * Run the String getString(byte[],int,int) method test.
	 * @throws Exception
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void testGetString_4()
		throws Exception {
		byte[] data = new byte[] {};
		int start = -3 ;
		int length = -1;

		String result = ColonizationSaveGameReader.getString(data, start, length);

		assertNotNull(result);
	}

	/**
	 * Run the void main(String[]) method test.
	 * @throws Exception
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void testMain_1()
		throws Exception {
		String[] args = new String[] {};

		ColonizationSaveGameReader.main(args);

	}

	/**
	 * Run the void main(String[]) method test.
	 * @throws Exception
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void testMain_2()
		throws Exception {
		String[] args = new String[] {};

		ColonizationSaveGameReader.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 * @throws Exception
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void testMain_3()
		throws Exception {
		String[] args = new String[] {};

		ColonizationSaveGameReader.main(args);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 * @param args the command line arguments
	 * @generatedBy CodePro at 5/14/16 8:10 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ColonizationSaveGameReaderTest.class);
	}
}