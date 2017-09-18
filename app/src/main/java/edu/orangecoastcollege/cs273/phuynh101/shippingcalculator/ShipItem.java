package edu.orangecoastcollege.cs273.phuynh101.shippingcalculator;

/**
 * Created by HuynhHuu on 18-Sep-17.
 */

public class ShipItem {
    private int mWeight;
    private double mBase_cost;
    private double mAdded_cost;
    private double mTotal_cost;

    public ShipItem() {
        mWeight = 0;
        mBase_cost = 3.0;
        mAdded_cost = 0.0;
        mTotal_cost = 0.0;
    }

    public int getWeight() {
        return mWeight;
    }

    public double getBase_cost() {
        return mBase_cost;
    }

    public double getAdded_cost() {
        return mAdded_cost;
    }

    public double getTotal_cost() {
        return mTotal_cost;
    }

    public void setWeight(int weight) {
        mWeight = weight;
        updateCosts();
    }

    public void updateCosts()
    {
        if(mWeight <= 16)
            mAdded_cost = 0;
        else
            mAdded_cost = ((mWeight-16)/4 +1) * 0.5;

        mTotal_cost = mBase_cost + mAdded_cost;
    }

}
