import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class WordsPackage {

	// Instance Variables

	private final String path = "C:\\Users\\Omer-PC\\git\\Fastest-Sorting-Algorithm-Java-App\\Strings";
	private final String resultsPath = "C:\\Sorting Results"; 
	private String packageType;

	private String[] words1m; 
	private String[] words50k;
	private String[] words250k;
	private  String[] words500k;

	// Constructor

	public WordsPackage(String directoryName) {
		packageType = directoryName;

		words1m = new String[1000000];
		words500k = new String[500000];
		words250k = new String[250000];
		words50k = new String[50000];

		loadFilesFromDirectory();
	}

	// Getters

	public String[] get50kArray() {
		return this.words50k;
	}

	public String[] get250kArray() {
		return this.words250k;
	}

	public String[] get500kArray() {
		return this.words500k;
	}

	public String[] get1mArray() {
		return this.words1m;
	}

	public String getPackageType() {
		return this.packageType;
	}

	// Setters

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	/* This function purpose is to 
	 * determine which sorting algorithm 
	 * was given by the main class.
	 * According to the right sorting 
	 * algorithm package Type the switch 
	 * case then navigate in order 
	 * to find the right file size containing 
	 * right amount of strings values
	 * within it.
	 */

	private void loadFilesFromDirectory() {
		File folder = new File(path + packageType);
		File[] listOfFiles = folder.listFiles(); // A list of files with different type of sorting algorithm

		String startWith[] = {"1m", "250k", "500k", "50k"};
		int i = 0; String name = "";

		for (File file : listOfFiles) {
			while(i < listOfFiles.length) {
				name = startWith[i ++];
				break;
			}
			switch (name) {
			case "1m" : {
				loadTxtFromFile(file, words1m); // a file with 1m Strings
				break;
			}
			case "500k" : {
				loadTxtFromFile(file, words500k); // a file with 500k Strings
				break;
			}
			case "250k" : {
				loadTxtFromFile(file, words250k); // a file with 250k Strings
				break;
			}
			case "50k": {
				loadTxtFromFile(file, words50k); // a file with 50k Strings
				break;
			}
			default:
				break;
			}
		}
	}

	// Read File

	private void loadTxtFromFile(File file, String[] arr) {
		BufferedReader br;
		try {
			br = new  BufferedReader(new FileReader(file));

			int i = 0;
			String st; 

			while ((st = br.readLine()) != null) 
				arr[i++] = st;

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Write File Out

	public void writeResultsToFile(String resultOutput) {
		PrintWriter out = null;
		try {

			// Temporary file is being created 

			String filePath = resultsPath + packageType + ".txt";

			File resultsFile = new File(filePath);          

			if ( resultsFile.exists() && !resultsFile.isDirectory() ) {
				out = new PrintWriter(new FileOutputStream(new File(filePath), true));
			}
			else {
				out = new PrintWriter(filePath);
			}
			out.append(resultOutput);

			System.out.println("Successful!");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			
			out.close(); // Writer is terminated no matter what.
		} 
	}
}	
