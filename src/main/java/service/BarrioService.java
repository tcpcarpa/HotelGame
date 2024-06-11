package service;


import dao.Dao;
import jakarta.ws.rs.core.Response;
import model.Barrio;
import model.Casa;

import java.sql.SQLException;


public class BarrioService {
    private Dao dao;

    public BarrioService() {
        this.dao = new Dao();
    }

    public Response getBarrioByName(String name) {
        try {
            Barrio barrio = dao.getBarrio(name);
            if (barrio == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Nombre de Barrio incorrecto").build();
            }
            return Response.ok(barrio).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response resetBarrioByName(String name) {
        try {
            Barrio barrio = dao.getBarrio(name);
            if (barrio == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Nombre de Barrio incorrecto").build();
            }
            for(Casa casa : barrio.getCasas()) {
                dao.deleteCasaByBarrio(name);
            }
            return Response.ok().entity("Barrio reiniciado.").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
