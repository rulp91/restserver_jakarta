package es.uma.isia.restserver;

import es.uma.isia.restserver.utils.NifCifNieValidator;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/dni")
public class NifResource {
    @GET
    @Path("{param}")
    @Produces("text/plain")
    public String getNifNie(@PathParam("param") int nif) {

        String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
        String output = String.valueOf(NIF_STRING_ASOCIATION.charAt(nif % 23));

        return output;
    }

    @GET
    @Path("validar_nifnie/{param}")
    @Produces("text/plain")
    public boolean validarNifNie(@PathParam("param") String nif) {
        return NifCifNieValidator.isNifNie(nif);
    }

    @GET
    @Path("validar_cif/{param}")
    @Produces("text/plain")
    public boolean validarCif(@PathParam("param") String nif) {
        return NifCifNieValidator.isCIF(nif);
    }
}