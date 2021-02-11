package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileOperation {

	Properties prop;

	public PropertyFileOperation(String filePath) throws IOException {
		File file = new File(filePath);
		FileInputStream input = new FileInputStream(file);
		prop = new Properties();
		prop.load(input);
	}

	public String readProperty(String key) {
		String value = prop.getProperty(key);
		return value;
	}

}
