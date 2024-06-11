package utils;

public class Constants {

    //BD
    public static final String SCHEMA_NAME = "m09uf3ac1";
    public static final String CONNECTION = "jdbc:mysql://localhost:3306/" + SCHEMA_NAME +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    public static final String USER_CONNECTION = "root";
    public static final String PASS_CONNECTION = "root";

    //RESPONSES
    public static final String OK = "La solicitud aceptada";
    public static final String CREATED = "Se ha credo la petición de forma adecuada";
    public static final String NO_CONTENT = "No hay datos que mostrar en la petición";
    public static final String BAD_REQUEST = "La solicitud no fue valida";
    public static final String UNAUTHORIZED = "No tienes autorización para la consulta";
    public static final String FORBIDDEN = "No puedes consultar esta información, falta autorizaicón válida";
    public static final String NOT_FOUND = "No hay información en el destino requerido";
    public static final String METHOD_NOT_ALLOWED = "No se entiende la petición";
    public static final String NOT_ACCEPTABLE= "Formato de datos incorrecto";
    public static final String  CONFLICT= "Intento de modificación fallido, no coinciden los parametros";
    public static final String  UNUPPORTED_MEDIA_TYPE= "Error en el Formato de los datos";
    public static final String  INTERNAL_SERVER_ERROR= "Error interno en el Servidor, no se pude procesar la llamada";


    public static final String GET_BARRIO = "select * from barrio where name = ?;";
    public static String GET_INQUILINO = "select * from inquilino where id = ?";
    public static String GET_CASA = "select * from casa where id = ?";
    public static String GET_CASAS = "select * from casa";
    public static String GET_INQUILINOS = "select * from inquilino;";
    public static final String GET_CASAS_BY_BARRIO = "select * from casa where barrio = ?";
    public static final String GET_INQUILINOS_BY_CASA = "select * from inquilino where casa = ?";

    public static final String INSERT_CASA = "insert into casa values(?,?)";
    public static final String INSERT_INQUILINO = "insert into inquilino values(?,?)";

    public static final String DELETE_CASA = "delete from casa where id = ?";
    public static final String DELETE_INQUILINO = "delete from inquilino where id = ?";
    public static final String DELETE_CASA_BY_BARRIO = "delete from casa where barrio = ?";
    public static final String DELETE_INQUILINO_BY_CASA = "delete from inquilino where casa = ?";
}
