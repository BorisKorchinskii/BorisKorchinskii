package enums;

public enum Logging {

    R2FROM {
        @Override
        public String toString() {
            return "Range 2(From):";
        }
    },

    R2TO {
        @Override
        public String toString() {
            return "Range 2(To):";
        }
    },

    FROM {
        @Override
        public String toString() {
            return "(From):";
        }
    },

    TO {
        @Override
        public String toString() {
            return "(To):";
        }
    },

    CLICKED {
        @Override
        public String toString() {
            return " link clicked";
        }
    },

    VALUE_CHANGED_TO {
        @Override
        public String toString() {
            return ": value changed to ";
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
