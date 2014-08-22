package com.dineroverde.colombia.windows;

import java.util.Arrays;
import java.util.LinkedHashSet;

import com.dineroverde.colombia.utilidades.Utilidades;
import com.google.gwt.dev.util.BrowserInfo;
import com.invient.vaadin.charts.InvientCharts;
import com.invient.vaadin.charts.InvientChartsConfig;
import com.invient.vaadin.charts.Color.RGB;
import com.invient.vaadin.charts.InvientCharts.SeriesType;
import com.invient.vaadin.charts.InvientCharts.XYSeries;
import com.invient.vaadin.charts.InvientChartsConfig.CategoryAxis;
import com.invient.vaadin.charts.InvientChartsConfig.HorzAlign;
import com.invient.vaadin.charts.InvientChartsConfig.Legend;
import com.invient.vaadin.charts.InvientChartsConfig.LineConfig;
import com.invient.vaadin.charts.InvientChartsConfig.NumberYAxis;
import com.invient.vaadin.charts.InvientChartsConfig.Position;
import com.invient.vaadin.charts.InvientChartsConfig.VertAlign;
import com.invient.vaadin.charts.InvientChartsConfig.XAxis;
import com.invient.vaadin.charts.InvientChartsConfig.YAxis;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.AxisTitle;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.NumberPlotLine;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.NumberPlotLine.NumberValue;
import com.invient.vaadin.charts.InvientChartsConfig.GeneralChartConfig.Margin;
import com.invient.vaadin.charts.InvientChartsConfig.Legend.Layout;
import com.vaadin.terminal.Terminal;
import com.vaadin.terminal.gwt.server.WebBrowser;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

public class WindowDiagramaEjecucionAnual extends Window {

	private GridLayout mainLayout;

	private Panel pnlDescripcion;
	private Panel pnlGrafico;
	private Panel pnlComparar;
	private Panel pnlDocsRelacionados;
	private int altoPantalla;

	public WindowDiagramaEjecucionAnual() {
		buildMainLayout();
		generateMatrixGrid(4, 1);
		addPanels();
		setLayout(mainLayout);
		//WebBrowser browser = this.getApplication().getContext().
		//int valor = browser.getScreenHeight();
	//	altoPantalla = browser.getBrowserWindowHeight();
	}

	private void buildMainLayout() {
		// TODO Auto-generated method stub
		//this.setSizeFull();
		mainLayout = new GridLayout();
		mainLayout.addStyleName("outlined");
		// mainLayout.setSizeFull();
		//mainLayout.setHeight("100%");
		//mainLayout.setWidth("100%");
		mainLayout.setWidth("100%");
		setHeight("100%");
	}

	private void addPanels() {
		// TODO Auto-generated method stub
		pnlDescripcion = new Panel();
		pnlDescripcion.setScrollable(true);
		// pnlDescripcion.setSizeFull();
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
		// Calcular el tamaño
		double alturaDescripcion = altoPantalla * 0.20;
		// String alturaDescripcionPixeles = Math.round(alturaDescripcion) +
		// "px";

	//	pnlDescripcion.setHeight("20%");
		pnlDescripcion.setWidth("100%");
		pnlDescripcion.addComponent(lblInfo);

		mainLayout.addComponent(pnlDescripcion);

		pnlGrafico = new Panel();
		pnlGrafico.setScrollable(false);
		InvientCharts grafico = generarGrafico();
		grafico.setSizeFull();
		// grafico.setHeight("100%");
		// grafico.setWidth("100%");
		pnlGrafico.getContent().addComponent(grafico);
	//	pnlGrafico.setHeight("25%");
		pnlGrafico.setWidth("100%");
		mainLayout.addComponent(pnlGrafico);

		pnlComparar = new Panel();
		ComboBox cbxYearOne = new ComboBox();
		cbxYearOne.addItem("2010");
		cbxYearOne.addItem("2011");
		cbxYearOne.addItem("2012");
		cbxYearOne.addItem("2013");
		cbxYearOne.addItem("2014");

		ComboBox cbxYearTwo = new ComboBox();
		cbxYearTwo.addItem("2010");
		cbxYearTwo.addItem("2011");
		cbxYearTwo.addItem("2012");
		cbxYearTwo.addItem("2013");
		cbxYearTwo.addItem("2014");

		ComboBox cbxYearThree = new ComboBox();
		cbxYearThree.addItem("2010");
		cbxYearThree.addItem("2011");
		cbxYearThree.addItem("2012");
		cbxYearThree.addItem("2013");
		cbxYearThree.addItem("2014");

		ComboBox cbxYearFour = new ComboBox();
		cbxYearFour.addItem("2010");
		cbxYearFour.addItem("2011");
		cbxYearFour.addItem("2012");
		cbxYearFour.addItem("2013");
		cbxYearFour.addItem("2014");

		Button btnComparar = new Button("Comparar");

		HorizontalLayout layoutYears = new HorizontalLayout();
		layoutYears.setSizeFull();

		String infoComparar = "<b>Comparar años (máx 4):</b>";
		Label lblComparar = new Label(infoComparar);
		lblComparar.setContentMode(Label.CONTENT_RAW);

		layoutYears.addComponent(lblComparar);
		layoutYears.addComponent(cbxYearOne);
		layoutYears.addComponent(cbxYearTwo);
		layoutYears.addComponent(cbxYearThree);
		layoutYears.addComponent(cbxYearFour);
		layoutYears.addComponent(btnComparar);

		pnlComparar.setContent(layoutYears);

	//	pnlComparar.setHeight("25%");
		pnlComparar.setWidth("100%");

		mainLayout.addComponent(pnlComparar);

		pnlDocsRelacionados = new Panel();
		pnlDocsRelacionados.setSizeFull();
		pnlDocsRelacionados.getContent().addComponent(
				new Button("Docs Relacionados"));
	//	pnlDocsRelacionados.setHeight("30%");
		pnlDocsRelacionados.setWidth("100%");
		mainLayout.addComponent(pnlDocsRelacionados);
	}

