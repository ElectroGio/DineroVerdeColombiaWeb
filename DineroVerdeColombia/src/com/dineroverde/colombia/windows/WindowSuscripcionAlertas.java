package com.dineroverde.colombia.windows;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WindowSuscripcionAlertas extends Window {
	
	private VerticalLayout mainLayout;
	private Table tblSuscripciones;  
	private Panel pnlCorreo;
	private TextField txtCorreo;
	
	public WindowSuscripcionAlertas(){
		
		buildMainLayout();
		addPaneles();
		setLayout(mainLayout);
		
	}
	
	private void buildMainLayout(){
		mainLayout = new VerticalLayout();
		
		
		
	}

	private void addPaneles(){
		
		pnlCorreo = new Panel();
		Label lblTitulo = new Label("<b>Suscripción de alertas</b>");
		lblTitulo.setContentMode(Label.CONTENT_RAW);
		VerticalLayout hlPnlCorreo = new VerticalLayout();
		pnlCorreo.setContent(hlPnlCorreo);
		pnlCorreo.getContent().addComponent(lblTitulo);
		txtCorreo = new TextField("Ingrese su correo electrónico");
		
		pnlCorreo.getContent().addComponent(txtCorreo);
		
		Label lblInformacion = new Label("Por favor seleccione las alertas o grupo de alertas a las que se desea suscribir y presione el botón \"Suscribirse\"");
		lblInformacion.setContentMode(Label.CONTENT_RAW);
		pnlCorreo.getContent().addComponent(lblInformacion);
		
		mainLayout.addComponent(pnlCorreo);
		
		
		tblSuscripciones = new Table();
		//tblSuscripciones.setWidth("100%");
		//tblSuscripciones.setHeight("60%");
		tblSuscripciones.setSizeFull();
		tblSuscripciones.setSelectable(true);
		tblSuscripciones.setMultiSelect(false);
		tblSuscripciones.setImmediate(true);

		Container container = new IndexedContainer();
		container.addContainerProperty("Alerta", String.class, "");
		container.addContainerProperty("Fecha", String.class, "");
		container.addContainerProperty("Grupo", String.class, "");
		container.addContainerProperty("Nombre del Contrato", String.class,"");
		container.addContainerProperty("Entidad", String.class, "");
		//container.addContainerProperty("Valor Contrato", Double.class, "");
		//TODO poner checkbox en tabla.

		Object content[][] = { 
				{ "123456","21/01/2014","22/04/2014","Juan Carlos Muñoz","62544745", 2500000 },
				{ "352142","21/01/2014","22/04/2014","Carlos Andrés Molina","52141254", 10000000 },
				{ "85411225","21/01/2014","22/04/2014","Sara Marcela Medina","1152104221", 8000000 },
				{ "AB41511","21/01/2014","22/04/2014","David Ernesto Perez","65021412", 54253620.82 },
				{ "854521","21/01/2014","22/04/2014","Lorena Vallejo","58621001", 32000520 },
				             };
		for (Object[] row : content) {
			Item newItem = container.getItem(container.addItem());
			newItem.getItemProperty("Alerta").setValue(row[0]);
			newItem.getItemProperty("Fecha").setValue(row[1]);
			newItem.getItemProperty("Grupo").setValue(row[2]);
			newItem.getItemProperty("Nombre del Contrato").setValue(row[3]);
			newItem.getItemProperty("Entidad").setValue(row[4]);
			//newItem.getItemProperty("Valor Contrato").setValue(row[5]);
		}

		tblSuscripciones.setColumnReorderingAllowed(true);
		tblSuscripciones.setColumnCollapsingAllowed(true);
		//tblContratos.setVisibleColumns(new Object[]{"NroContrato","FechaInicio","FechaFin","NombreContratista","NIT","ValorContrato"});
		
	//	tblContratos.setColumnHeaders(new String[]{"Nro Contrato","Fecha Inicio","Fecha Fin", "Nombre Contratista","NIT","Valor Contrato"});
		
		
		tblSuscripciones.setContainerDataSource(container);
		
		mainLayout.addComponent(tblSuscripciones);
		
		
		
		
	}
	
}
