package EndPoint.DataSource;

import EndPoint.Interfaces.IDataSource;

/**
 * Created by sfedo on 10/29/2016.
 */
public class RouteDataSource extends DataSourceBase implements IDataSource {

    final static String EndpointAddress = "http://lapi.transitchicago.com/api/1.0/ttpositions.aspx";

    public RouteDataSource()
    {
        super(RouteDataSource.EndpointAddress);
    }

    public void ClearParameters()
    {

    }

    public String Execute() throws Exception
    {
        return super.DownloadContent ();
    }

}
