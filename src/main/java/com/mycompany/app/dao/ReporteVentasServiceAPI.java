package com.mycompany.app.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.mycompany.app.modelo.ReporteVentasDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteVentasServiceAPI {
	
	
	ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException;

	ReporteVentasDTO obtenerReporteInventario(Map<String, Object> params) throws JRException, IOException, SQLException;

	ReporteVentasDTO obtenerReporteCompras(Map<String, Object> params) throws JRException, IOException, SQLException;

	ReporteVentasDTO obtenerReportePedido(Map<String, Object> params) throws JRException, IOException, SQLException;

	

}
