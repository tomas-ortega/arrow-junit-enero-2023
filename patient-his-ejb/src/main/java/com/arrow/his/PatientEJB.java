package com.arrow.his;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.arrow.his.interfaces.IPatientDAO;

@Singleton
public class PatientEJB implements IPatientEjbInterface {
	private IPatientDAO patientDAO;
	
	@Inject
	public void setPatientDAO(IPatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}
	

    @Override
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
