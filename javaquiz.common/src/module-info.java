module javaquiz.common {
    requires javafx.base;

    exports javaquiz.common;
    opens javaquiz.common to javafx.base;
}