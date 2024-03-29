/*
 * Copyright 2011 Invient (www.invient.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.invient.vaadin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.action.GetBooleanAction;

import com.dineroverde.colombia.windows.WindowDiagramaEjecucionAnual;
import com.dineroverde.colombia.windows.WindowEntidadGeneral;
import com.dineroverde.colombia.windows.WindowMenuInicial;
import com.dineroverde.colombia.windows.WindowSuscripcionAlertas;
import com.dineroverde.colombia.windows.WindowTablaResumenDeContratos;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.themes.Runo;

@SuppressWarnings("serial")
public class InvientChartsDemoApp extends Application implements
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
    //	WindowEntidadGeneral entidadGeneral = new WindowEntidadGeneral(null);
    	WindowDiagramaEjecucionAnual diagramaEjecucionAnual = new WindowDiagramaEjecucionAnual();
    	WindowTablaResumenDeContratos tablaResumenContr = new WindowTablaResumenDeContratos();
    	WindowSuscripcionAlertas suscrip = new WindowSuscripcionAlertas();
    	WindowMenuInicial inicial = new WindowMenuInicial();
    	setTheme(Runo.THEME_NAME);
    	setMainWindow(inicial);
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

    }

}
