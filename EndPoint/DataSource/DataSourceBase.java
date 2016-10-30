package EndPoint.DataSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by sfedo on 10/29/2016.
 */
public abstract class DataSourceBase {

//    protected HttpURLConnection client;
    private String url;
    private Map<String, String> parameters = new HashMap<>();

    protected DataSourceBase(String url)
    {
        this.url = url;
    }

    private String buildParameterString(Map<String, String> values)
    {
        List<String> paramItems = new ArrayList<>();
        for (Map.Entry<String, String> item : values.entrySet())
        {
            paramItems.add(0, item.getKey() + "=" + item.getValue());
        }
        return String.join("&", paramItems);
    }

    protected String DownloadContent() throws Exception
    {
        String parameterString = buildParameterString(this.parameters);
        URL connection_url = new URL(url + "?" + parameterString);

        HttpURLConnection connection = (HttpURLConnection)connection_url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder buffer = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null)
        {
            buffer.append(line);
        }

        reader.close();
        connection.disconnect();

        return buffer.toString();
    }

    public void AddParameter(String name, Object value)
    {
        if (value == null)
        {
            parameters.put(name, "");
        }
        else {
            parameters.put(name, value.toString());
        }
    }

    public void ClearParameters()
    {
        parameters.clear();
    }
}
