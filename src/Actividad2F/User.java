package Actividad2F;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class User {

    protected int id;
    protected String id_user;
    protected String password;
    protected byte[] passMD5 = null;
    protected String timeDateAccessCorrect;
    protected String timeDataAccessIncorrect;
    protected String type_user;
    protected Boolean isActive;


    public User(String id_user, String password, String type_user) {
        if (id_user.length() >= 5 && password.length() >= 5) {//comprobacion de que el usuario y la password superan los 5 caracteres
            byte[] bytesOfMessage = null;
            try {
                bytesOfMessage = password.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                this.passMD5 = md.digest(bytesOfMessage);
                this.id_user = id_user;
                this.type_user = type_user;
                System.out.println("El usuario se creo");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("[ERROR]: La contraseña debe tener como mínimo 5 caracteres");
        }
    }

    public User(int id, String id_user, String password, byte[] passMD5, String timeDateAccessCorrect, String timeDataAccessIncorrect, String type_user, Boolean isActive) {
        this.id = id;
        this.id_user = id_user;
        this.password = password;
        this.passMD5 = passMD5;
        this.timeDateAccessCorrect = timeDateAccessCorrect;
        this.timeDataAccessIncorrect = timeDataAccessIncorrect;
        this.type_user = type_user;
        this.isActive = isActive;
    }

    public User() {

    }

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
        if (id_user.length() > 5) {
            this.id_user = id_user;
            System.out.println("Se a guardado el usuario");
        } else {
            System.err.println("[ERROR]: El usuario debe tener como mínimo 5 caracteres");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPassMD5() {
        return passMD5;
    }

    public void setPassMD5(byte[] passMD5) {
        if (password.length() >= 5) {
            byte[] bytesOfMessage = null;
            try {
                bytesOfMessage = password.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                this.passMD5 = md.digest(bytesOfMessage);
                password = HexTransform.bytesToHex(passMD5);

            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("[ERROR]: La contraseña debe tener como mínimo 5 caracteres");
        }
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

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void identificacion(ArrayList<User> usuarios) {
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("[ERROR] No hay usuarios registrados.");
            return;
        }
        usuarios.add(new User("Brayan", "12345", "Admin"));
        usuarios.add(new User("Maria", "password", "User"));
        System.out.println("<<< BIENVENIDO A LA GESTIÓN DE USUARIOS >>>");

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresa tu usuario");
        String id_userInput = leer.nextLine();
        //Hacemos un boolean con el usuarioEncntrado para luego preguntarlo en el arraylist
        boolean usuarioEncontrado = false;

        for (User listUser : usuarios) {
            if (listUser.getId_user().equals(id_userInput)) {
                usuarioEncontrado = true; //se encuentra y procede a pedir los demás datos
                System.out.println("Usuario encontrado: " + listUser.getId_user() + "\nIngresa tu contraseña");
                String passwordInput = leer.nextLine();
                //Compara la contraseña ingresada con la que se almacenó en el usuario
                try {
                    byte[] bytesOfMessage = passwordInput.getBytes("UTF-8");
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] passMD5Input = md.digest(bytesOfMessage);
                    if (Arrays.equals(passMD5Input, listUser.getPassMD5())) {
                        System.out.println("Contraseña correcta\nBienvenido " + listUser.getId_user());
                        String fechaActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd''HH:mm:ss"));
                        listUser.setTimeDateAccessCorrect(fechaActual);
                        listUser.setActive(true);
                    } else {
                        System.out.println("Contraseña incorrecta\nIntenta de nuevo");
                        String fechaActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd''HH:mm:ss"));
                        listUser.setTimeDataAccessIncorrect(fechaActual);
                    }
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }

    @Override
    public String toString() {
        return "User[" + "id=" + id + ", id_user='" + id_user + ", password='" + password + ", passMD5=" + Arrays.toString(passMD5) + ", timeDateAccessCorrect='" + timeDateAccessCorrect + ", timeDataAccessIncorrect='" + timeDataAccessIncorrect + ", type_user='" + type_user + ", isActive=" + isActive + ']';
    }
}





