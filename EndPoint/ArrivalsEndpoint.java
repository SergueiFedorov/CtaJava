package EndPoint;

import EndPoint.Converters.XMLToETAConverter;
import EndPoint.DataSource.ArrivalsDataSource;
import EndPoint.DataSource.ETADataSource;
import EndPoint.Interfaces.IDataSource;
import EndPoint.Interfaces.IEndpoint;
import EndPoint.Interfaces.IXmlConverter;
import Models.ETA;
import Parameters.ArrivalsParameters;

import java.util.Collection;

/**
 * Created by sfedo on 10/29/2016.
 */
public class ArrivalsEndpoint implements IEndpoint<ETA, ArrivalsParameters> {

    private String APIKey;
    private IDataSource dataSource;
    private IXmlConverter<ETA> converter;

    public ArrivalsEndpoint(String APIKey, IXmlConverter<ETA> converter, IDataSource dataSource)
    {
        this.APIKey = APIKey;
        this.converter = converter;
        this.dataSource = dataSource;
    }

    public ArrivalsEndpoint(String APIKey)
    {
        this.APIKey = APIKey;
        this.converter = new XMLToETAConverter();
        this.dataSource = new ArrivalsDataSource();
    }

    @Override
    public Collection<ETA> Get(ArrivalsParameters arrivalsParameters) throws Exception {
        this.dataSource.AddParameter ("key", this.APIKey);

        dataSource.AddParameter("mapid", arrivalsParameters.getNumericStationIdentifier());
        dataSource.AddParameter("stpid", arrivalsParameters.getNumericStopIdentifier());
        dataSource.AddParameter("max", arrivalsParameters.getMaximumResults());
        dataSource.AddParameter("rt", arrivalsParameters.getRouteCode());

        String data = dataSource.Execute();
        return this.converter.Convert (data, "ctatt");
    }
}
