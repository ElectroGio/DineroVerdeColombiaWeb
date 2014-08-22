package com.dineroverde.colombia.windows;

import java.util.LinkedHashSet;

import javax.swing.text.html.parser.ContentModel;

import com.dineroverde.colombia.entidades.Organization;
import com.dineroverde.colombia.utilidades.Utilidades;
import com.invient.vaadin.InvientChartsDemoWin;
import com.invient.vaadin.charts.InvientCharts;
import com.invient.vaadin.charts.InvientChartsConfig;
import com.invient.vaadin.charts.InvientCharts.ChartClickEvent;
import com.invient.vaadin.charts.InvientCharts.ChartClickListener;
import com.invient.vaadin.charts.InvientCharts.ChartResetZoomEvent;
import com.invient.vaadin.charts.InvientCharts.ChartSVGAvailableEvent;
import com.invient.vaadin.charts.InvientCharts.ChartZoomEvent;
import com.invient.vaadin.charts.InvientCharts.ChartZoomListener;
import com.invient.vaadin.charts.InvientCharts.DateTimePoint;
import com.invient.vaadin.charts.InvientCharts.DateTimeSeries;
import com.invient.vaadin.charts.InvientCharts.DecimalPoint;
import com.invient.vaadin.charts.InvientCharts.PieChartLegendItemClickEvent;
import com.invient.vaadin.charts.InvientCharts.PointClickEvent;
import com.invient.vaadin.charts.InvientCharts.PointClickListener;
import com.invient.vaadin.charts.InvientCharts.PointRemoveEvent;
import com.invient.vaadin.charts.InvientCharts.PointSelectEvent;
import com.invient.vaadin.charts.InvientCharts.PointUnselectEvent;
import com.invient.vaadin.charts.InvientCharts.Series;
import com.invient.vaadin.charts.InvientCharts.SeriesClickEvent;
import com.invient.vaadin.charts.InvientCharts.SeriesHideEvent;
import com.invient.vaadin.charts.InvientCharts.SeriesLegendItemClickEvent;
import com.invient.vaadin.charts.InvientCharts.SeriesShowEvent;
import com.invient.vaadin.charts.InvientCharts.SeriesType;
import com.invient.vaadin.charts.InvientCharts.XYSeries;
import com.invient.vaadin.charts.InvientChartsConfig.AreaConfig;
import com.invient.vaadin.charts.InvientChartsConfig.AreaSplineConfig;
import com.invient.vaadin.charts.InvientChartsConfig.BarConfig;
import com.invient.vaadin.charts.InvientChartsConfig.CategoryAxis;
import com.invient.vaadin.charts.InvientChartsConfig.ChartLabel;
import com.invient.vaadin.charts.InvientChartsConfig.ColumnConfig;
import com.invient.vaadin.charts.InvientChartsConfig.DashStyle;
import com.invient.vaadin.charts.InvientChartsConfig.DataLabel;
import com.invient.vaadin.charts.InvientChartsConfig.DateTimeAxis;
import com.invient.vaadin.charts.InvientChartsConfig.HorzAlign;
import com.invient.vaadin.charts.InvientChartsConfig.ImageMarker;
import com.invient.vaadin.charts.InvientChartsConfig.Legend;
import com.invient.vaadin.charts.InvientChartsConfig.LineConfig;
import com.invient.vaadin.charts.InvientChartsConfig.MarkerState;
import com.invient.vaadin.charts.InvientChartsConfig.NumberXAxis;
import com.invient.vaadin.charts.InvientChartsConfig.NumberYAxis;
import com.invient.vaadin.charts.InvientChartsConfig.PieConfig;
import com.invient.vaadin.charts.InvientChartsConfig.PieDataLabel;
import com.invient.vaadin.charts.InvientChartsConfig.PointConfig;
import com.invient.vaadin.charts.InvientChartsConfig.Position;
import com.invient.vaadin.charts.InvientChartsConfig.ScatterConfig;
import com.invient.vaadin.charts.InvientChartsConfig.SeriesConfig;
import com.invient.vaadin.charts.InvientChartsConfig.SeriesState;
import com.invient.vaadin.charts.InvientChartsConfig.SplineConfig;
import com.invient.vaadin.charts.InvientChartsConfig.Stacking;
import com.invient.vaadin.charts.InvientChartsConfig.SymbolMarker;
import com.invient.vaadin.charts.InvientChartsConfig.Tooltip;
import com.invient.vaadin.charts.InvientChartsConfig.VertAlign;
import com.invient.vaadin.charts.InvientChartsConfig.XAxis;
import com.invient.vaadin.charts.InvientChartsConfig.XAxisDataLabel;
import com.invient.vaadin.charts.InvientChartsConfig.YAxis;
import com.invient.vaadin.charts.InvientChartsConfig.YAxisDataLabel;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.AxisTitle;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.AxisTitleAlign;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.DateTimePlotBand;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.Grid;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.MinorGrid;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.NumberPlotBand;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.NumberPlotLine;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.PlotLabel;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.Tick;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.TickmarkPlacement;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.DateTimePlotBand.DateTimeRange;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.NumberPlotBand.NumberRange;
import com.invient.vaadin.charts.InvientChartsConfig.AxisBase.NumberPlotLine.NumberValue;
import com.invient.vaadin.charts.InvientChartsConfig.ChartLabel.ChartLabelItem;
import com.invient.vaadin.charts.InvientChartsConfig.GeneralChartConfig.Margin;
import com.invient.vaadin.charts.InvientChartsConfig.GeneralChartConfig.Spacing;
import com.invient.vaadin.charts.InvientChartsConfig.GeneralChartConfig.ZoomType;
import com.invient.vaadin.charts.InvientChartsConfig.Legend.Layout;
import com.invient.vaadin.charts.InvientChartsConfig.SymbolMarker.Symbol;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Runo;
import com.invient.vaadin.charts.Color;
import com.invient.vaadin.charts.Color.RGB;
import com.invient.vaadin.charts.Color.RGBA;
import com.invient.vaadin.charts.Gradient;
import com.invient.vaadin.charts.Gradient.LinearGradient.LinearColorStop;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WindowEntidadGeneral extends Window {

	@AutoGenerated
	private GridLayout mainLayout;

	private Organization organization;

	// Paneles con nombre pnl_Fila_Columna Basado en 0 primero.
	private Panel pnl_0_0;
	private Panel pnl_0_1;
	private Panel pnl_1_0;
	private Panel pnl_1_1;
	private Panel pnl_2_0;
	private Panel pnl_2_1;
	private Panel pnl_3_0;
	private Panel pnl_3_1;
	private Panel pnl_4_0;
	private Panel pnl_4_1;
	private Panel pnl_5_0;
	private Panel pnl_5_1;
	private Panel pnl_6_0;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public WindowEntidadGeneral(final Organization pOrganization) {
		organization = pOrganization;
		buildMainLayout();
		generateMatrixGrid(8, 2);
		addPanels();
		setLayout(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private void buildMainLayout() {
		// the main layout and components will be created here
		mainLayout = new GridLayout();
		mainLayout.addStyleName("outlined");
		// mainLayout.setSizeFull();
		mainLayout.setHeight("150%");
		mainLayout.setWidth("100%");
	}

	private void generateMatrixGrid(final int rows, final int columns) {
		mainLayout.removeAllComponents();
		mainLayout.setRows(rows);
		mainLayout.setColumns(columns);
	}

	private void addPanels() {

		// Panel que tiene la información de la entidad.
		pnl_0_0 = new Panel();
		pnl_0_0.setScrollable(true);
		pnl_0_0.setSizeFull();
		/*String strInfoHTML = "<b>"+organization.getName()+"</b><br/><br/>"
				+ "La corporación <i>Lorem Ipsum</i> busca el bienestar de sus clientes dando  "
				+ "a conocer los resultados de su investigación relacionada con el medio ambiente.<br/>"
				+ "El contacto con esta corporación lo puede hacer con:"
				+ "<ul><li>Juan Hernán Gomez, administracion@corporacionloremipsum.com, 314-888-777</li>"
				+ "<li>Diana Marcela Perez, dmperez@corporacionloremipsum.com, 312-555-222</li>"
				+ "<li>Fernando Loaiza, floaiza@corporacionloremipsum.com, 318-000-777</li>"
				+ "</ul>";*/
		
		String strInfoHTML = "<b>"+organization.getName()+"</b><br/><br/>"+organization.getDescription();
		Label lblInfo = new Label(strInfoHTML);
		lblInfo.setContentMode(Label.CONTENT_RAW);
		pnl_0_0.addComponent(lblInfo);
		// Fin del panel

		// Panel que tiene los cuadros con información.

		GridLayout gridBotonesInfo = new GridLayout();
		gridBotonesInfo.removeAllComponents();
		gridBotonesInfo.setRows(2);
		gridBotonesInfo.setColumns(4);
		gridBotonesInfo.setSizeFull();
		gridBotonesInfo.setMargin(true, true, true, true);

		Button btnRecursosRecibidos = new Button();
		btnRecursosRecibidos.setHtmlContentAllowed(true);
		btnRecursosRecibidos.setWidth("90%");
		btnRecursosRecibidos
				.setCaption("<b>$20.785.152</b><br/>Recursos Recibidos");
		btnRecursosRecibidos.setStyleName(Runo.BUTTON_BIG);
		btnRecursosRecibidos.setStyleName(Runo.BUTTON_DEFAULT);

		btnRecursosRecibidos.addListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				InvientChartsDemoWin nuevaVentana = new InvientChartsDemoWin();
				nuevaVentana.setModal(true);
				showNotification("Recursos Recibidos");
				getParent().addWindow(nuevaVentana);
			}
		});

		Button btnRecursosEjecutados = new Button();
		btnRecursosEjecutados.setHtmlContentAllowed(true);
		btnRecursosEjecutados.setWidth("90%");
		btnRecursosEjecutados
				.setCaption("<b>$13.935.100</b><br/>Recursos Ejecutados");
		btnRecursosEjecutados.setStyleName(Runo.BUTTON_BIG);
		btnRecursosEjecutados.setStyleName(Runo.BUTTON_DEFAULT);

		Button btnRecursosPorEjecutar = new Button();
		btnRecursosPorEjecutar.setHtmlContentAllowed(true);
		btnRecursosPorEjecutar.setWidth("90%");
		btnRecursosPorEjecutar
				.setCaption("<b>$6.850.052</b><br/>Recursos por Ejecutar");
		btnRecursosPorEjecutar.setStyleName(Runo.BUTTON_BIG);
		btnRecursosPorEjecutar.setStyleName(Runo.BUTTON_DEFAULT);

		String yearBegin = "2007";
		String yearEnd = "2008";

		Button btnITN = new Button();
		btnITN.setHtmlContentAllowed(true);
		// btnITN.setHeight("90%");
		btnITN.setWidth("90%");
		btnITN.setCaption("<b>74,5</b><br/>ITN(" + yearBegin + "-" + yearEnd
				+ ")");
		btnITN.setStyleName(Runo.BUTTON_BIG);
		btnITN.setStyleName(Runo.BUTTON_DEFAULT);

		Button btnITN2 = new Button();
		btnITN2.setHtmlContentAllowed(true);
		btnITN2.setWidth("90%");
		btnITN2.setCaption("<b>72,3</b><br/>ITN(2006-2007)");
		btnITN2.setStyleName(Runo.BUTTON_BIG);
		btnITN2.setStyleName(Runo.BUTTON_DEFAULT);

		Button btnContratosLaborales = new Button();
		btnContratosLaborales.setHtmlContentAllowed(true);
		btnContratosLaborales.setWidth("90%");
		btnContratosLaborales.setCaption("<b>352</b><br/>Contratos Laborales");
		btnContratosLaborales.setStyleName(Runo.BUTTON_BIG);
		btnContratosLaborales.setStyleName(Runo.BUTTON_DEFAULT);

		Button btnContratosDeServicio = new Button();
		btnContratosDeServicio.setHtmlContentAllowed(true);
		btnContratosDeServicio.setWidth("90%");
		btnContratosDeServicio
				.setCaption("<b>1.102</b></br>Contratos de Servicios");
		btnContratosDeServicio.setStyleName(Runo.BUTTON_BIG);
		btnContratosDeServicio.setStyleName(Runo.BUTTON_DEFAULT);

		Button btnConvenios = new Button();
		btnConvenios.setHtmlContentAllowed(true);
		btnConvenios.setWidth("90%");
		btnConvenios.setCaption("<b>20</b><br/>Convenios");
		btnConvenios.setStyleName(Runo.BUTTON_BIG);
		btnConvenios.setStyleName(Runo.BUTTON_DEFAULT);

		gridBotonesInfo.addComponent(btnRecursosRecibidos);
		gridBotonesInfo.addComponent(btnRecursosEjecutados);
		gridBotonesInfo.addComponent(btnRecursosPorEjecutar);
		gridBotonesInfo.addComponent(btnITN);
		gridBotonesInfo.addComponent(btnITN2);
		gridBotonesInfo.addComponent(btnContratosLaborales);
		gridBotonesInfo.addComponent(btnContratosDeServicio);
		gridBotonesInfo.addComponent(btnConvenios);
		pnl_1_0 = new Panel();
		pnl_1_0.setSizeFull();
		pnl_1_0.setContent(gridBotonesInfo);
		// Fin Panel Información;

		/*
		 * pnl_1_1 = new Panel(); pnl_1_1.setSizeFull();
		 * pnl_1_1.addComponent(new Button("1-1"));
		 */

		pnl_2_0 = new Panel();
		pnl_2_0.setSizeFull();
		VerticalLayout vlPanel20 = new VerticalLayout();
		vlPanel20.setSizeFull();
		pnl_2_0.setContent(vlPanel20);
		InvientCharts grafico = generarGrafico();
		grafico.setHeight("100%");
		grafico.setWidth("100%");
		pnl_2_0.getContent().addComponent(grafico);

		pnl_2_1 = new Panel();
		VerticalLayout vlPnl21 = new VerticalLayout();
		vlPnl21.setSizeFull();
		pnl_2_1.setContent(vlPnl21);
		pnl_2_1.setSizeFull();
		// Recurso externo
		URL url;
		try {
			url = new URL("http://bost.ocks.org/mike/sankey/");
			Embedded browser = new Embedded("", new ExternalResource(url));
			browser.setType(Embedded.TYPE_BROWSER);
			browser.setSizeFull();
			pnl_2_1.getContent().addComponent(browser);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pnl_2_1.addComponent(new Button("2-1"));

		pnl_3_0 = new Panel();
		pnl_3_0.setSizeFull();
		pnl_3_0.addComponent(new Button("3-0"));

		// pnl_3_1 = new Panel();
		// pnl_3_1.addComponent(new Button("3-1"));

		pnl_4_0 = new Panel();
		VerticalLayout vlPnl40 = new VerticalLayout();
		vlPnl40.setSizeFull();
		pnl_4_0.setSizeFull();
		pnl_4_0.setContent(vlPnl40);
		URL urlMap;
		try {
			urlMap = new URL("http://d3.artzub.com/wbca/");
			Embedded browser = new Embedded("", new ExternalResource(urlMap));
			browser.setType(Embedded.TYPE_BROWSER);
			browser.setSizeFull();
			pnl_4_0.getContent().addComponent(browser);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pnl_4_0.addComponent(new Button("Clic para información"));

		pnl_4_1 = new Panel();
		VerticalLayout vlPnl41 = new VerticalLayout();
		vlPnl41.setSizeFull();
		pnl_4_1.setSizeFull();
		pnl_4_1.setContent(vlPnl41);
		URL urlTetris;
		try {
			urlTetris = new URL("http://d3tetris.herokuapp.com/");
			Embedded browser = new Embedded("", new ExternalResource(urlTetris));
			browser.setType(Embedded.TYPE_BROWSER);
			browser.setSizeFull();
			pnl_4_1.getContent().addComponent(browser);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// pnl_4_1.addComponent(new Button("4-1"));

		// http://d3tetris.herokuapp.com/

		pnl_5_0 = new Panel();
		pnl_5_0.setSizeFull();
		pnl_5_0.addComponent(new Button("5-0"));

		pnl_5_1 = new Panel();
		pnl_5_1.setSizeFull();
		pnl_5_1.addComponent(new Button("5-1"));

		// pnl_4_1 = new Panel();
		// pnl_4_1.addComponent(new Button("4-1"));

		// pnl_0_0.setHeight("200%");
		// pnl_1_0.setHeight("200%");
		// pnl_2_0.setHeight("200%");
		// pnl_3_0.setHeight("200%");
		// pnl_4_0.setHeight("200%");

		// pnl_0_1.setHeight("200%");
		// pnl_1_1.setHeight("200%");
		// pnl_2_1.setHeight("200%");
		// pnl_3_1.setHeight("200%");
		// pnl_4_1.setHeight("200%");

		// Ocupacion de paneles tipo
		// componente,columna,fila,ocupColumna,ocupFila
		mainLayout.addComponent(pnl_0_0, 0, 0, 1, 0);
		// mainLayout.addComponent(pnl_0_1);
		mainLayout.addComponent(pnl_1_0, 0, 1, 1, 1);
		// mainLayout.addComponent(pnl_1_1, 1, 1, 1, 2);
		mainLayout.addComponent(pnl_2_0, 0, 2, 0, 3);
		mainLayout.addComponent(pnl_2_1, 1, 2, 1, 3);
		mainLayout.addComponent(pnl_4_0, 0, 4, 0, 5);
		mainLayout.addComponent(pnl_4_1, 1, 4, 1, 5);
		mainLayout.addComponent(pnl_5_0, 0, 6, 1, 6);

		mainLayout.setMargin(false, true, true, true);

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

	private static LinkedHashSet<DecimalPoint> getPoints(Series series,
			double[]... values) {
		LinkedHashSet<DecimalPoint> points = new LinkedHashSet<DecimalPoint>();
		for (double[] value : values) {
			Double x, y = null;
			if (value.length == 0)
				continue;
			if (value.length == 2) {
				x = value[0];
				y = value[1];
			} else {
				x = value[0];
			}
			points.add(new DecimalPoint(series, x, y));
		}
		return points;
	}

}
