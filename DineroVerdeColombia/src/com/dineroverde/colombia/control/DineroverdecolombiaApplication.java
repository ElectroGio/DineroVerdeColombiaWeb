package com.dineroverde.colombia.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;
import com.dineroverde.colombia.windows.*;
import com.google.gwt.user.client.WindowResizeListener;

/**
 * Main application class.
 */
public class DineroverdecolombiaApplication extends Application implements
HttpServletRequestListener {

	 private Boolean isAppRunningOnGAE;

	    public boolean isAppRunningOnGAE() {
	        if (isAppRunningOnGAE == null) {
	            return false;
	        }
	        return isAppRunningOnGAE;
	    }
	
	
	@Override
	public void init() {
		//Window mainWindow = new Window("Dineroverdecolombia Application");
		
		//WindowEntidadGeneral entidadGeneral = new WindowEntidadGeneral(null);
		WindowDiagramaEjecucionAnual ejecucionAnual = new WindowDiagramaEjecucionAnual();
		
		setTheme(Runo.THEME_NAME);
	//	WindowTestVaadin testdW = new WindowTestVaadin();
		
		//Label label = new Label("Hello Vaadin user Main");
		//mainWindow.addComponent(label);
	//	testWindow.addComponent(label);
	//	setMainWindow(testWindow);
		setMainWindow(new InvientChartsDemoWin());
	}


	public void onRequestStart(HttpServletRequest request,
			HttpServletResponse response) {
        if (isAppRunningOnGAE == null) {
            isAppRunningOnGAE = false;
            String serverInfo = request.getSession().getServletContext()
                    .getServerInfo();
            if (serverInfo != null && serverInfo.contains("Google")) {
                isAppRunningOnGAE = true;
            }
        }
    	}


	public void onRequestEnd(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}

