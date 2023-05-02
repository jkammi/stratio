package com.stratio.data;

public enum Tags {
    AGILE("Agile"),
    ALGORITHMS("Algorithms"),
    ANALYTICS("Analytics"),
    ARTIFICIAL_INTELLIGENCE("Artificial Intelligence"),
    BIG_DATA("Big Data"),
    CLOUD("Cloud"),
    CULTURE("Culture"),
    DATA_MANAGEMENT("Data management"),
    EVENTS("events"),
    KAFKA("Kafka"),
    ML("ML"),
    SPARK("spark"),
    TALENT("talent");

    private String displayName;

    Tags(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
