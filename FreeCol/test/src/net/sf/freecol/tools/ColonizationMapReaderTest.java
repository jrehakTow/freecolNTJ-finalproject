package net.sf.freecol.tools;

//import java.io.FileNotFoundException;

import net.sf.freecol.util.test.FreeColTestCase;

import org.junit.*;

//import static org.junit.Assert.*;

/**
 * The class <code>ColonizationMapReaderTest</code> contains tests for the class <code>{@link ColonizationMapReader}</code>.
 *
 * @generatedBy CodePro at 5/10/16 11:07 AM
 * @author newsha
 * @author James Rehak
 * @version $Revision: 1.0 $
 */
public class ColonizationMapReaderTest extends FreeColTestCase{
	/**
	 * Run the ColonizationMapReader() constructor test.
	 *
	 * @generatedBy CodePro at 5/10/16 11:07 AM
	 */
	@Test
	public void testColonizationMapReader_1()
		throws Exception {
		ColonizationMapReader result = new ColonizationMapReader();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/10/16 11:07 AM
	 
	//@Test(expected = java.io.FileNotFoundException.class)
	public void testMain_1()
		throws Exception {
		String[] args = new String[] {""};

		ColonizationMapReader.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 * Test conditional normal operation
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/10/16 11:07 AM
	 */
	//@Test//(expected = java.io.FileNotFoundException.class)
	public void testMain_1()
		throws Exception {
		String[] args = new String[2];
		args[0] = "--palette";
		args[1] = "rw";

		ColonizationMapReader.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 * Test secondary conditional
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/10/16 11:07 AM
	 */
	@Test(expected = java.io.FileNotFoundException.class)
	public void testMain_2()
		throws Exception {
		String[] args = new String[2];
		args[0] = "r";
		args[1] = "rw";
		ColonizationMapReader.main(args);

		// add additional test code here
	}

}