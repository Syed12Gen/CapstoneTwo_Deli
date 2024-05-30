package com.ps;

public enum DrinkFlavor {
    PINEAPPLE {
        public String toString() {
            return "Pineapple";
        }
    },
    ORANGE {
        public String toString() {
            return "Orange";
        }
    },

    MIXED_FRUIT{
        public String toString() {
            return "Mixed fruit";
        }
    }
}