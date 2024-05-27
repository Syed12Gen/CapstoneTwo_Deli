package com.ps;

public enum BreadType {
    WHITE {
        @Override
        public String toString() {
            return "White";
        }
    },
    RYE {
        @Override
        public String toString() {
            return "Rye";
        }
    },
    WHEAT {
        @Override
        public String toString() {
            return "Wheat";
        }
    },
    WRAP {
        @Override
        public String toString() {
            return "Wrap";
        }
    }
}
