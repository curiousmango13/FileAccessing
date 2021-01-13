import java.io.File;

public class Recursion {

	public static void main(String[] args) {

		// Driver

		// Path to the folder
		String pathToMainFolder = "C:\\Users\\Julia\\Documents\\SoftwareDevelopment2\\Recursion\\MainFolder";

		// Creating object of type File
		File mainFolder = new File(pathToMainFolder);

		if (mainFolder.exists() && mainFolder.isDirectory()) {
			// Creating array for files
			File array[] = mainFolder.listFiles();

			System.out.println("Access granted");
			System.out.println("Main folder is located here: " + mainFolder);
			System.out.println("Storring files in an array and printing it");
			System.out.println(array);

			// method accessing files in folder
			RecursiveAccess(array, 0, 0);
			System.out.println("**************************************************************************************************************************"
					+ "*");
		}

	}

	static void RecursiveAccess(File[] array, int index, int level) {
		// setting condition
		if (index == array.length)
			return;

		// tabs for internal levels within the folder
		for (int i = 0; i < level; i++)
			System.out.print("\t");

		// for files
		if (array[index].isFile())
			System.out.println(array[index].getName());

		// for sub-folders
		else if (array[index].isDirectory()) {
			System.out.println("[" + array[index].getName() + "]");

			// recursion for sub-folders
			RecursiveAccess(array[index].listFiles(), 0, level + 1);
		}

		// recursion for main folder
		RecursiveAccess(array, ++index, level);
		
	}
}
