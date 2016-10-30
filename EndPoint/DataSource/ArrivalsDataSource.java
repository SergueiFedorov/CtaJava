package EndPoint.DataSource;

import EndPoint.Interfaces.IDataSource;

/**
 * Created by sfedo on 10/29/2016.
 */
public class ArrivalsDataSource extends DataSourceBase implements IDataSource {

    final static String EndpointAddress = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx";

    public ArrivalsDataSource()
    {
        super(ArrivalsDataSource.EndpointAddress);
    }

    public void ClearParameters()
    {

    }

    public String Execute() throws Exception
    {
        return super.DownloadContent ();
    }

}
