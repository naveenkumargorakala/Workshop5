package com.bridgelabz;

import java.util.Calendar;
import java.util.Date;

public class MiamiHotels {
    private String name;
    private int rate;
    private int weekDayRateReg;
    private int weekDayRateRward;
    private int weekendRateReg;
    private int weekendRateReward;

    public MiamiHotels(String name, int rate, int weekDayRateReg, int weekDayRateRward, int weekendRateReg, int weekendRateReward) {
        this.name = name;
        this.rate = rate;
        this.weekDayRateReg = weekDayRateReg;
        this.weekDayRateRward = weekDayRateRward;
        this.weekendRateReg = weekendRateReg;
        this.weekendRateReward = weekendRateReward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        int workDays = 0;

        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            //excluding start date
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                ++workDays;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date

        return workDays;
    }


    public static int getWeekendDaysBetweenTwoDates(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        int weekEndDays = 0;

        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            //excluding start date
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                ++weekEndDays;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date

        return weekEndDays;
    }


    boolean isRewardCustomer=true;
    public int getCost(int reward){
        int totalCost=0;
        if(isRewardCustomer)
            totalCost+=((weekDayRateRward*getWorkingDaysBetweenTwoDates(12/12/2022 ,2022/12/30))+(weekendRateReward*getWeekendDaysBetweenTwoDates(2022/12/12,2022/12/30)));
        else
            totalCost+=((weekDayRateReg*getWorkingDaysBetweenTwoDates(2022/12/12,2022/12/30))+(weekendRateReg*getWeekendDaysBetweenTwoDates(2022/12/12,2022/12/30)));

        return totalCost;

//    LocalDate date1 = LocalDate.of(year, month, day);
//    DayOfWeek dayOfWeek = date1.getDayOfWeek();
//    int dayofWeekValue = dayOfWeek.getValue();// 1 for monday 2 for tuesday ......
//        return dayofWeekValue;
    }
}
