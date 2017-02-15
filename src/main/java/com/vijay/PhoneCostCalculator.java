package com.vijay;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vijay on 2/9/2017.
 */
public class PhoneCostCalculator {
    public int getTotalCost(String inputString) {

        if(inputString == null || StringUtils.isBlank(inputString))
            return 0;

//        00:01:07,400-234-090
//        00:05:01,701-080-080
//        00:05:00,400-234-090

        String[] lineItems = inputString.split("\n");

        Map<String, PhoneCost> costMap = new HashMap<>();

        int totalCost = 0;
        Pattern pattern = Pattern.compile("([0-9]{2}:[0-9]{2}:[0-9]{2})(,)([0-9]{3}-[0-9]{3}-[0-9]{3})");
        for (String lineItem : lineItems) {

            Matcher matcher = pattern.matcher(lineItem);

            if (!matcher.matches())  {
                continue;
            }

            String time = matcher.group(1);
            String phoneNo = matcher.group(3);

            int totalSeconds = getTotalSeconds(time);
            int cost = 0;
            if(totalSeconds > 300)  {
                cost = (totalSeconds/60) * 150;
            } else  {
                cost = totalSeconds * 3;
            }
            if(costMap.containsKey(phoneNo))  {
                PhoneCost phoneCost = costMap.get(phoneNo);
                costMap.put(phoneNo, new PhoneCost(phoneNo, phoneCost.getCallDuration()+totalCost,
                        phoneCost.getCallCost()+cost));
            }
            else
                costMap.put(phoneNo, new PhoneCost(phoneNo, totalSeconds, cost));
            
            totalCost += cost;

        }

        //get max duration phone
        Optional<PhoneCost> maxDurationPhone = costMap.values().stream().max((x, y) -> (x.getCallDuration() > y.getCallDuration()) ? 1 : -1);

        if(maxDurationPhone.isPresent())  {
            PhoneCost phoneCost = maxDurationPhone.get();
            totalCost -= phoneCost.getCallCost();
        }
        return totalCost;
    }

    private int getTotalSeconds(String time) {

        String[] split = time.split(":");

        return Integer.parseInt(split[0])*60 *60 + Integer.parseInt(split[1]) * 60
                +Integer.parseInt(split[2]);
    }
}

class PhoneCost  {
    private String phoneNo;
    private int callDuration;
    private int callCost;

    public PhoneCost(String phoneNo, int callDuration, int callCost) {
        this.phoneNo = phoneNo;
        this.callDuration = callDuration;
        this.callCost = callCost;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public int getCallCost() {
        return callCost;
    }
}