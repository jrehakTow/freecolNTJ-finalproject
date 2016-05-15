package net.sf.freecol.server.generator;

import java.io.File;

import net.sf.freecol.util.test.FreeColTestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class ColonizationMapLoaderTest.
 */
public class ColonizationMapLoaderTest extends FreeColTestCase {

	  /**
  	 * Test colonization map loader.
  	 *
  	 * @throws Exception the exception
  	 */
  	public void testColonizationMapLoader() throws Exception{
		  
		  //File mapFile = new File("emptyMap.mp");
		  //String path = mapFile.getAbsolutePath();
		  
		  //mapFile = new File(path);
		  //ColonizationMapLoader testMap = new ColonizationMapLoader(mapFile); // doesn't work??
		  File mapFile1 = new File("/Volumes/Machintosh 2A/Users/rehakjc/Documents/cosc603 testing and maintenance/freecolNTJ-finalproject/FreeCol/data/maps/emptyMap.mp");

		  
		  ColonizationMapLoader testMap = new ColonizationMapLoader(mapFile1);
		  
		  assertNotNull(testMap);
	  }

	  //could not find actual colonization map file in project or online to run additional tests. 
}
