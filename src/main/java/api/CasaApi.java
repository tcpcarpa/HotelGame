package api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import model.Casa;
import service.CasaService;


@Path("/casas")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
public class CasaApi {
    private final CasaService casaService;

    public CasaApi() {
        this.casaService = new CasaService();
    }

    @GET
    @Path("/{id}")
    public Response getcasaPorId(@PathParam("id") int id) {
        return casaService.getCasaPorId(id);
    }

    @GET
    @Path("/")
    public Response getCasas() {
        return casaService.getCasas();
    }

    @PUT
    @Path("/")
    public Response putNuevaCasa(Casa casa) {
        return casaService.putNuevaCasa(casa);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCasa(@PathParam("id") int id) {
        return casaService.deleteCasa(id);
    }
}