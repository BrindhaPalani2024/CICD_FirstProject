package Brindha.Maven_Project.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.io.FileUtils;

public class DataReader {
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//Reading Json to String
		String JsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Brindha\\Maven_Project\\Data\\Purchaseorder.json"),StandardCharsets.UTF_8);
	
		//String to JSon
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(JsonContent,new TypeReference <List <HashMap<String,String>>>()
				{});
		return data;
		}

}