	private void generateMatrixGrid(final int rows, final int columns) {
		mainLayout.removeAllComponents();
		mainLayout.setRows(rows);
		mainLayout.setColumns(columns);
	}

	private InvientCharts generarGrafico() {

		InvientChartsConfig chartConfig = new InvientChartsConfig();
		chartConfig.getGeneralChartConfig().setType(SeriesType.LINE);
		chartConfig.getGeneralChartConfig().setMargin(new Margin());
		chartConfig.getGeneralChartConfig().getMargin().setRight(130);
		chartConfig.getGeneralChartConfig().getMargin().setBottom(25);

		chartConfig.getTitle().setX(-20);
		chartConfig.getTitle().setText(
				"Ejecución Presupuestal por ciudades año 2014");
		chartConfig.getSubtitle().setText("Fuente: FONAM");
		chartConfig.getTitle().setX(-20);

		CategoryAxis categoryAxis = new CategoryAxis();
		categoryAxis.setCategories(Arrays.asList("Ene", "Feb", "Mar", "Abr",
				"May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"));
		LinkedHashSet<XAxis> xAxesSet = new LinkedHashSet<InvientChartsConfig.XAxis>();
		xAxesSet.add(categoryAxis);
		chartConfig.setXAxes(xAxesSet);

		NumberYAxis numberYAxis = new NumberYAxis();
		numberYAxis.setTitle(new AxisTitle("Millones de Pesos (COP)"));
		NumberPlotLine plotLine = new NumberPlotLine("TempAt0");
		plotLine.setValue(new NumberValue(0.0));
		plotLine.setWidth(1);
		plotLine.setZIndex(1);
		plotLine.setColor(new RGB(128, 128, 128));
		numberYAxis.addPlotLine(plotLine);
		LinkedHashSet<YAxis> yAxesSet = new LinkedHashSet<InvientChartsConfig.YAxis>();
		yAxesSet.add(numberYAxis);
		chartConfig.setYAxes(yAxesSet);

		Legend legend = new Legend();
		legend.setLayout(Layout.VERTICAL);
		Position legendPos = new Position();
		legendPos.setAlign(HorzAlign.RIGHT);
		legendPos.setVertAlign(VertAlign.TOP);
		legendPos.setX(-10);
		legendPos.setY(100);
		legend.setPosition(legendPos);
		legend.setBorderWidth(0);
		chartConfig.setLegend(legend);

		// Series data label formatter
		LineConfig lineCfg = new LineConfig();
		chartConfig.addSeriesConfig(lineCfg);
		// Tooltip formatter
		chartConfig
				.getTooltip()
				.setFormatterJsFunc(
						"function() { "
								+ " return '<b>' + this.series.name + '</b><br/>' +  this.x + ': '+ this.y +'Â°C'"
								+ "}");

		InvientCharts chart = new InvientCharts(chartConfig);

		XYSeries seriesData = new XYSeries("Bogota");
		seriesData.setSeriesPoints(Utilidades.getPoints(seriesData, 7.0, 6.9,
				9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6));
		chart.addSeries(seriesData);

		seriesData = new XYSeries("Medellin");
		seriesData.setSeriesPoints(Utilidades.getPoints(seriesData, -0.2, 0.8,
				5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5));
		chart.addSeries(seriesData);

		seriesData = new XYSeries("Cali");
		seriesData.setSeriesPoints(Utilidades.getPoints(seriesData, -0.9, 0.6,
				3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0));
		chart.addSeries(seriesData);

		seriesData = new XYSeries("Guajira");
		seriesData.setSeriesPoints(Utilidades.getPoints(seriesData, 3.9, 4.2,
				5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8));
		chart.addSeries(seriesData);

		return chart;

	}

	public String devuelvePixeles(final int alturaPantalla,
			final double porcentaje) {
		String retorno = "";
		double valor = alturaPantalla * porcentaje;
		retorno = Math.round(valor) + "px";
		return retorno;
	}

}
