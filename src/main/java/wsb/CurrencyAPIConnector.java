package wsb;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;

public class CurrencyAPIConnector extends APIConnector{
    public static final String API_KEY = "582939e0-9d50-11ec-af65-17fd6d4112cb";
    public static final String URL_ADDRESS = "https://freecurrencyapi.net/api/v3/";
    public static final String LATEST = "latest";
    public static final String HISTORICAL = "historical";

    public JSONObject getLatestData(){
        String data = getData(URL_ADDRESS + LATEST,API_KEY, null);
        JSONTokener tokener = new JSONTokener(data);

        return new JSONObject(tokener);
    }

    public JSONObject getHistoricalData(String baseCurrency, String date){ //todo: change to datetime
        Map<String, String> parameters = new HashMap<>();
        parameters.put("base_currency",baseCurrency);
        parameters.put("date", date);

        String data = getData(URL_ADDRESS+HISTORICAL,API_KEY, parameters);
        JSONTokener tokener = new JSONTokener(data);

        return new JSONObject(tokener);

    }
}
