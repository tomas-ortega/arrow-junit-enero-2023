package com.arrow.his;

public class PatientDTO {
    private String nhc;
    private String vatId;
    private String name;

    public PatientDTO() {
        this.nhc = null;
        this.vatId = null;
        this.name = null;
    }

    public String getNhc() {
        return nhc;
    }

    public void setNhc(String nhc) {
        this.nhc = nhc;
    }

    public String getVatId() {
        return vatId;
    }

    public void setVatId(String vatId) {
        this.vatId = vatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
