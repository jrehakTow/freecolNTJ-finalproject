/**
 *  Copyright (C) 2002-2016   The FreeCol Team
 *
 *  This file is part of FreeCol.
 *
 *  FreeCol is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  FreeCol is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FreeCol.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.freecol.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static net.sf.freecol.common.util.CollectionUtils.*;

// TODO: Auto-generated Javadoc
/**
 * Merge some translation updates.
 */
public class MergeTranslations {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	static int Flag_exit = 0;

	public static void main(String[] args) throws Exception {

		File sourceDirectory = new File(args[0]);
		if (!sourceDirectory.isDirectory()) {
			Flag_exit = 1;
			System.exit(1);
		}

		File targetDirectory = new File(args[1]);
		if (!targetDirectory.isDirectory()) {
			Flag_exit = 1;
			System.exit(1);
		}

		final String localeKey = args.length > 2 ? args[2] : "";
		String[] sourceFiles = sourceDirectory.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.matches("FreeColMessages_" + localeKey + ".*\\.properties");
			}
		});

		processFiles(sourceDirectory, targetDirectory, sourceFiles);
	}

	/**
	 * process the files
	 * 
	 * @param sourceDirectory
	 * @param targetDirectory
	 * @param sourceFiles
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	static void processFiles(File sourceDirectory, File targetDirectory, String[] sourceFiles)
			throws IOException, FileNotFoundException {
		for (String name : sourceFiles) {

			System.out.println("Processing source file: " + name);

			File sourceFile = new File(sourceDirectory, name);
			Map<String, String> sourceProperties = readFile(sourceFile);

			File targetFile = new File(targetDirectory, name);

			if (targetFile.exists()) {
				Map<String, String> targetProperties = readFile(targetFile);

				List<Entry<String, String>> missingProperties = transform(sourceProperties.entrySet(),
						e -> !targetProperties.containsKey(e.getKey()), Collectors.toList());
				if (!missingProperties.isEmpty()) {
					try (FileWriter out = new FileWriter(targetFile, true)) {
						writeFile(missingProperties, out);
					}
				}
			} else {
				System.out.println("Copying " + name + " from trunk.");
				FileWriter out;
				try (FileReader in = new FileReader(sourceFile)) {
					out = eslewriteFile(targetFile, in);
				}
				out.close();

			}
		}
	}

	/**
	 * @param targetFile
	 * @param in
	 * @return
	 * @throws IOException
	 */
	private static FileWriter eslewriteFile(File targetFile, FileReader in) throws IOException {
		FileWriter out;
		out = new FileWriter(targetFile);
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		return out;
	}

	/**
	 * Write to files
	 * 
	 * @param missingProperties
	 * @param out
	 * @throws IOException
	 */
	private static void writeFile(List<Entry<String, String>> missingProperties, FileWriter out) throws IOException {
		out.write("### Merged from trunk on " + DateFormat.getDateTimeInstance().format(new Date()) + " ###\n");
		for (Entry<?, ?> entry : missingProperties) {
			out.write((String) entry.getKey());
			out.write("=");
			out.write((String) entry.getValue());
			out.write("\n");
		}
	}

	/**
	 * Read file.
	 *
	 * @param file
	 *            the file
	 * @return the map
	 */
	static Map<String, String> readFile(File file) {
		Map<String, String> result = new HashMap<>();
		try (FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			String line = bufferedReader.readLine();
			while (line != null) {
				int index = line.indexOf('=');
				if (index >= 0) {
					result.put(line.substring(0, index), line.substring(index + 1));
				}
				line = bufferedReader.readLine();
			}
		} catch (Exception e) {
			// forget it
		}
		return result;
	}

}
