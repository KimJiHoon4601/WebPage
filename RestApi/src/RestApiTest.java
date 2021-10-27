import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.sound.sampled.Line;

public class RestApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Api Test");
		
		String urlStr = "http://118.40.1.174:8080/replies/pages/2/1.json";
		String line ="";
		
		try {
			URL url = new URL(urlStr);
			BufferedReader br ;
			
			
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
