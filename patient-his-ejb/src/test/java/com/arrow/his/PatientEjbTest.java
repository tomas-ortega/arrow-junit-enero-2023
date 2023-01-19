package com.arrow.his;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


//@ExtendWith(MockitoExtension.class)
public class PatientEjbTest 
{
  //  @InjectMocks
    //@Spy
    //private PatientEJB patientEJB;

    //private static PatientEjbHelper patientEjbHelper;

    //@BeforeAll
    //public static void setUpClass() {
      //  patientEjbHelper = new PatientEjbHelper();

    //}
    @Test
    public void testSearchPatientWithPakitoName() throws Exception
    {
      PatientEJB patientEJB = null;
      PatientDTO patientCriterial = null;
      PatientDTO patientFound = null;

      patientEJB = new PatientEJB();
      patientCriterial = new PatientDTO();

      patientCriterial.setName("pakito");
      patientFound = patientEJB.searchPatient(patientCriterial);

      assertEquals("pakito", patientFound.getName());
    }

    @Test
    public void testSearchPatientWithNhcAn() throws Exception{
      PatientEJB patientBs = null;
      PatientDTO patientSearchCriterio = null;
      PatientDTO patientFound = null;

      patientBs = new PatientEJB();
      patientSearchCriterio = new PatientDTO();

      patientSearchCriterio.setNhc("AN");

      patientFound = patientBs.searchPatient(patientSearchCriterio);
      
      assertNotNull(patientFound);
      assertEquals(patientSearchCriterio.getNhc(),
                   patientFound.getNhc());
    }
}
