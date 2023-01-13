module javaquiz.db {
    requires java.sql;
    requires sqlite.jdbc;
    requires transitive javaquiz.common;

    exports javaquiz.db;
}