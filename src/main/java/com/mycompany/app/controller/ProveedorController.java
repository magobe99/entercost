package com.mycompany.app.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.app.daoImp.ProveedorImp;
import com.mycompany.app.modelo.Proveedor;
import com.mycompany.app.repositorio.ProveedorRepositorio;


@Controller
@RequestMapping
public class ProveedorController {
	
	@Autowired
	ProveedorImp proveedorImp;
	@Autowired
	private ProveedorRepositorio proveedorRepositorio;
	
	
	
	@GetMapping("/tablaproveedor")
	public String Listar(Model model) {
		List<Proveedor> listProveedor = this.proveedorImp.Buscar();
		model.addAttribute("listProveedor", listProveedor);
		return "tablaproveedor";
	}
	
	@GetMapping("/regproveedor")
    public String crearProveedor (Model model){
		model.addAttribute("proveedor",new Proveedor());
        return "regproveedor";  
     }
	
	@PostMapping("/guardarProveedor")
    public String crearProveedor(@Valid Proveedor proveedor, BindingResult result, Model model, RedirectAttributes attribute){
		if(result.hasErrors()) {
			return "regproveedor";
		}
        proveedorImp.crearProveedor(proveedor);
        attribute.addFlashAttribute("success", "Proveedor guardado con exito");
        return "redirect:/tablaproveedor";
    }
	
	@GetMapping("/modificarProveedor")
	public String editar(Proveedor proveedor, Model model) {
		Proveedor prove = new Proveedor();
		prove=proveedorImp.buscarById(proveedor.getId());
		model.addAttribute("proveedor",prove);
		return "modificarproveedor";
	}
	
	@PostMapping("/editarProveedor")
    public String editarProveedor(@Valid Proveedor proveedor, Model model, RedirectAttributes attribute){
        proveedorImp.actualizarProveedor(proveedor);
        attribute.addFlashAttribute("warning", "Proveedor modificado con exito");
        return "redirect:/tablaproveedor";
    }
	
	@GetMapping("/eliminarProveedor/{id}")
	public String delete(Model model, RedirectAttributes attribute, @PathVariable int id) {
		proveedorImp.delete(id);
		attribute.addFlashAttribute("danger", "Proveedor eliminado con exito");
		return "redirect:/tablaproveedor";
	}
	

}
