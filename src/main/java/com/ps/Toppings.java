package com.ps;

public enum Toppings {
    LETTUCE("Regular"),
    TOMATO("Regular"),
    ONION("Regular"),
    PEPPERS("Regular"),
    CUCUMBERS("Regular"),
    PICKLES("Regular"),
    JALAPENOS("Regular"),
    MUSHROOMS("Regular"),
    GUACAMOLE("Regular"),
    BACON("Premium"),
    CHICKEN("Premium"),
    STEAK("Premium"),
    HAM("Premium"),
    SALAMI("Premium"),
    ROAST_BEEF("Premium"),
    CHEESE("Premium"),
    EXTRA_CHEESE("Premium"); // Including the extra cheese option

    private final String type;

    Toppings(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

