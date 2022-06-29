package com.mycompany.app.controller;

import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.mycompany.app.daoImp.CompraImp;
import com.mycompany.app.daoImp.PagoImp;
import com.mycompany.app.daoImp.PresupuestoImp;
import com.mycompany.app.daoImp.ProveedorImp;
import com.mycompany.app.daoImp.UploadFile;
import com.mycompany.app.modelo.Proveedor;


@Controller
public class UploadFileController {
	@Autowired
	UploadFile uploadFile;
	@Autowired
	ProveedorImp proveedorImp;
	@Autowired
	PagoImp pagoImp;
	@Autowired
	CompraImp compraImp;
	@Autowired
	PresupuestoImp presupuestoImp;
	
	@RequestMapping("/uploadFile")
	public String saveFileExcel(MultipartFile file, Model model)throws IOException{
		this.uploadFile.guardarFile(file);
		List<Proveedor> listProveedor = this.proveedorImp.Buscar();
		model.addAttribute("listProveedor",listProveedor);
		return "redirect:tablaproveedor";
	}
	
	
	
	

}
