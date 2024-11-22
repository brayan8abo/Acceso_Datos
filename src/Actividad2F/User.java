package Actividad2F;

import java.time.LocalDate;

public class User {
	private int id;
	private String id_user;
	private String password;
	private String type_user;
	private LocalDate ultAccesoCorrecto;
	private LocalDate ultAccesoIncorrecto;
	private boolean isActive;

	public User(int id, String id_user, String password, String type_user, LocalDate ultAccesoCorrecto, LocalDate ultAccesoIncorrecto, boolean isActive) {
		this.id = id;
		this.id_user = id_user;
		this.password = password;
		this.type_user = type_user;
		this.ultAccesoCorrecto = null;
		this.ultAccesoIncorrecto = null;
		this.isActive = isActive;
	}

	public User(String id_user, String password, String type_user, boolean isActive) {
		this.id_user = id_user;
		this.password = password;
		this.type_user = type_user;
		this.isActive = isActive;
		this.ultAccesoCorrecto = null;
		this.ultAccesoIncorrecto = null;
	}

	public User() {

	}

	public User(String userInput, String passInput) {
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
		this.id_user = id_user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType_user() {
		return type_user;
	}

	public void setType_user(String type_user) {
		this.type_user = type_user;
	}

	public LocalDate getUltAccesoCorrecto() {
		return ultAccesoCorrecto;
	}

	public void setUltAccesoCorrecto(LocalDate ultAccesoCorrecto) {
		this.ultAccesoCorrecto = ultAccesoCorrecto;
	}

	public LocalDate getUltAccesoIncorrecto() {
		return ultAccesoIncorrecto;
	}

	public void setUltAccesoIncorrecto(LocalDate ultAccesoIncorrecto) {
		this.ultAccesoIncorrecto = ultAccesoIncorrecto;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}
}
