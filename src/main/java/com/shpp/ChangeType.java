package com.shpp;

import java.util.HashMap;

public class ChangeType {

    public HashMap<String, IChangeType> getMap() {
        HashMap<String, IChangeType> map = new HashMap<>();
        map.putIfAbsent("short", new IChangeType() {
            @Override
            public Number apply(Number number) {
                return number.shortValue();
            }
        });
        map.putIfAbsent("int", new IChangeType() {
            @Override
            public Number apply(Number number) {
                return number.intValue();
            }
        });
        map.putIfAbsent("double", new IChangeType() {
            @Override
            public Number apply(Number number) {
                return number.doubleValue();
            }
        });
        map.putIfAbsent("float", new IChangeType() {
            @Override
            public Number apply(Number number) {
                return number.floatValue();
            }
        });
        map.putIfAbsent("long", new IChangeType() {
            @Override
            public Number apply(Number number) {
                return number.longValue();
            }
        });
        return map;
    }
}
