import java.io.*;
import java.net.*;
import org.json.*;

public class clientREST{
    public static void main(String[] args){
        try{
            getREST();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void getREST() throws Exception{
        String url = "YOUR API ADDRESS";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("Send Get Request to : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream())
        );
        String input;
        StringBuffer response = new StringBuffer();
        while ((input=in.readLine())!=null){
            response.append(input);
        }
        in.close();
        System.out.println("Data : \n" +response.toString());

        JSONArray myArray = new JSONArray(response.toString());
        for (int i=0; i < myArray.length();i++){
            JSONObject arrObj = myArray.getJSONObject(i);
            System.out.println("Data Title : ");
            System.out.println(arrObj.getString("title"));
        }
    }
}