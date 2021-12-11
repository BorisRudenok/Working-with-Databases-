package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeUtil {
    private final ConfigConst configConst = new ConfigConst();

    public String CurrentTime(long Time) {
        SimpleDateFormat sdf = new SimpleDateFormat(configConst.Time);
        Date resultDate = new Date(Time);
        return sdf.format(resultDate);
    }

}
