package GeericLiraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/*
	 * ReaddatafromPropertyfile
	 * @author hpaut
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readdatafromPropertyfile(String key) throws IOException
{
	FileInputStream fis = new FileInputStream(IPathCostats.filePath);
	Properties pOj = new Properties();
	pOj.load(fis);
	String value = pOj.getProperty(key);
	return value;
	
}
}
