/*
 * Author: Julia Smith
 * Date: Jan 15, 2021
 * Project overview:
 * program is looking at a folder and its tree of sub-folders,
 * then constructs a tree data structure to represent it. 
 * Each node in the tree corresponds to a folder in the file system, and contains folder's name, and a list of child folders.
 */

import java.io.File;


public class Recursion {

	public static void main(String[] args) {

		// Driver to access given path

		// Path to the folder - can be changed as needed depending on required directory
		String pathToMainFolder = "C:\\Users\\Julia\\Documents\\SoftwareDevelopment2\\Recursion\\MainFolder";

		// Creating object of type File
		File mainFolder = new File(pathToMainFolder);

		//creating variable to store size of the folder
		long folderSize = mainFolder.length();
		
		//setting a condition for recursion
		if (mainFolder.exists() && mainFolder.isDirectory()) {
			
			// Creating array for files
			File array[] = mainFolder.listFiles();

			System.out.println("Requested files are accessed");
			
			System.out.println("Path to main folder : " + mainFolder);
			
			
			System.out.println("Folder size  is : " + folderSize + " bytes" + " or " + (double) folderSize / 1024 + " KB");

			// method accessing files in folder
			RecursiveAccess(array, 0, 0);

		}

	}

	static void RecursiveAccess(File[] array, int index, int level) {
		// setting condition
		if (index == array.length)
			return;

		// creating tabs for sub-levels within the folder
		for (int i = 0; i < level; i++)
			System.out.print("\t");

		// for files within the folder
		if (array[index].isFile())
			System.out.println("-->"+array[index].getName());

		// for sub-folders within the folder
		else if (array[index].isDirectory()) {
			System.out.println("<" + array[index].getName() + ">");

			// recursion for sub-folders
			RecursiveAccess(array[index].listFiles(), 0, level + 1);
		}

		// recursion for main folder
		RecursiveAccess(array, ++index, level);

	}
}