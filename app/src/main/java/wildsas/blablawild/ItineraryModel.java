package wildsas.blablawild;

import java.util.Date;



public class ItineraryModel {

    private int mID;
    private String mDriverLastName;
    private String mDriverFirstName;
    private String mDepartureDate;
    private int mPrice;
    private String mDeparture;
    private String mDestination;


    private ItineraryModel(){

    }

    public ItineraryModel(String departureDate, int price, String departure, String destination){
        mID = 0;
        mDriverLastName = "Cartman";
        mDriverFirstName = "Eric";
        mDepartureDate = departureDate;
        mPrice = price;
        mDeparture = departure;
        mDestination = destination;

    }

    public int getID() {
        return mID;
    }

    public String getDriverLastName() {
        return mDriverLastName;
    }

    public String getDriverFirstName() {
        return mDriverFirstName;
    }

    public String getDepartureDate() {
        return mDepartureDate;
    }

    public int getPrice() {
        return mPrice;
    }

    public String getDeparture() {
        return mDeparture;
    }

    public String getDestination() {
        return mDestination;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public void setDriverLastName(String mDriverLastName) {
        this.mDriverLastName = mDriverLastName;
    }

    public void setDriverFirstName(String mDriverFirstName) {
        this.mDriverFirstName = mDriverFirstName;
    }

    public void setDepartureDate(String mDepartureDate) {
        this.mDepartureDate = mDepartureDate;
    }

    public void setPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public void setmeparture(String mDeparture) {
        this.mDeparture = mDeparture;
    }

    public void setDestination(String mDestination) {
        this.mDestination = mDestination;
    }
}
