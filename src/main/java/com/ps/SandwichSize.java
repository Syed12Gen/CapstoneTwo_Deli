package com.ps;

public enum SandwichSize {
    FOUR_INCH {
        public String toString() {
            return "4-inch";
        }
    },
    EIGHT_INCH{
        public String toString() {
            return "8-inch";
        }
    },
    TWELVE_INCH{
        public String toString() {
            return "12-inch";
        }
    }
}
