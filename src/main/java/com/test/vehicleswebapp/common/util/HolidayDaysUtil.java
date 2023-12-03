package com.test.vehicleswebapp.common.util;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class HolidayDaysUtil{
    private static final List<LocalDate>Holidays= Arrays.asList(
            LocalDate.of(2023, 1, 1),  // New Year
            LocalDate.of(2023, 5, 1),  // Work Day
            LocalDate.of(2023, 12, 25) // Christmas
    );
    public static List<LocalDate> getHolidays(){
        return Holidays;
    }
}