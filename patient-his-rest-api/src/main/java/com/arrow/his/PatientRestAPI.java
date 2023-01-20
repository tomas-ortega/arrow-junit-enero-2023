package com.arrow.his;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/patient")
@Singleton
public class PatientRestAPI {

    private IPatientEjbInterface ipatientEjb;

    @Inject
    public void setPatientEjbInterface(IPatientEjbInterface patientEjbInterface) {
        this.ipatientEjb = patientEjbInterface;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/searchpatient")
    public Response searchPatient(@QueryParam("nhc") String nhc) {
        Response httpResponse = null;
        PatientDTO patientSearchCriteria = null;
        PatientDTO patientFound = null;

        try {
            patientSearchCriteria = new PatientDTO();
            patientSearchCriteria.setNhc(nhc);

            patientFound = this.ipatientEjb.searchPatient(patientSearchCriteria);

            if (patientFound == null) {
                httpResponse = Response.status(Response.Status.NOT_FOUND).build();
            } else  {
                httpResponse = Response.status(Response.Status.OK)
                                        .entity(patientFound)
                                        .build();
            }
        } catch(Exception ex) {
            httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                                    .build();
        }

        return httpResponse;
    }
}

/*IP:PORT/<CONTEXT>/api/microservice1
IP:PORT/<CONTEXT>/api/microservice2

http://127.0.0.1:8080/his/api/*/