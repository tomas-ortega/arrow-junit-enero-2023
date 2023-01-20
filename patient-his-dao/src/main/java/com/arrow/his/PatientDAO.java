package com.arrow.his;

import javax.inject.Singleton;

import com.arrow.his.interfaces.IPatientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Singleton
public class PatientDAO implements IPatientDAO {

	@Override
    public PatientDTO searchPatient(Connection connectionReference,
                            PatientDTO patientSearchCriteria) throws SQLException {
        StringBuilder sqlSelect = null;
        PreparedStatement statement = null;
        Integer statementIndex = 1;
        ResultSet resultSet = null;
        PatientDTO patientFound = null;
        
        try {
        	sqlSelect = new StringBuilder();
        	
        	sqlSelect.append("SELECT ");
        	
        	sqlSelect.append("patient.nhc,");
        	sqlSelect.append("patient.vatid,");
        	sqlSelect.append("patient.name");
        	
        	sqlSelect.append(" FROM ");
        	
        	sqlSelect.append("patient");
        	
        	sqlSelect.append(" WHERE ");
        	sqlSelect.append("(1=1)");
        	
            
        	if (patientSearchCriteria.getNhc() != null) {
        		sqlSelect.append(" AND (");
        		sqlSelect.append("patient.nhc = ?");
        		sqlSelect.append(")");
        	}
        	
        	if (patientSearchCriteria.getName() != null) {
        		sqlSelect.append(" AND (");
        		sqlSelect.append("patient.name = ?");
        		sqlSelect.append(")");
        	}
        	
        	if (patientSearchCriteria.getVatId() != null) {
        		sqlSelect.append(" AND (");
        		sqlSelect.append("patient.vatid = ?");
        		sqlSelect.append(")");
        	}
        	
        	statement = connectionReference.prepareStatement(sqlSelect.toString());
        	
        	if (patientSearchCriteria.getNhc() != null) {
        		statement.setString(statementIndex, patientSearchCriteria.getNhc());
        		statementIndex++;
        	}
        	
        	if (patientSearchCriteria.getName() != null) {
        		statement.setString(statementIndex, patientSearchCriteria.getName());
        		statementIndex++;
        	}
        	
        	if (patientSearchCriteria.getVatId() != null) {
        		statement.setString(statementIndex, patientSearchCriteria.getVatId());
        		statementIndex++;
        	}
        	
        	resultSet = statement.executeQuery();
        	
        	while (resultSet.next()) {
        		patientFound = new PatientDTO();
        		
        		patientFound.setNhc(resultSet.getString("nhc"));
        		patientFound.setName(resultSet.getString("name"));
        		patientFound.setVatId(resultSet.getString("vatid"));
        	}
        	
        	return patientFound;
        } catch(SQLException ex) {
        	throw ex;
        } finally {
            if (resultSet != null) {
            	resultSet.close();
            }
            
            if (statement != null) {
            	statement.close();
            }
        }
    }
}
