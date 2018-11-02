package enums;

import java.util.ArrayList;
import java.util.List;

public enum HeaderMenu {

    HEADER_SUPPORT("SUPPORT"),
    HEADER_DATES("DATES"),
    HEADER_COMPLEX_TABLE("COMPLEX TABLE"),
    HEADER_SIMPLE_TABLE("SIMPLE TABLE"),
    HEADER_USER_TABLE("USER TABLE"),
    HEADER_TABLE_WITH_PAGES("TABLE WITH PAGES"),
    HEADER_DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    HEADER_PERFORMANCE("PERFORMANCE");

    String headerCategoryName;

    HeaderMenu(String name) {
        headerCategoryName = name;
    }

    public static List<String> getHeaderCategoriesList() {
        List<String> result = new ArrayList<>();
        for (HeaderMenu category : HeaderMenu.values()) {
            result.add(category.headerCategoryName);
        }
        return result;
    }
}
