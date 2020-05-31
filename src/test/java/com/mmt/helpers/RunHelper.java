package com.mmt.helpers;

import java.util.HashMap;
import java.util.Map;

public class RunHelper {
    private static ThreadLocal<Map<Object, Object>> runData;

    public static void initRunData() {
        HashMap<Object, Object> map = new HashMap<>();
        if (runData == null) {
            runData = ThreadLocal.withInitial(() -> map);
            runData.set(map);
        }
        runData.set(map);
    }

    public static Object getRunData(Object key) {
        return runData.get().get(key);
    }

    public static void addRunData(Object key, Object value) {
        runData.get().put(key, value);
    }
}
