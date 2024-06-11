package service;

import dao.Dao;
import jakarta.ws.rs.core.Response;
import model.Casa;
import model.Inquilino;

import java.sql.SQLException;
import java.util.ArrayList;

public class CasaService {
    private Dao dao;

    public CasaService() {
        this.dao = new Dao();
    }

    public Response getCasaPorId(int id) {
        try {
            Casa casa = dao.getCasa(id);
            if (casa == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Casa no encontrada").build();
            }
            return Response.ok(casa).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response getCasas() {
        try {
            ArrayList<Casa> casas = dao.getCasas();
            return Response.ok(casas).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response putNuevaCasa(Casa casa) {
        try {
            dao.insertCasa(casa);
            for (Inquilino inquilino : casa.getInquilinos()){
                dao.insertInquilino(inquilino);
            }
            return Response.ok().entity("Casa creada.").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Casa no encontrada").build();
        }
    }
    public Response deleteCasa(int id) {
        try {
            dao.deleteCasaById(id);
            return Response.ok().entity("Casa eliminada.").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Casa no encontrada").build();
        }
    }
}
