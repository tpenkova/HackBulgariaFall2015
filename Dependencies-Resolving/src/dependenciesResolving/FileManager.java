package dependenciesResolving;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileManager {
	public static String PATH = "C:/Users/Tanya/Desktop/Dependencies/";

	static JSONObject getAllPackages() throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObjectPackages = null;

		try {
			Object objPackages = parser.parse(new FileReader(PATH
					+ "all_packages.json"));

			jsonObjectPackages = (JSONObject) objPackages;
		} catch (Exception e) {
			System.out.println("Can't read all_packages.json file");
			throw e;
		}

		return jsonObjectPackages;
	}
	
	static JSONObject getInitialDependencies() throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObjDependencies = null;
		
		try {
			Object objDependencies = parser.parse(new FileReader(PATH
					+ "dependencies.json"));
	
			jsonObjDependencies = (JSONObject) objDependencies;
		}
		catch(Exception e) {
			System.out.println("Can't read dependencies.json file");
			throw e;
		}
		return jsonObjDependencies;
	}

	static String[] getInstalledPackages() {
		File dir = new File(PATH + "installed_modules");
		String[] files = dir.list();
		return files;
	}

	static void installPackage(String name) {
		File dir = new File(PATH + "installed_modules/" + name);
		dir.mkdir();
	}
}
