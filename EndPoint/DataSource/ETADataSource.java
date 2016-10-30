package EndPoint.DataSource;

import EndPoint.Interfaces.IDataSource;

/**
 * Created by sfedo on 10/29/2016.
 */
public class ETADataSource extends DataSourceBase implements IDataSource {

    final static String EndpointAddress = "http://lapi.transitchicago.com/api/1.0/ttfollow.aspx";

    public ETADataSource()
    {
        super(ETADataSource.EndpointAddress);
    }

    public void ClearParameters()
    {

    }

    public String Execute() throws Exception
    {
        return super.DownloadContent ();
    }

}
