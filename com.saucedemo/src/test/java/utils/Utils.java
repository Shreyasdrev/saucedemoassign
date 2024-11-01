package utils;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Utils {
	
	 private String username;
	    private String password;

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String email) {
	        this.username = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    //getting user credentials from JSON.
	    public void getUserCreds(int pos) throws IOException, ParseException {
	        String fileName="./src/test/resources/users.json";
	        JSONParser jsonParser=new JSONParser();
	        Object obj=jsonParser.parse(new FileReader(fileName));
	        JSONArray jsonArray=(JSONArray) obj;
	        JSONObject jsonObject=(JSONObject) jsonArray.get(pos);
	        setUsername((String)jsonObject.get("username"));
	        setPassword((String)jsonObject.get("password"));
	    }
	    //getting user count from JSONArray.
	    public int getUserCount() throws IOException, ParseException {
	        String fileName="./src/test/resources/users.json";
	        JSONParser jsonParser=new JSONParser();
	        Object obj=jsonParser.parse(new FileReader(fileName));
	        JSONArray jsonArray=(JSONArray) obj;
	        return jsonArray.size()-1;
	    }
	    
	    public void takeScreenshot(WebDriver driver) throws IOException {
	        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        String time=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
	        String fileWithPath="./src/test/resources/screenshots/"+time+".png";
	        File DestFile= new File(fileWithPath);
	        FileUtils.copyFile(screenshotFile,DestFile);
	    }
	

}
