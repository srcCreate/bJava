package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Organization {
    private final Link homepage;

    private List<Periods> periods = new ArrayList<>();

    public Organization(String name, String url) {
        this.homepage = new Link(name, url);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (periods != null ? !periods.equals(that.periods) : that.periods != null) return false;
        return homepage != null ? homepage.equals(that.homepage) : that.homepage == null;
    }

    @Override
    public int hashCode() {
        int result = periods != null ? periods.hashCode() : 0;
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "periods=" + periods +
                ", homepage=" + homepage +
                '}';
    }
}
