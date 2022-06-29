package com.mycompany.app.controller;

import java.io.FileInputStream;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.mycompany.app.daoImp.ProveedorImp;
import com.mycompany.app.repositorio.InventarioRepositorio;
import com.mycompany.app.repositorio.PedidoRepositorio;
import com.mycompany.app.repositorio.ProductoRepositorio;
import com.mycompany.app.repositorio.ProveedorRepositorio;
import com.mycompany.app.repositorio.ProyectoRepositorio;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Controller

public class ReporteController {
	
	@Autowired
	private ProveedorRepositorio proveedorRepositorio;
	@Autowired
	ProveedorImp proveedorImp;
	@Autowired
	private ProyectoRepositorio proyectoRepositorio;
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	@Autowired
	private ProductoRepositorio productoRepositorio;
	@Autowired
	private InventarioRepositorio inventarioRepositorio;
	
	@GetMapping("/pdfproveedor")
	public ResponseEntity<byte[]> generarpdf() throws Exception, JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(proveedorRepositorio.findAll());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Proveedor.jrxml"));	
		HashMap<String, Object> map = new HashMap<>();
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
		//JasperExportManager.exportReportToPdfFile(Reporte, "Pro.pdf");
		
		byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
		 
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=proveedor.pdf");
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
}
	
	@GetMapping("/pdfproyecto")
	public ResponseEntity<byte[]> proyectopdf() throws Exception, JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(proyectoRepositorio.findAll());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Proyecto.jrxml"));	
		HashMap<String, Object> map = new HashMap<>();
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
		//JasperExportManager.exportReportToPdfFile(Reporte, "Pro.pdf");
		
		byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
		 
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=proyecto.pdf");
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
}
	
	@GetMapping("/pdfpedido")
	public ResponseEntity<byte[]> pedidopdf() throws Exception, JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(pedidoRepositorio.findAll());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Pedido.jrxml"));	
		HashMap<String, Object> map = new HashMap<>();
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
		//JasperExportManager.exportReportToPdfFile(Reporte, "Pro.pdf");
		
		byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
		 
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=pedido.pdf");
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
}
	
	@GetMapping("/pdfproducto")
	public ResponseEntity<byte[]> productopdf() throws Exception, JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(productoRepositorio.findAll());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Producto.jrxml"));	
		HashMap<String, Object> map = new HashMap<>();
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
		//JasperExportManager.exportReportToPdfFile(Reporte, "Pro.pdf");
		
		byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
		 
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=producto.pdf");
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
}
	
	@GetMapping("/pdfinventario")
	public ResponseEntity<byte[]> inventariopdf() throws Exception, JRException{
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(inventarioRepositorio.findAll());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Inventario.jrxml"));	
		HashMap<String, Object> map = new HashMap<>();
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
		//JasperExportManager.exportReportToPdfFile(Reporte, "Pro.pdf");
		
		byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
		 
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=producto.pdf");
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
}
	
}
