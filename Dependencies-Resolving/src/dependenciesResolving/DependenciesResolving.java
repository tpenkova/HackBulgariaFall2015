package dependenciesResolving;


import java.util.Arrays;

import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DependenciesResolving {

	static void install(JSONArray dependenciesArray) throws Exception {
		List<Object> dependencies = JSONManager.toList(dependenciesArray);
		JSONObject allPackages = FileManager.getAllPackages();

		for (Object dependency : dependencies) {

			List<String> installedPackages = Arrays.asList(FileManager
					.getInstalledPackages());
			if (installedPackages.contains(dependency)) {
				String packageName = dependency.toString();
				System.out.println(packageName + " is already installed.");
				continue;
			}

			System.out.println("Installing " + dependency + ".");
			FileManager.installPackage(dependency.toString());

			JSONArray linkedDependenciesArray = (JSONArray) allPackages
					.get(dependency);

			List<Object> linkedDependencies = JSONManager.toList(linkedDependenciesArray);
			if (linkedDependencies.size() > 0) {
				String message = "In order to install " + dependency
						+ ", we need ";
				for (int i = 0; i < linkedDependencies.size(); i++) {
					message += linkedDependencies.get(i);

					if (i + 1 < linkedDependencies.size()) {
						message += " and ";
					} else {
						message += ".";
					}
				}

				System.out.println(message);
				install(linkedDependenciesArray);
			}
		}
	}
}
