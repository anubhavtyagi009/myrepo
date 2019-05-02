package com.impelsys.microservice.dto;

public class ProficiencyDTO {

    private boolean independent;
    private boolean instructional;
    private boolean frustrational;

    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
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
