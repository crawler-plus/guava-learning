package com.it4u.guava.utilities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import java.util.Calendar;

public class ObjectsExample {

    public static void main(String[] args) {
        final Guava guava = new Guava("Google", "23.0", Calendar.getInstance());
        System.out.println(guava);
        System.out.println(guava.hashCode());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        final Guava guava2 = new Guava("Google", "23.0", calendar);
        System.out.println(guava.compareTo(guava2));
    }

    static class Guava implements Comparable<Guava> {

        private final String manufacturer;
        private final String version;
        private final Calendar releaseDate;

        public Guava(String manufacturer, String version, Calendar releaseDate) {
            this.manufacturer = manufacturer;
            this.version = version;
            this.releaseDate = releaseDate;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).omitNullValues()
                    .add("manufacturer", this.manufacturer)
                    .add("version", this.version)
                    .add("releaseDate", this.releaseDate).toString();
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(manufacturer, version, releaseDate);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Guava guava = (Guava) obj;

            return Objects.equal(this.manufacturer, guava.manufacturer)
                    && Objects.equal(this.version, guava.version)
                    && Objects.equal(this.releaseDate, guava.releaseDate);
        }

        @Override
        public int compareTo(Guava o) {
            return ComparisonChain.start()
                    .compare(this.manufacturer, o.manufacturer)
                    .compare(this.version, o.version)
                    .compare(this.releaseDate, o.releaseDate)
                    .result();
        }
    }
}
