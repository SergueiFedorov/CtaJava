import EndPoint.ArrivalsEndpoint;
import EndPoint.ETAEndPoint;
import EndPoint.Interfaces.IEndpoint;
import EndPoint.RouteEndPoint;
import Enums.EnumTrainRoute;
import Models.ETA;
import Models.Route;
import Parameters.ArrivalsParameters;
import Parameters.ETAParameters;
import Parameters.RouteParameters;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by sfedo on 10/29/2016.
 */
public class CtaTrainTracker {
    private IEndpoint<Route, RouteParameters> routeEnpoint;
    private IEndpoint<ETA, ETAParameters> etaEndpoint;
    private IEndpoint<ETA, ArrivalsParameters> arrivalsEnpoint;

    public CtaTrainTracker(String APIKey) {
        this(new RouteEndPoint(APIKey), new ETAEndPoint(APIKey), new ArrivalsEndpoint(APIKey));
    }

    public CtaTrainTracker(
            IEndpoint<Route, RouteParameters> routeEnpoint,
            IEndpoint<ETA, ETAParameters> etaEndpoint,
            IEndpoint<ETA, ArrivalsParameters> arrivalsEnpoint) {
        this.routeEnpoint = routeEnpoint;
        this.etaEndpoint = etaEndpoint;
        this.arrivalsEnpoint = arrivalsEnpoint;
    }

    public Route GetRoute(EnumTrainRoute route) throws Exception
    {
        RouteParameters parameters = new RouteParameters();
        parameters.setRoute(route);

        Collection<Route> result = routeEnpoint.Get(parameters);
        if (!result.isEmpty())
        {
            return result.iterator().next();
        }

        return null;
    }

    public Collection<ETA> GetArrivalTimesByRunNumber(int runNumber) throws Exception
    {
        ETAParameters parameters = new ETAParameters();
        parameters.setRunNumber(runNumber);

        return etaEndpoint.Get(parameters);
    }

    public Collection<ETA> GetArrivalTimeByStopID(int stopID) throws Exception
    {
        ArrivalsParameters parameters = new ArrivalsParameters();
        parameters.setNumericStopIdentifier(stopID);

        return arrivalsEnpoint.Get(parameters);
    }
}
