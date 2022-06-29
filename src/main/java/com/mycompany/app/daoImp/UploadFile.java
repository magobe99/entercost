package com.mycompany.app.daoImp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mycompany.app.modelo.Pago;
import com.mycompany.app.modelo.Proveedor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UploadFile { 
	@Autowired
	ProveedorImp proveedorImp;
	List<Proveedor> listProveedor = new ArrayList<>();
	@Autowired
	CompraImp compraImp;
	@Autowired
	PagoImp pagoImp;
	List<Pago> listPago = new ArrayList<>();
	
	public void guardarFile(MultipartFile path)throws IOException{
		
		System.out.println("fileC" + path.getOriginalFilename());
		InputStream file = path.getInputStream(); 
		XSSFWorkbook libroproveedor = new XSSFWorkbook(file);
		XSSFSheet hojaproveedor = libroproveedor.getSheetAt(0);
		Iterator<Row> filas = hojaproveedor.iterator();
		Iterator<Cell> celdas; 
		Row fila;
		Cell celda;
		filas.next();
		while (filas.hasNext()) { 
			fila = filas.next();
			celdas = fila.cellIterator();
			Proveedor proveedor = new Proveedor();
			while (celdas.hasNext()) {
				celda = celdas.next();
				int index = celda.getColumnIndex();
				switch (index) {
				case 0:{
					break;
				}
				case 1:{
					proveedor.setNombre(celda.toString());
					break;
				}
				case 2:{
					proveedor.setTelefono(celda.toString());
					break;
				}
				case 3:{
					proveedor.setCorreo(celda.toString());
					break;
				}
				case 4:{
					proveedor.setDireccion(celda.toString());
					break;
				}
					default:
					break;
				}
			}
			this.listProveedor.add(proveedor);
		}
		libroproveedor.close();
		this.proveedorImp.saveAll(listProveedor);
	}
	
}
