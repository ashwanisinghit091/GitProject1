package DataResources;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JasonDataFile {
	
	
	
	
	
	public static List<HashMap<String, String>> getData() throws IOException {
		
	String JasonContent=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/src/main/java/DataResources/DataFile.jason"),StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=	mapper.readValue(JasonContent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
	
	
	
	

}
