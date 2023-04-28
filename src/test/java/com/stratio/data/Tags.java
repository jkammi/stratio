package com.stratio.data;

public enum Tags {
    AGILE("Agile"),
    ALGORITHMS("Algorithms"),
    ANALYTICS("Analytics"),
    ARTIFITICAL_INTELLIGENCE("Artifical Intelligence"),
    BIG_DATA("Big Data"),
    CLOUD("Cloud"),
    CULTURE("Culture"),
    DATA_MANAGEMENT("Data management"),
    EVENTS("events"),
    KAFKA("Kafka"),
    ML("ML"),
    SPARK("Spark"),
    TALENT("Talent");

    private String displayName;

    Tags(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    // Optionally and/or additionally, toString.
    @Override
    public String toString() {
        return displayName;
    }
}
