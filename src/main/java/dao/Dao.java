package dao;

import model.Barrio;
import model.Casa;
import model.Inquilino;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;

public class Dao {

    private Connection con;

    public void connectar() throws SQLException {
        String url = utils.Constants.CONNECTION;
        String user = utils.Constants.USER_CONNECTION;
        String pass = utils.Constants.PASS_CONNECTION;
        con = DriverManager.getConnection(url, user, pass);
    }
    public void desconectar() throws SQLException {
        if(con!=null){
            con.close();
        }
    }

    public Barrio getBarrio(String name) throws SQLException {
        connectar();
        Barrio barrio = null;
        try (PreparedStatement ps = con.prepareStatement(utils.Constants.GET_BARRIO)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    barrio = new Barrio(rs.getString(1), getCasasByBarrio(name));
                }
            }
        }
        return barrio;
    }

    public Inquilino getInquilino(int id) throws SQLException {
        connectar();
        Inquilino inquilino = null;
        try (PreparedStatement ps = con.prepareStatement(Constants.GET_INQUILINO)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    inquilino = new Inquilino(rs.getInt(1), rs.getInt(2));
                }
            }
        }
        return inquilino;
    }

    public Casa getCasa(int id) throws SQLException {
        connectar();
        Casa casa = null;
        try (PreparedStatement ps = con.prepareStatement(Constants.GET_CASA)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    casa = new Casa(rs.getInt(1), rs.getString(2), getInquilinosByCasa(id));
                }
            }
        }
        return casa;
    }

    public ArrayList<Casa> getCasas() throws SQLException {
        connectar();
        ArrayList<Casa> casas = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(Constants.GET_CASAS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    casas.add(new Casa(rs.getInt(1), rs.getString(2), getInquilinosByCasa(rs.getInt(1))));
                }
            }
        }
        return casas;
    }

    public ArrayList<Inquilino> getInquilinos() throws SQLException {
        connectar();
        ArrayList<Inquilino> inquilinos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(Constants.GET_INQUILINOS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    inquilinos.add(new Inquilino(rs.getInt(1), rs.getInt(2)));
                }
            }
        }
        return inquilinos;
    }

    public ArrayList<Casa> getCasasByBarrio(String name) throws SQLException {
        ArrayList<Casa> casas = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(Constants.GET_CASAS_BY_BARRIO)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    casas.add(new Casa(rs.getInt(1), rs.getString(2), getInquilinosByCasa(rs.getInt(1))));
                }
            }
        }
        return casas;
    }

    public ArrayList<Inquilino> getInquilinosByCasa(int id) throws SQLException {
        ArrayList<Inquilino> inquilinos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(Constants.GET_INQUILINOS_BY_CASA)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    inquilinos.add(new Inquilino(rs.getInt(1), rs.getInt(2)));
                }
            }
        }
        return inquilinos;
    }

    public void insertCasa(Casa casa) throws SQLException {
        connectar();
        try (PreparedStatement ps = con.prepareStatement(Constants.INSERT_CASA)) {
            ps.setInt(1, casa.getId());
            ps.setString(2, casa.getBarrio());
            ps.executeUpdate();
        }
    }

    public void insertInquilino(Inquilino inquilino) throws SQLException {
        connectar();
        try (PreparedStatement ps = con.prepareStatement(Constants.INSERT_INQUILINO)) {
            ps.setInt(1, inquilino.getId());
            ps.setInt(2, inquilino.getCasa());
            ps.executeUpdate();
        }
    }

    public void deleteCasaById(int id) throws SQLException {
        connectar();
        try (PreparedStatement ps = con.prepareStatement(Constants.DELETE_CASA)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void deleteCasaByBarrio(String name) throws SQLException {
        connectar();
        try (PreparedStatement ps = con.prepareStatement(Constants.DELETE_CASA_BY_BARRIO)) {
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public void deleteInquilinoById(int id) throws SQLException {
        connectar();
        try (PreparedStatement ps = con.prepareStatement(Constants.DELETE_INQUILINO)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
