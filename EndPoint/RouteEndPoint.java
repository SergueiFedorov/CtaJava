package EndPoint;

import EndPoint.Converters.XMLToRouteConverter;
import EndPoint.DataSource.RouteDataSource;
import EndPoint.Interfaces.IDataSource;
import EndPoint.Interfaces.IEndpoint;
import EndPoint.Interfaces.IXmlConverter;
import Models.Route;
import Parameters.RouteParameters;
import Tools.RouteHelper;

import java.util.Collection;

/**
 * Created by sfedo on 10/29/2016.
 */
public class RouteEndPoint implements IEndpoint<Route, RouteParameters> {

    private IXmlConverter<Route> routeConverter;
    private IDataSource routeDataSource;
    private String APIKey;

    public RouteEndPoint(IXmlConverter<Route> routeConverter, IDataSource routeDataSource, String APIKey) {
        this.routeConverter = routeConverter;
        this.routeDataSource = routeDataSource;
        this.APIKey = APIKey;
    }

    public RouteEndPoint(String APIKey) {
        routeDataSource = new RouteDataSource();
        routeConverter = new XMLToRouteConverter();
        this.APIKey = APIKey;
    }

    @Override
    public Collection<Route> Get(RouteParameters routeParameters) throws Exception {
        String routeName = RouteHelper.GetTrainRouteString(routeParameters.getRoute());
        routeDataSource.AddParameter("rt", routeName);
        routeDataSource.AddParameter ("key", APIKey);

        String data = routeDataSource.Execute();
        Collection<Route> route = routeConverter.Convert(data, "ctatt");

        route.forEach(x -> x.setEndPoint(this));

        return route;
    }
}
