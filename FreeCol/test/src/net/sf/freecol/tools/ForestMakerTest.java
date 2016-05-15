package net.sf.freecol.tools;


import net.sf.freecol.util.test.FreeColTestCase;


// TODO: Auto-generated Javadoc
/**
 * The class <code>ForestMakerTest</code> contains tests for the class <code>{@link ForestMaker}</code>.
 *
 * @author newsha
 * @version $Revision: 1.0 $
 * @generatedBy CodePro at 5/10/16 11:07 AM
 */
public class ForestMakerTest extends FreeColTestCase{
	
	/**
	 * Run the ForestMaker() constructor test.
	 *
	 * @throws Exception the exception
	 * @generatedBy CodePro at 5/10/16 11:07 AM
	 */
	public void testForestMaker_1()
		throws Exception {
		ForestMaker result = new ForestMaker();
		assertNotNull(result);
		// add additional test code here
	} 
	
	/**
	 * Test main_1.
	 * Test directory
	 * @throws Exception the exception
	 */
	public void testMain_1()
			throws Exception {
			String[] args = new String[] {""};
			ForestMaker.main(args);
	} 
	
	/**
	 * Test main_2.
	 *
	 * @throws Exception the exception
	 */
	public void testMain_2()
			throws Exception {
			String[] args = new String[]{"conifer"};
			ForestMaker.main(args);
	} 


}