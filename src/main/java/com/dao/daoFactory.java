package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class daoFactory {
	private String url;
    private String username;
    private String password;

    public daoFactory() {
		// TODO Auto-generated constructor stub
	}

	public daoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        daoFactory instance = new daoFactory();
        this.setUrl("jdbc:mysql://localhost:3306/maven?serverTimezone=UTC");
        this.setUsername("root");
        this.setPassword("");
        return instance;
    }

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() throws SQLException {
        Connection connexion = DriverManager.getConnection(url, username, password);
        connexion.setAutoCommit(false);
        return connexion;
    }
	
	public daoVille getDaoVille() {
		return new daoVille(this);
	}

}
