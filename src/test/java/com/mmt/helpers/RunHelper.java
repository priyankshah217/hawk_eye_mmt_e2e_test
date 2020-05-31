package com.mmt.helpers;

import com.mmt.enums.HotelDetail;

import java.util.HashMap;
import java.util.Map;

public class RunHelper {
    private static ThreadLocal<Map<Object, String>> runData;

    public static void initRunData() {
        HashMap<Object, String> map = new HashMap<>();
        if (runData == null) {
            runData = ThreadLocal.withInitial(() -> map);
            runData.set(map);
        }
        runData.set(map);
    }

    public static String getRunData(Object key) {
        return runData.get().get(key);
    }

    public static void addRunData(Object key, String value) {
        runData.get().put(key, value);
    }
}
