package com.arrow.his;

public class PatientEjbHelper {
    private PatientDTO patientFoundWithNhcAN356743;

    public PatientEjbHelper() {
        this.patientFoundWithNhcAN356743 = null;
        this.initData();
    }

    private void initData() {
        this.initPatientWithNhcAN356743();
    }

    private void initPatientWithNhcAN356743() {
        this.patientFoundWithNhcAN356743 = new PatientDTO();
        this.patientFoundWithNhcAN356743.setNhc("AN356743");
        this.patientFoundWithNhcAN356743.setVatId("ES74938421K");
        this.patientFoundWithNhcAN356743.setName("Pakito");
    }
}
