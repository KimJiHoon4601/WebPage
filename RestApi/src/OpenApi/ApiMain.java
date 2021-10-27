package OpenApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class ApiMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		DartOpenApi dartApi = new DartOpenApi();
		
		dartApi.setApiKey("78bfa1fd1481205cc8b57f39bdc74164d4e535040");
		dartApi.setStrUtl("https://opendart.fss.or.kr/api/list.json?crtfc_key=78bfa1fd1481205cc8b57f39bdc74164d4e53504&corp_code=009150");
	
		try {
			String line =URLEncoder.encode("string","EUC-KR");
			URL url = new URL(dartApi.getStrUtl());
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
