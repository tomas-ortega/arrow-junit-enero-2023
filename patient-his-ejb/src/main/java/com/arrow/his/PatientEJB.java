package com.arrow.his;

import javax.ejb.Stateless;

@Stateless
public class PatientEJB {

    public PatientDTO searchPatient(PatientDTO nhc) throws Exception {
         PatientDTO patientFound = null;
         
        try {
            patientFound = new PatientDTO();
            patientFound.setName("pakito");
            patientFound.setNhc("AN");
            patientFound.setVatId("1");

            return patientFound;

        } catch(Exception ex) {
            throw ex;
        }
    }
}
