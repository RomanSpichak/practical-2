package com.shpp;

import java.util.HashMap;

public class ChangeType {

    public HashMap<String, IChangeType> getMap() {
        HashMap<String, IChangeType> map = new HashMap<>();
        map.putIfAbsent("short", new IChangeType() {
            @Override
            public Number apply(String number) {
                return Short.parseShort(number);
            }
        });
        map.putIfAbsent("int", new IChangeType() {
            @Override
            public Number apply(String number) {
                return Integer.parseInt(number);
            }
        });
        map.putIfAbsent("double", new IChangeType() {
            @Override
            public Number apply(String number) {
                return Double.parseDouble(number);
            }
        });
        map.putIfAbsent("float", new IChangeType() {
            @Override
            public Number apply(String number) {
                return Float.parseFloat(number);
            }
        });
        map.putIfAbsent("long", new IChangeType() {
            @Override
            public Number apply(String number) {
                return Long.parseLong(number);
            }
        });
        return map;
    }
}
