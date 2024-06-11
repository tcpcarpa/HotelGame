package api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import model.Inquilino;
import service.InquilinoService;

@Path("/inquilinos")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
public class InquilinoApi {

    private final InquilinoService inquilinoService;

    public InquilinoApi() {
        this.inquilinoService = new InquilinoService();
    }

    @GET
    @Path("/{id}")
    public Response getInquilinoById(@PathParam("id") int id) {
        return inquilinoService.getInquilinoById(id);
    }

    @GET
    @Path("/")
    public Response getInquilinos(){
        return inquilinoService.getInquilinos();
    }

    @PUT
    @Path("/")
    public Response putNuevoInquilino(Inquilino inquilino) {
        return inquilinoService.putNuevoInquilino(inquilino);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteInquilino(@PathParam("id") int id) {
        return inquilinoService.deleteInquilino(id);
    }
}