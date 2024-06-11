package api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.BarrioService;


@Path("/barrio")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
public class BarrioApi {

    private final BarrioService barrioService;

    public BarrioApi() {
        this.barrioService = new BarrioService();
    }

    @GET
    @Path("/")
    public Response getBarrioByName(@QueryParam("name") String name) {
        return barrioService.getBarrioByName(name);
    }

    @POST
    @Path("/reset")
    public Response resetBarrioByName(@QueryParam("name") String name) {
        return barrioService.resetBarrioByName(name);
    }
}
