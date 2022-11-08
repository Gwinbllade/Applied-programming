package tariff;

public class Tariff {
    int ID;
    String name;
    int subscriptionFee;
    int minutesByOperator;
    int minunesOtherOperators;
    int SMS;
    int mobileData;
    int  priceAdditionalMinute;

    public Tariff() {

    }

    int priceAdditionalSMS;
    int priceAdditionalMB;
    String specialCondition;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(int subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public int getMinutesByOperator() {
        return minutesByOperator;
    }

    public void setMinutesByOperator(int minutesByOperator) {
        this.minutesByOperator = minutesByOperator;
    }

    public int getMinunesOtherOperators() {
        return minunesOtherOperators;
    }

    public void setMinunesOtherOperators(int minunesOtherOperators) {
        this.minunesOtherOperators = minunesOtherOperators;
    }

    public int getSMS() {
        return SMS;
    }

    public void setSMS(int SMS) {
        this.SMS = SMS;
    }

    public int getMobileData() {
        return mobileData;
    }

    public void setMobileData(int mobileData) {
        this.mobileData = mobileData;
    }

    public int getPriceAdditionalMinute() {
        return priceAdditionalMinute;
    }

    public void setPriceAdditionalMinute(int priceAdditionalMinute) {
        this.priceAdditionalMinute = priceAdditionalMinute;
    }

    public int getPriceAdditionalSMS() {
        return priceAdditionalSMS;
    }

    public void setPriceAdditionalSMS(int priceAdditionalSMS) {
        this.priceAdditionalSMS = priceAdditionalSMS;
    }

    public int getPriceAdditionalMB() {
        return priceAdditionalMB;
    }

    public void setPriceAdditionalMB(int priceAdditionalMB) {
        this.priceAdditionalMB = priceAdditionalMB;
    }

    public String getSpecialCondition() {
        return specialCondition;
    }

    public void setSpecialCondition(String specialCondition) {
        this.specialCondition = specialCondition;
    }




    public Tariff(int ID, String name, int subscriptionFee, int minutesByOperator, int minunesOtherOperators, int SMS, int mobileData, int priceAdditionalMinute, int priceAdditionalSMS, int priceAdditionalMB, String specialCondition) {
        this.ID = ID;
        this.name = name;
        this.subscriptionFee = subscriptionFee;
        this.minutesByOperator = minutesByOperator;
        this.minunesOtherOperators = minunesOtherOperators;
        this.SMS = SMS;
        this.mobileData = mobileData;
        this.priceAdditionalMinute = priceAdditionalMinute;
        this.priceAdditionalSMS = priceAdditionalSMS;
        this.priceAdditionalMB = priceAdditionalMB;
        this.specialCondition = specialCondition;
    }
}
