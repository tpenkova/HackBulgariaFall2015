package dependenciesResolving;

import org.json.simple.JSONArray;

public class Main {

	public static void main(String[] args) throws Exception {
		
		JSONArray dependenciesList = (JSONArray) FileManager.getInitialDependencies()
				.get("dependencies");

		DependenciesResolving.install(dependenciesList);
		System.out.println("All is done.");

	}
}
