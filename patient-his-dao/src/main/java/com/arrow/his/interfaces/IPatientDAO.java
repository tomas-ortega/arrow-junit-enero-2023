package com.arrow.his.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import com.arrow.his.PatientDTO;

public interface IPatientDAO {
    PatientDTO searchPatient(Connection connectionReference,
            PatientDTO patientSearchCriteria) throws SQLException;
}
