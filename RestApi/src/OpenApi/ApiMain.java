package OpenApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DartOpenApi dartApi = new DartOpenApi();
		
		dartApi.setApiKey("78bfa1fd1481205cc8b57f39bdc74164d4e535040");
		dartApi.setCorpCode("009150");
		dartApi.setStrUtl("https://opendart.fss.or.kr/api/list.json?corp_code=009150&crtfc_key=78bfa1fd1481205cc8b57f39bdc74164d4e53504");
		
		
		try {
			String line =URLEncoder.encode("string","UTF-8");
			String JsonData = "";
			URL url = new URL(dartApi.getStrUtl());
			BufferedReader br ;
			
			br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			
			while ((line = br.readLine()) != null) {
				JsonData = JsonData + line;
			}
			System.out.println(JsonData);
			
			
			/* Json 파싱 */
			JSONParser jsonParse = new JSONParser();

			//JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
			JSONObject jsonObj = (JSONObject) jsonParse.parse(JsonData);

			JSONArray noticeList = (JSONArray) jsonObj.get("list");

			for(int i=0; i < noticeList.size(); i++) { 
				System.out.println("======== person : " + i + " ========"); 
				JSONObject noticeObject = (JSONObject) noticeList.get(i); 
				System.out.println(noticeObject.get("corp_name")); 
				System.out.println(noticeObject.get("corp_code")); 
				System.out.println(noticeObject.get("report_nm"));
				System.out.println(noticeObject.get("rcept_dt"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
 
}
