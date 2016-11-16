package project;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Field;

// Temporarily adds to the system environment variables
// Only for dev/testing, do not use on production/release
public class EnvConfig {
	public static void setTmpEnvironment() throws Exception {
		Map<String, String> env = new HashMap<String, String>();
		env.put("KSHIMGPATH", "C:/KSH/img/"); // Path to the image storage location
		env.put("KSHSQL", "jdbc:postgresql://localhost:5432/test"); // Database
		env.put("KSHUSER", "test"); // Database username
		env.put("KSHPASS", "test"); // Database password
		setNewEnvironmentHack(env);
	}

	// http://stackoverflow.com/questions/318239/how-do-i-set-environment-variables-from-java/496849#496849
	@SuppressWarnings("unchecked")
	private static void setNewEnvironmentHack(Map<String, String> newenv) throws Exception
	{
		Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
		Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
		theEnvironmentField.setAccessible(true);
		Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
		env.clear();
		env.putAll(newenv);
		Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
		theCaseInsensitiveEnvironmentField.setAccessible(true);
		Map<String, String> cienv = (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
		cienv.clear();
		cienv.putAll(newenv);
	}
}
