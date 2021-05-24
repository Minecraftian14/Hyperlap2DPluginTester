package com.mcxiv.app.PMVCTest;

import java.util.stream.Stream;

public enum EventExample {

    NULL,
    INITIALISE_UI,
    SET_LABEL_TEXT,
    ADD_NEW_BUTTON;

    private final String name;

    EventExample() {
        this.name = getClass() + ":" + name();
    }

    public static String[] getList() {
        return Stream.of(values()).map(EventExample::getName).toArray(String[]::new);
    }

    public static EventExample getEventNamed(String name) {
        return Stream.of(values()).filter(event -> event.equals(name)).findFirst().orElse(NULL);
    }

    public boolean equals(String name) {
        return getName().equals(name);
    }

    public String getName() {
        return name;
    }

}
