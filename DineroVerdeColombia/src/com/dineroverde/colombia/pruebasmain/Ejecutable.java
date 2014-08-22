package com.dineroverde.colombia.pruebasmain;

import java.util.List;

import com.dineroverde.colombia.basedatos.TransactionResult;
import com.dineroverde.colombia.dao.*;
import com.dineroverde.colombia.entidades.Organization;

public class Ejecutable {

	public static void main(String[] args) {
		
		//Agregar una nueva organizaci�n:
		Organization newOrganization = new Organization(4,"COL123TEST","Organizaci�n JAVA TEST","www.google.com", "Organizaci�n para test desde app consola Java", 57);
		TransactionResult<Boolean> trAdd = OrganizationDAO.addOrganization(newOrganization);
		
		if(trAdd != null){
			System.out.println(trAdd.getMensaje());
		}
		
		TransactionResult<List<Organization>> trResult = OrganizationDAO
				.getAllOrganizations();
		if (trResult != null) {
			List<Organization> lstOrg = trResult.getContenido();
			for (Organization organization : lstOrg) {
				System.out.println("Resultado: " + organization.getName());
			}
		}
	}
}
