package com.xiaogang.annotation;

public enum Currency {

    CN("China"), JP("Japan"), US("Miguo");

    String code;

    private Currency(String country) {
        code = country;
    }

}
