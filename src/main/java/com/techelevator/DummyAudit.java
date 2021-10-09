package com.techelevator;

import java.io.ObjectStreamException;

public class DummyAudit {

    public static void main(String[] args) {
        PossibleAuditLog log = new PossibleAuditLog();
        log.logEvent("buy", "5","10");
    }
}

// Created this dummy class to test that the format would look good when printed to file
