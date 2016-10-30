package Parameters;

import java.util.Optional;

/**
 * Created by sfedo on 10/29/2016.
 */
public class ArrivalsParameters {

//
//    public ArrivalsParameters(Integer numericStationIdentifier, Integer numericStopIdentifier, int maximumResults, String routeCode) {
//        NumericStationIdentifier = numericStationIdentifier;
//        NumericStopIdentifier = numericStopIdentifier;
//        MaximumResults = maximumResults;
//        RouteCode = routeCode;
//    }

    public Integer getNumericStationIdentifier()
    {
        return this.NumericStationIdentifier;
    }

    public Integer getNumericStopIdentifier()
    {
        return this.NumericStopIdentifier;
    }

    public Integer getMaximumResults() {
        return MaximumResults;
    }

    public void setNumericStationIdentifier(Integer numericStationIdentifier) {
        NumericStationIdentifier = numericStationIdentifier;
    }

    public void setNumericStopIdentifier(Integer numericStopIdentifier) {
        NumericStopIdentifier = numericStopIdentifier;
    }

    public void setMaximumResults(Integer maximumResults) {
        MaximumResults = maximumResults;
    }

    public void setRouteCode(String routeCode) {
        RouteCode = routeCode;
    }

    public String getRouteCode() {
        return RouteCode;
    }

    private Integer NumericStationIdentifier;
    private Integer NumericStopIdentifier;
    private Integer MaximumResults;
    private String RouteCode;

}
