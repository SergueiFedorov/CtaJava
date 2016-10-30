package Parameters;

import Enums.EnumTrainRoute;

/**
 * Created by sfedo on 10/29/2016.
 */
public class RouteParameters {

    private EnumTrainRoute route;

    public RouteParameters()
    {

    }

    public void setRoute(EnumTrainRoute route) {
        this.route = route;
    }

    public EnumTrainRoute getRoute()
    {
        return route;
    }

}
