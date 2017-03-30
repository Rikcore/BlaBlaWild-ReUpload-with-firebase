package wildsas.blablawild;

import java.util.Date;



public class ItineraryModel {

    private String mID;
    private String mDriverLastName;
    private String mDriverFirstName;
    private String mDepartureDate;
    private int mPrice;
    private String mDeparture;
    private String mDestination;


    private ItineraryModel(){

    }

    public ItineraryModel(String departureDate, int price, String departure, String destination, String Id){
        mDepartureDate = departureDate;
        mPrice = price;
        mDeparture = departure;
        mDestination = destination;
        mID = Id;
        mDriverLastName = "Cartman";
        mDriverFirstName = "Eric";




    }

    public String getID() {
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

    public void setID(String mID) {
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
