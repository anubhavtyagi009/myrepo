package com.impelsys.microservice.domain;

public class Proficiency {

    private boolean independant;
    private boolean instructional;
    private boolean frustrational;

    public boolean isIndependant() {
        return independant;
    }

    public void setIndependant(boolean independant) {
        this.independant = independant;
    }

    public boolean isInstructional() {
        return instructional;
    }

    public void setInstructional(boolean instructional) {
        this.instructional = instructional;
    }

    public boolean isFrustrational() {
        return frustrational;
    }

    public void setFrustrational(boolean frustrational) {
        this.frustrational = frustrational;
    }
}
