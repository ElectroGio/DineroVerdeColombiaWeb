package com.dineroverde.colombia.dao;

import com.dineroverde.colombia.basedatos.TransactionResult;
import com.dineroverde.colombia.basedatos.UtilidadesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.dineroverde.colombia.constantes.*;
import com.dineroverde.colombia.entidades.Organization;

public class OrganizationDAO {

	private static Connection conexionDB;

	public static TransactionResult<Boolean> addOrganization(
			Organization pOrganization) {
		TransactionResult<Boolean> trRetorno = null;
		if (pOrganization != null) {
			try {
				conexionDB = UtilidadesBD.getConexionUtilidadesBD(
						Constantes.DATABASE, Constantes.URL, Constantes.USER,
						Constantes.PASSWORD);
				Statement statement = conexionDB.createStatement();
				String comando = "INSERT INTO organization"
						+ "(organization_id, national_identification, name, website, description, country_id)"
						+ " VALUES (" + pOrganization.getOrganizationID()
						+ ",'" + pOrganization.getNationalID() + "','"
						+ pOrganization.getName() + "','"
						+ pOrganization.getWebsite() + "','"
						+ pOrganization.getDescription() + "',"
						+ pOrganization.getCountryID() + ")";
				statement.executeUpdate(comando);
				trRetorno = new TransactionResult<Boolean>(true,
						"Se ha insertado correctamente la organización "
								+ pOrganization.getName());
				conexionDB.close();
			} catch (Exception e) {
				trRetorno = new TransactionResult<Boolean>(false,
						e.getMessage());
			}
		}

		if (conexionDB != null) {
			try {
				conexionDB.close();
			} catch (SQLException e) {
				trRetorno = new TransactionResult<Boolean>(false,
						e.getMessage());
			}
		}

		return trRetorno;
	}

	public static TransactionResult<Organization> getOrganizationByOrganizationID(
			final int pId) {

		TransactionResult<Organization> trRetorno = null;
		ResultSet rs = null;
		if (pId != 0) {
			try {
				conexionDB = UtilidadesBD.getConexionUtilidadesBD(
						Constantes.DATABASE, Constantes.URL, Constantes.USER,
						Constantes.PASSWORD);
				Statement statement = conexionDB.createStatement();
				String comando = "SELECT * FROM organization WHERE organization_id="
						+ pId;
				rs = statement.executeQuery(comando);
				if (rs.next()) {
					Organization orgRetorno = new Organization(pId,
							rs.getString("national_identification"),
							rs.getString("name"), rs.getString("website"),
							rs.getString("description"),
							rs.getInt("country_id"));
					trRetorno = new TransactionResult<Organization>(orgRetorno,
							"OK");
				}
			} catch (Exception e) {
				trRetorno = new TransactionResult<Organization>(null,
						e.getMessage());
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				trRetorno = new TransactionResult<Organization>(null,
						e.getMessage());
			}
		}

		if (conexionDB != null) {
			try {
				conexionDB.close();
			} catch (SQLException e) {
				trRetorno = new TransactionResult<Organization>(null,
						e.getMessage());
			}
		}

		return trRetorno;
	}

	public static TransactionResult<Organization> getOrganizationByName(
			final String pName) {
		TransactionResult<Organization> trRetorno = null;
		ResultSet rs = null;

		if (StringUtils.isNotEmpty(pName)) {
			try {
				conexionDB = UtilidadesBD.getConexionUtilidadesBD(
						Constantes.DATABASE, Constantes.URL, Constantes.USER,
						Constantes.PASSWORD);
				Statement statement = conexionDB.createStatement();
				String comando = "SELECT * FROM organization WHERE name="
						+ pName;
				rs = statement.executeQuery(comando);
				if (rs.next()) {
					Organization orgRetorno = new Organization(
							rs.getInt("organization_id"),
							rs.getString("national_identification"),
							rs.getString("name"), rs.getString("website"),
							rs.getString("description"),
							rs.getInt("country_id"));
					trRetorno = new TransactionResult<Organization>(orgRetorno,
							"OK");
				}
			} catch (Exception e) {
				trRetorno = new TransactionResult<Organization>(null,
						e.getMessage());
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				trRetorno = new TransactionResult<Organization>(null,
						e.getMessage());
			}
		}
		if (conexionDB != null) {
			try {
				conexionDB.close();
			} catch (SQLException e) {
				trRetorno = new TransactionResult<Organization>(null,
						e.getMessage());
			}
		}
		return trRetorno;
	}

	
	/**
	 * M&eacute;todo que retorna todas las organizaciones de la base de datos.
	 * 
	 * @return Resultado de la transacci&oacute;n con la lista de organizaciones en la base de datos.
	 */
	public static TransactionResult<List<Organization>> getAllOrganizations() {

		TransactionResult<List<Organization>> trRetorno = null;
		ResultSet rs = null;
		List<Organization> lstOrganizaciones = new ArrayList<Organization>();
		try {
			conexionDB = UtilidadesBD.getConexionUtilidadesBD(
					Constantes.DATABASE, Constantes.URL, Constantes.USER,
					Constantes.PASSWORD);
			Statement statement = conexionDB.createStatement();
			String comando = "SELECT * FROM organization";
			rs = statement.executeQuery(comando);

			while (rs.next()) {
				Organization orgRetorno = new Organization(
						rs.getInt("organization_id"),
						rs.getString("national_identification"),
						rs.getString("name"), rs.getString("website"),
						rs.getString("description"), rs.getInt("country_id"));
				lstOrganizaciones.add(orgRetorno);
			}

			trRetorno = new TransactionResult<List<Organization>>(
					lstOrganizaciones, "OK");

		} catch (Exception e) {
			trRetorno = new TransactionResult<List<Organization>>(null,
					e.getMessage());
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				trRetorno = new TransactionResult<List<Organization>>(null,
						e.getMessage());
			}
		}
		if (conexionDB != null) {
			try {
				conexionDB.close();
			} catch (SQLException e) {
				trRetorno = new TransactionResult<List<Organization>>(null,
						e.getMessage());
			}
		}
		return trRetorno;
	}

}
