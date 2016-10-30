package EndPoint;

import EndPoint.Converters.XMLToETAConverter;
import EndPoint.DataSource.ETADataSource;
import EndPoint.Interfaces.IDataSource;
import EndPoint.Interfaces.IEndpoint;
import EndPoint.Interfaces.IXmlConverter;
import Models.ETA;
import Parameters.ETAParameters;

import java.util.Collection;

public class ETAEndPoint implements IEndpoint<ETA, ETAParameters> {

    public ETAEndPoint(IXmlConverter<ETA> converter, IDataSource dataSource, String APIKey) {
        this.converter = converter;
        this.dataSource = dataSource;
        this.APIKey = APIKey;
    }

    public ETAEndPoint(String APIKey) {
        this.converter = new XMLToETAConverter();
        this.dataSource = new ETADataSource();
        this.APIKey = APIKey;
    }

    private IXmlConverter<ETA> converter;
    private IDataSource dataSource;
    private String APIKey;

    @Override
    public Collection<ETA> Get(ETAParameters etaParameters) throws Exception {
        dataSource.AddParameter("runnumber", etaParameters.getRunNumber().toString());
        dataSource.AddParameter ("key", APIKey);

        String data = dataSource.Execute();
        return converter.Convert(data, "ctatt");
    }
}
