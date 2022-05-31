import java.io.*;
import java.net.*;
import org.json.*;

public class clientRESTPostExample{
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
        con.setRequestMethod("POST"); //PUT / DELETE
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.connect();
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("PARAM", "VALUE");


        System.out.println(jsonParam.toString());

        byte[] jsData = jsonParam.toString().getBytes("UTF-8");
        OutputStream os = con.getOutputStream();
        os.write(jsData);
        
        int responseCode = con.getResponseCode();
        System.out.println("Send Get Request to : " + url);
        System.out.println("Response Code : " + responseCode);

        os.flush();
        os.close();
    }
}