package com.bec.orrreporting.service.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonFunctions {

    public static String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    public static Double sum(List<Integer> list) {
        double sum = 0;
        for (double i : list) {
            sum += i;
        }
        return sum;
    }

    public static Float sumFLoatNumbers(List<Float> list) {
        float sum = 0;
        for (float i : list) {
            sum += i;
        }
        return sum;
    }

    public static Double sumDoubleNumbers(List<Double> list) {
        double sum = 0;
        for (double i : list) {
            sum += i;
        }
        return sum;
    }
}
