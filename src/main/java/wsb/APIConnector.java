package wsb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class APIConnector {

    public String getData(String URL, String apiKey, Map<String, String> parameters) {
        StringBuilder urlString = new StringBuilder(URL + "?");
        if (apiKey != null) {
            urlString.append("apikey=").append(apiKey);
        }
        if (parameters != null) {
            for(String key : parameters.keySet()){
                urlString.append("&").append(key).append("=").append(parameters.get(key));
            }
        }

        try {
            URL requestAddress = new URL(urlString.toString());

            String readLine;
            HttpURLConnection connection = (HttpURLConnection) requestAddress.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer response = new StringBuffer();

                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }

                in.close();
                return response.toString();
            } else {
                System.out.println("response code: " + responseCode);
                throw new Exception("Error in API Call");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; //todo: add errors management
    }
}
