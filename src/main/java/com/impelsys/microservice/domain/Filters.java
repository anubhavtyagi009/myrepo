package com.impelsys.microservice.domain;

public class Filters {
    private Internalfilter internalfilter;
    private Externalfilter externalfilter;

    public Internalfilter getInternalfilter() {
        return internalfilter;
    }

    public void setInternalfilter(Internalfilter internalfilter) {
        this.internalfilter = internalfilter;
    }

    public Externalfilter getExternalfilter() {
        return externalfilter;
    }

    public void setExternalfilter(Externalfilter externalfilter) {
        this.externalfilter = externalfilter;
    }
}
