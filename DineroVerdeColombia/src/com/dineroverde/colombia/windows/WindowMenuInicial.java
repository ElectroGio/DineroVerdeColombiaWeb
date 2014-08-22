package com.dineroverde.colombia.windows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.dineroverde.colombia.basedatos.*;
import com.dineroverde.colombia.dao.OrganizationDAO;
import com.dineroverde.colombia.entidades.Organization;

public class WindowMenuInicial extends Window {

	VerticalLayout mainLayout;
	Panel pnlInformacion;
	Panel pnlEntidades;
	private List<Organization> lstOrganization;

	public WindowMenuInicial() {

		cargarOrganizaciones();

		buildMainLayout();
		addPaneles();
		setLayout(mainLayout);

	}

	private void cargarOrganizaciones() {

		TransactionResult<List<Organization>> trOrganization = OrganizationDAO
				.getAllOrganizations();
		if (trOrganization != null) {
			lstOrganization = trOrganization.getContenido();
		}

	}

	private void buildMainLayout() {
		mainLayout = new VerticalLayout();
	}

	private void addPaneles() {

		pnlInformacion = new Panel();
		pnlEntidades = new Panel();
		pnlInformacion.setSizeFull();
		pnlEntidades.setSizeFull();

		// Hacer parte información.

		mainLayout.addComponent(pnlInformacion);

		// Hacer parte entidades.
		GridLayout hlPnl = new GridLayout();
		hlPnl.setColumns(10);
		pnlEntidades.setContent(hlPnl);
		pnlEntidades.getContent().setWidth("100%");

		if (lstOrganization != null && lstOrganization.size() > 0) {
			for (final Organization organizacion : lstOrganization) {
				Button btnOrganizacion = new Button(organizacion.getName());
				btnOrganizacion.addListener(new ClickListener() {
					/**
					 * Serial version
					 */
					private static final long serialVersionUID = 1L;
					public void buttonClick(ClickEvent event) {
						// TODO Auto-generated method stub
						WindowEntidadGeneral wdwEntidadGeneral = new  WindowEntidadGeneral(organizacion);
						wdwEntidadGeneral.setModal(false);
						wdwEntidadGeneral.setResizable(true);
						wdwEntidadGeneral.setScrollable(true);
						wdwEntidadGeneral.setDraggable(true);
						wdwEntidadGeneral.setSizeFull();
						addWindow(wdwEntidadGeneral);
					}
				});
				pnlEntidades.getContent().addComponent(btnOrganizacion);
			}

		} else {
			Label lblInfo = new Label(
					"<b>No existen organizaciones registradas.</b>");
			lblInfo.setContentMode(Label.CONTENT_RAW);
			pnlEntidades.getContent().addComponent(lblInfo);
		}

		mainLayout.addComponent(pnlEntidades);

	}
}
