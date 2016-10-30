package Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by sfedo on 10/29/2016.
 */
public class Train extends ModelBase<Train>
{
    public Models.Route getRoute() {
        return Route;
    }

    public void setRoute(Models.Route route) {
        Route = route;
    }

    public Integer getRunNumber() {
        return RunNumber;
    }

    public void setRunNumber(Integer runNumber) {
        RunNumber = runNumber;
    }

    public Integer getDestinationStopNumber() {
        return DestinationStopNumber;
    }

    public void setDestinationStopNumber(Integer destinationStopNumber) {
        DestinationStopNumber = destinationStopNumber;
    }

    public int getTrainDirection() {
        return TrainDirection;
    }

    public void setTrainDirection(int trainDirection) {
        TrainDirection = trainDirection;
    }

    public String getDestinationName() {
        return DestinationName;
    }

    public void setDestinationName(String destinationName) {
        DestinationName = destinationName;
    }

    public int getNextStationID() {
        return NextStationID;
    }

    public void setNextStationID(int nextStationID) {
        NextStationID = nextStationID;
    }

    public int getNextStopID() {
        return NextStopID;
    }

    public void setNextStopID(int nextStopID) {
        NextStopID = nextStopID;
    }

    public String getNextStationName() {
        return NextStationName;
    }

    public void setNextStationName(String nextStationName) {
        NextStationName = nextStationName;
    }

    public LocalDateTime getPredicationGeneratedTime() {
        return PredicationGeneratedTime;
    }

    public void setPredicationGeneratedTime(LocalDateTime predicationGeneratedTime) {
        PredicationGeneratedTime = predicationGeneratedTime;
    }

    public LocalDateTime getPredicatedArrival() {
        return PredicatedArrival;
    }

    public void setPredicatedArrival(LocalDateTime predicatedArrival) {
        PredicatedArrival = predicatedArrival;
    }

    public boolean isApproaching() {
        return IsApproaching;
    }

    public void setApproaching(boolean approaching) {
        IsApproaching = approaching;
    }

    public boolean isDelayed() {
        return IsDelayed;
    }

    public void setDelayed(boolean delayed) {
        IsDelayed = delayed;
    }

    public String getFlags() {
        return Flags;
    }

    public void setFlags(String flags) {
        Flags = flags;
    }

    public BigDecimal getTrainLatitude() {
        return TrainLatitude;
    }

    public void setTrainLatitude(BigDecimal trainLatitude) {
        TrainLatitude = trainLatitude;
    }

    public BigDecimal getTrainLongitude() {
        return TrainLongitude;
    }

    public void setTrainLongitude(BigDecimal trainLongitude) {
        TrainLongitude = trainLongitude;
    }

    public int getHeadingDegrees() {
        return HeadingDegrees;
    }

    public void setHeadingDegrees(int headingDegrees) {
        HeadingDegrees = headingDegrees;
    }

    private Route Route;
    private Integer RunNumber;
    private Integer DestinationStopNumber;
    private int TrainDirection;
    private String DestinationName;
    private int NextStationID;
    private int NextStopID;
    private String NextStationName;
    private LocalDateTime PredicationGeneratedTime;
    private LocalDateTime PredicatedArrival;
    private boolean IsApproaching;
    private boolean IsDelayed;
    private String Flags;
    private BigDecimal TrainLatitude;
    private BigDecimal TrainLongitude;
    private int HeadingDegrees;

    @Override
    public void UpdateWith (Train obj)
    {
        this.setUpdatedTime(LocalDateTime.now());

        this.Route = obj.Route;
        this.RunNumber = obj.RunNumber;
        this.DestinationStopNumber = obj.DestinationStopNumber;
        this.TrainDirection = obj.TrainDirection;
        this.DestinationName = obj.DestinationName;
        this.NextStationID = obj.NextStationID;
        this.NextStopID = obj.NextStopID;
        this.NextStationName = obj.NextStationName;
        this.PredicationGeneratedTime = obj.PredicationGeneratedTime;
        this.PredicatedArrival = obj.PredicatedArrival;
        this.IsApproaching = obj.IsApproaching;
        this.IsDelayed = obj.IsDelayed;
        this.Flags = obj.Flags;
        this.TrainLatitude = obj.TrainLatitude;
        this.TrainLongitude = obj.TrainLongitude;
        this.HeadingDegrees = obj.HeadingDegrees;
    }
}

