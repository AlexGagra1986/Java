package ru.MyApps.GetSet;

public class Income {
   public int totalIncome;
   public int taxPercent;
   private int netRevenue;





    public void setCalculate( ) {
       netRevenue = totalIncome-totalIncome*taxPercent/100;


    }

    public int getNetRevenue() {
        return netRevenue;
    }
}
