package Model.AuxStruct;

public class Aeroporto {

    private String abreviation;
    private String timeZoneGMT;
    private Integer xPosition;
    private Integer yPosition;
    private String airportName;

    /**
     *
     * @param abreviation Airport abbreviation
     * @param timeZoneGMT Time Zone (offset from GMT)
     * @param xPosition X coordinate on map
     * @param yPosition Y coordinate on map
     * @param airportName Name of City/Airport
     */
    public Aeroporto(String abreviation, String timeZoneGMT, Integer xPosition, Integer yPosition,
            String airportName) {
        this.abreviation = abreviation;
        this.timeZoneGMT = timeZoneGMT;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.airportName = airportName;
    }

    public Aeroporto() {
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getTimeZoneGMT() {
        return timeZoneGMT;
    }

    public void setTimeZoneGMT(String timeZoneGMT) {
        this.timeZoneGMT = timeZoneGMT;
    }

    public Integer getxPosition() {
        return xPosition;
    }

    public void setxPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Integer getyPosition() {
        return yPosition;
    }

    public void setyPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @Override
    public String toString() {
        return "Aeroporto{" +
                "abreviation='" + abreviation + '\'' +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", airportName='" + airportName + '\'' +
                '}';
    }


}
