package enums;

public enum Logging {

    FROM {
        @Override
        public String toString() {
            return "Range 2(From):";
        }
    },

    TO {
        @Override
        public String toString() {
            return "Range 2(To):";
        }
    },

    ZERO {
        @Override
        public String toString() {
            return "0 link clicked";
        }
    },

    HUNDRED {
        @Override
        public String toString() {
            return "100 link clicked";
        }
    },

    THIRTY {
        @Override
        public String toString() {
            return "30 link clicked";
        }
    },

    SEVENTY {
        @Override
        public String toString() {
            return "70 link clicked";
        }
    },

    COND_CHANGED_TO {
        @Override
        public String toString() {
            return ": condition changed to ";
        }
    },

    VALUE_CHANGED_TO {
        @Override
        public String toString() {
            return ": value changed to ";
        }
    },

    TRUE {
        @Override
        public String toString() {
            return "true";
        }
    },

    FALSE {
        @Override
        public String toString() {
            return "false";
        }
    },

    METAL {
        @Override
        public String toString() {
            return "metal";
        }
    },

    COLORS {
        @Override
        public String toString() {
            return "Colors";
        }
    },
}
