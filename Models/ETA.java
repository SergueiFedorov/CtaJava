package Models;

import Enums.EnumTrainRoute;

import java.time.LocalDateTime;

/**
 * Created by sfedo on 10/29/2016.
 */
public class ETA<ModelBase> {

    public void setStationID(int stationID) {
        StationID = stationID;
    }

    public void setStopID(int stopID) {
        StopID = stopID;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public void setStationDescription(String stationDescription) {
        StationDescription = stationDescription;
    }

    public void setRunNumber(int runNumber) {
        RunNumber = runNumber;
    }

    public void setRouteName(String routeName) {
        RouteName = routeName;
    }

    public void setDestinationStationID(int destinationStationID) {
        DestinationStationID = destinationStationID;
    }

    public void setDestinationName(String destinationName) {
        DestinationName = destinationName;
    }

    public void setRouteDirectionCode(int routeDirectionCode) {
        RouteDirectionCode = routeDirectionCode;
    }

    public void setPredicationGeneratedTime(LocalDateTime predicationGeneratedTime) {
        PredicationGeneratedTime = predicationGeneratedTime;
    }

    public void setPredicatedArrival(LocalDateTime predicatedArrival) {
        PredicatedArrival = predicatedArrival;
    }

    public void setApproaching(boolean approaching) {
        IsApproaching = approaching;
    }

    public void setLivePrediction(boolean livePrediction) {
        IsLivePrediction = livePrediction;
    }

    public void setDelayed(boolean delayed) {
        IsDelayed = delayed;
    }

    public void setFaultDetected(boolean faultDetected) {
        IsFaultDetected = faultDetected;
    }

    public void setFlags(String flags) {
        Flags = flags;
    }

    public void setRoute(EnumTrainRoute route) {
        Route = route;
    }

    public ETA() {

    }

    public int getStationID() {
        return StationID;
    }

    public int getStopID() {
        return StopID;
    }

    public String getStationName() {
        return StationName;
    }

    public String getStationDescription() {
        return StationDescription;
    }

    public int getRunNumber() {
        return RunNumber;
    }

    public String getRouteName() {
        return RouteName;
    }

    public int getDestinationStationID() {
        return DestinationStationID;
    }

    public String getDestinationName() {
        return DestinationName;
    }

    public int getRouteDirectionCode() {
        return RouteDirectionCode;
    }

    public LocalDateTime getPredicationGeneratedTime() {
        return PredicationGeneratedTime;
    }

    public LocalDateTime getPredicatedArrival() {
        return PredicatedArrival;
    }

    public boolean isApproaching() {
        return IsApproaching;
    }

    public boolean isLivePrediction() {
        return IsLivePrediction;
    }

    public boolean isDelayed() {
        return IsDelayed;
    }

    public boolean isFaultDetected() {
        return IsFaultDetected;
    }

    public String getFlags() {
        return Flags;
    }

    public EnumTrainRoute getRoute() {
        return Route;
    }

    private int StationID;
    private int StopID;
    private String StationName;
    private String StationDescription;
    private int RunNumber;
    private String RouteName;
    private int DestinationStationID;
    private String DestinationName;
    private int RouteDirectionCode;
    private LocalDateTime PredicationGeneratedTime;
    private LocalDateTime PredicatedArrival;
    private boolean IsApproaching;
    private boolean IsLivePrediction;
    private boolean IsDelayed;
    private boolean IsFaultDetected;
    private String Flags;
    private EnumTrainRoute Route;
}
