package service;

import dao.Dao;
import jakarta.ws.rs.core.Response;
import model.Inquilino;

import java.sql.SQLException;
import java.util.ArrayList;

public class InquilinoService {
    private Dao dao;

    public InquilinoService() {
        this.dao = new Dao();
    }

    public Response getInquilinoById(int id) {
        try {
            Inquilino inquilino = dao.getInquilino(id);
            if (inquilino == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Inquilino no encontrado").build();
            }
            return Response.ok(inquilino).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response getInquilinos() {
        try {
            ArrayList<Inquilino> inquilinos = dao.getInquilinos();
            return Response.ok(inquilinos).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response putNuevoInquilino(Inquilino inquilino) {
        try {
            dao.insertInquilino(inquilino);
            return Response.ok().entity("Inquilino creado.").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("La id del inquilino ya existe.").build();
        }
    }

    public Response deleteInquilino(int id) {
        try {
            dao.deleteInquilinoById(id);
            return Response.ok().entity("Inquilino eliminado.").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Inquilino no encontrado").build();
        }
    }
}
