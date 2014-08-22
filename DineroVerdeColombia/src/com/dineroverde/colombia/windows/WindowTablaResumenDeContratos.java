package com.dineroverde.colombia.windows;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WindowTablaResumenDeContratos extends Window {

	private Table tblContratos;
	private Panel pnlInfo;
	private Panel pnlDocumentosRelacionados;
	private VerticalLayout mainLayout;

	public WindowTablaResumenDeContratos() {
		buildMainLayout();
		addPanels();
	}

	private void buildMainLayout() {
		// TODO Auto-generated method stub
		mainLayout = new VerticalLayout();
		//mainLayout.setHeight("100%");
		setLayout(mainLayout);
	}

	private void addPanels() {
		// TODO Auto-generated method stub
		pnlInfo = new Panel();
		pnlInfo.setScrollable(true);
		String strInfoHTML = "<b>Corporación Lorem Ipsum</b><br/><br/>"
				+ "La corporación <i>Lorem Ipsum</i> busca el bienestar de sus clientes dando  "
				+ "a conocer los resultados de su investigación relacionada con el medio ambiente.<br/>"
				+ "El contacto con esta corporación lo puede hacer con:"
				+ "<ul><li>Juan Hernán Gomez, administracion@corporacionloremipsum.com, 314-888-777</li>"
				+ "<li>Diana Marcela Perez, dmperez@corporacionloremipsum.com, 312-555-222</li>"
				+ "<li>Fernando Loaiza, floaiza@corporacionloremipsum.com, 318-000-777</li>"
				+ "</ul>";
		Label lblInfo = new Label(strInfoHTML);
		lblInfo.setContentMode(Label.CONTENT_RAW);
		pnlInfo.addComponent(lblInfo);
		pnlInfo.setWidth("100%");
		pnlInfo.setHeight("20%");
		mainLayout.addComponent(pnlInfo);

		tblContratos = new Table();
		tblContratos.setWidth("100%");
		tblContratos.setHeight("60%");
		tblContratos.setSelectable(true);
		tblContratos.setMultiSelect(false);
		tblContratos.setImmediate(true);

		Container container = new IndexedContainer();
		container.addContainerProperty("Nro Contrato", String.class, "");
		container.addContainerProperty("Fecha Inicio", String.class, "");
		container.addContainerProperty("Fecha Fin", String.class, "");
		container.addContainerProperty("Nombre de Contratista", String.class,
				"");
		container.addContainerProperty("NIT / C.C", String.class, "");
		container.addContainerProperty("Valor Contrato", Double.class, "");

		Object content[][] = { 
				{ "123456","21/01/2014","22/04/2014","Juan Carlos Muñoz","62544745", 2500000 },
				{ "352142","21/01/2014","22/04/2014","Carlos Andrés Molina","52141254", 10000000 },
				{ "85411225","21/01/2014","22/04/2014","Sara Marcela Medina","1152104221", 8000000 },
				{ "AB41511","21/01/2014","22/04/2014","David Ernesto Perez","65021412", 54253620.82 },
				{ "854521","21/01/2014","22/04/2014","Lorena Vallejo","58621001", 32000520 },
				             };
		for (Object[] row : content) {
			Item newItem = container.getItem(container.addItem());
			newItem.getItemProperty("Nro Contrato").setValue(row[0]);
			newItem.getItemProperty("Fecha Inicio").setValue(row[1]);
			newItem.getItemProperty("Fecha Fin").setValue(row[2]);
			newItem.getItemProperty("Nombre de Contratista").setValue(row[3]);
			newItem.getItemProperty("NIT / C.C").setValue(row[4]);
			newItem.getItemProperty("Valor Contrato").setValue(row[5]);
		}

		tblContratos.setColumnReorderingAllowed(true);
		tblContratos.setColumnCollapsingAllowed(true);
		//tblContratos.setVisibleColumns(new Object[]{"NroContrato","FechaInicio","FechaFin","NombreContratista","NIT","ValorContrato"});
		
	//	tblContratos.setColumnHeaders(new String[]{"Nro Contrato","Fecha Inicio","Fecha Fin", "Nombre Contratista","NIT","Valor Contrato"});
		
		
		tblContratos.setContainerDataSource(container);
		
		mainLayout.addComponent(tblContratos);
		
		pnlDocumentosRelacionados = new Panel();
		pnlDocumentosRelacionados.addComponent(new Button("Docs relacionados"));
		
		pnlDocumentosRelacionados.setHeight("20%");
		pnlDocumentosRelacionados.setWidth("100%");

		mainLayout.addComponent(pnlDocumentosRelacionados);
	}

}
