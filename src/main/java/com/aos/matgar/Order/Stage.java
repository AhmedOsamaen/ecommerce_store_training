package com.aos.matgar.Order;

public enum Stage {
    CART("CART"), CONFIRMATION("CONFIRMATION"), PAYMENT("PAYMENT"), REVIEW("REVIEW"), PLACED("PLACED"),
    DELIVERY("DELIVERY"), DELIVERED("DELIVERED");

    private String code;

    private Stage(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
