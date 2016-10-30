package Models;

import EndPoint.Interfaces.IEndpoint;
import Enums.EnumTrainRoute;
import Parameters.RouteParameters;

/**
 * Created by sfedo on 10/29/2016.
 */

public class Route extends ModelBase<Route> {

    IEndpoint<Route, RouteParameters> EndPoint;

    private EnumTrainRoute TrainRoute;
    private Iterable<Train> Trains;

    public Route(IEndpoint<Route, RouteParameters> endPoint, EnumTrainRoute trainRoute, Iterable<Train> trains) {
        EndPoint = endPoint;
        TrainRoute = trainRoute;
        Trains = trains;
    }

    public Route()
    {

    }

    public IEndpoint<Route, RouteParameters> getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(IEndpoint<Route, RouteParameters> endPoint) {
        EndPoint = endPoint;
    }

    public EnumTrainRoute getTrainRoute() {
        return TrainRoute;
    }

    public void setTrainRoute(EnumTrainRoute trainRoute) {
        TrainRoute = trainRoute;
    }

    public Iterable<Train> getTrains() {
        return Trains;
    }

    public void setTrains(Iterable<Train> trains) {
        Trains = trains;
    }

    @Override
    public void UpdateWith(Route data)
    {
        TrainRoute = data.getTrainRoute();
        Trains = data.getTrains();
    }
}
