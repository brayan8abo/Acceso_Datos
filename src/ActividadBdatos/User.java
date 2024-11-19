package ActividadBdatos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {

    protected int id;
    protected String id_user;
    protected String password;
    protected String timeDateAccessCorrect;
    protected String timeDataAccessIncorrect;
    protected String type_user;
    protected Boolean isActive;


    public User(int id, String id_user, String password, String timeDateAccessCorrect, String timeDataAccessIncorrect, Boolean isActive) {
        this.id = id;
        this.id_user = id_user;
        this.password = password;
        this.timeDateAccessCorrect = timeDateAccessCorrect;
        this.timeDataAccessIncorrect = timeDataAccessIncorrect;
        this.type_user = type_user;
        this.isActive = isActive;
    }

    //getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimeDateAccessCorrect() {
        return timeDateAccessCorrect;
    }

    public void setTimeDateAccessCorrect(String timeDateAccessCorrect) {
        this.timeDateAccessCorrect = timeDateAccessCorrect;
    }

    public String getTimeDataAccessIncorrect() {
        return timeDataAccessIncorrect;
    }

    public void setTimeDataAccessIncorrect(String timeDataAccessIncorrect) {
        this.timeDataAccessIncorrect = timeDataAccessIncorrect;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getType_user() {
        return type_user;
    }

    public static String generarPasswordMD5(String password) throws NoSuchAlgorithmException {


        //creamos la md5 sobre el hash cuando pasamos la password
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] hash = md5.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();

        //recorremos cada byte del hash y lo añadimos a la cadena en hexadecimal
        for (byte clave : hash) {
            sb.append(String.format("%02x", clave));
        }
        return sb.toString();

    }

    public boolean insertInTable(Connection conexion) throws SQLException {
        if (id_user.length() < 5 || password.length() < 5) {
            System.out.println("ERROR: Los usuarios y las contraseñas deben tener como minimo 5 caracteres");
            return false;
        }
        String insertSQL = "insert into usuarios (id_user,password,type_user,active) values (,?,?,?,?)";
        try (PreparedStatement ps = conexion.prepareStatement(insertSQL)) {
            ps.setString(1, id_user);
            ps.setString(2, generarPasswordMD5(password));
            ps.setString(3, type_user);
            ps.setBoolean(4, isActive);
            return true;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}





