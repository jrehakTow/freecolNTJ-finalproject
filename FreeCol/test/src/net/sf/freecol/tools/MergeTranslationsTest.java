package net.sf.freecol.tools;

import java.io.File;
import java.util.Map;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>MergeTranslationsTest</code> contains tests for the class <code>{@link MergeTranslations}</code>.
 *
 * @generatedBy CodePro at 5/14/16 8:09 PM
 * @author Tom
 * @version $Revision: 1.0 $
 */
public class MergeTranslationsTest {
	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_1()
		throws Exception {
		String[] args = new String[] {null, ""};
	
		MergeTranslations.main(args);
		

		// add additional test code here
	}


	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_2()
		throws Exception {
		String[] args = new String[] {null, "", ""};

		MergeTranslations.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_3()
		throws Exception {
		String[] args = new String[] {null, ""};

		MergeTranslations.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_4()
		throws Exception {
		String[] args = new String[] {null, ""};

		MergeTranslations.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_5()
		throws Exception {
		String[] args = new String[] {"c:\\logs", "c:\\temp"};

		MergeTranslations.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_6()
		throws Exception {
		String[] args = new String[] {"c:\\temp", "c:\\temp"};

		MergeTranslations.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_7()
		throws Exception {
		String[] args = new String[] {"c:\\temp",""};

		MergeTranslations.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_8()
		throws Exception {
		String[] args = new String[] {null, "", ""};

		MergeTranslations.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_9()
		throws Exception {
		String[] args = new String[] {null, "", ""};

		MergeTranslations.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testMain_10()
		throws Exception {
		File sourceFile = new File("c:\\temp\\", "test1.txt");
		File desFile = new File("c:\\temp\\", "test1.txt");
		String[] args = new String[] {null, "c:\\temp", "c:\\drivers"};
		MergeTranslations.processFiles(sourceFile,
				desFile, args);
		MergeTranslations.main(args);

		// add additional test code here
	}
	
	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void readFiletext()
		throws Exception {
		File soFile = new File("c:\\WINDOWS\\", "core.xml");
		
		Map<String, String> a=MergeTranslations.readFile(soFile);
	}
	
		/**
		 * Run the void main(String[]) method test.
		 *
		 * @throws Exception
		 *
		 * @generatedBy CodePro at 5/14/16 8:09 PM
		 */
		@Test(expected = java.lang.NullPointerException.class)
		public void readFiletext1()
			throws Exception {
			File soFile = new File("c:\\WINDOWS\\", "core.xml");
			
			Map<String, String> a=MergeTranslations.readFile(soFile);	
	

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 5/14/16 8:09 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MergeTranslationsTest.class);
	}
}