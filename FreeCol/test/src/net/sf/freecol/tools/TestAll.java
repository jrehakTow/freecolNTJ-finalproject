package net.sf.freecol.tools;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 5/10/16 11:07 AM
 * @author newsha
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	TranslationReportTest.class,
	MergeTranslationsTest.class,
	ForestMakerTest.class,
	InstallerTranslationsTest.class,
	RiverMakerTest.class,
	DesktopEntryTest.class,
	ColonizationMapReaderTest.class,
	FSGConverterTest.class,
//	GenerateDocumentationTest.class,
	SaveGameValidatorTest.class,
	MapConverterTest.class,
	ColonizationSaveGameReaderTest.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 5/10/16 11:07 AM
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
