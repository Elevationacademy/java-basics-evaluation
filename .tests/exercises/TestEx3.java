package com;

import junit.framework.TestCase;
import org.junit.Test;
import static com.DateCalculatorTestSetup.*;
import java.time.LocalDate;
import com.DateCalculator;
import static org.junit.Assert.assertEquals;

public class TestEx3 {

    @Test
    public void testGetWeekDay() {
        for (Date d: invalidData) {
            assertEquals(DateCalculator.WeekDay.INVALID_WEEKDAY, DateCalculator.GetWeekDay(d.Year, d.Month, d.Day));
            assertEquals(DateCalculator.WeekDay.INVALID_WEEKDAY, DateCalculator.GetWeekDay(new Date(d.Day, d.Month, d.Year).toString()));
        }

        for (Date d: data) {
            LocalDate today = LocalDate.of(d.Year, d.Month, d.Day);
            String expected =  today.getDayOfWeek().toString();
            String date_string = new Date(d.Day, d.Month, d.Year).toString();
            String actual = DateCalculator.GetWeekDay(date_string).toString().toString();
            assertEquals(String.format("GetWeekDay(%s) Function should return %s, but it returned %s",
                      date_string, actual, expected),
                      expected.toUpperCase(), actual.toUpperCase());

            actual = DateCalculator.GetWeekDay(d.Year, d.Month, d.Day).toString();
            assertEquals(String.format("GetWeekDay(%d,%d,%d) Function should return %s, but it returned %s",
                    d.Year, d.Month, d.Day, expected, actual),
                    expected.toUpperCase(), actual.toUpperCase());
        }
    }
}
