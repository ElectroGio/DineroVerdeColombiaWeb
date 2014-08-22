package com.dineroverde.colombia.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que se conecta a la Base de datos y genera utilidades.
 * */
public class UtilidadesBD {

	public static Connection getConexionUtilidadesBD(final String pDataBase,
			final String pURL, final String pUser, final String pPassword) {

		Connection conexionReturn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://" + pURL + "/" + pDataBase;
			// conexionReturn=
			// DriverManager.getConnection(servidor,usuarioDB,passwordDB);
			conexionReturn = DriverManager.getConnection(servidor, pUser,
					pPassword);
		} catch (ClassNotFoundException ex) {
			String error = ex.getMessage();
			conexionReturn = null;
		} catch (SQLException ex) {
			conexionReturn = null;
		} catch (Exception ex) {
			conexionReturn = null;
		}

		return conexionReturn;

	}

}
