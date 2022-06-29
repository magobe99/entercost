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

import com.mycompany.app.daoImp.ProductoImp;
import com.mycompany.app.daoImp.ProyectoImp;
import com.mycompany.app.modelo.Producto;
import com.mycompany.app.modelo.Proyecto;



@Controller
@RequestMapping
public class ProductoController {
	
	@Autowired
	ProductoImp productoimp;
	@Autowired
	ProyectoImp proyectoImp;
	@GetMapping("/tablaproducto")
	public String Listar(Model model) {
		List<Producto>listProducto = this.productoimp.Buscartodos();
		model.addAttribute("listProducto",listProducto);
		return "tablaproducto";
	}
	
	@GetMapping("/regproducto")
    public String crearProducto (Model model){
		model.addAttribute("producto", new Producto());
		List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
		model.addAttribute("listProyecto",listProyecto);
        return "regproducto";
     }
	 @PostMapping("/guardarProducto")
   public String crearProducto(@Valid Producto producto, BindingResult result, Model model, RedirectAttributes atributo){
		if(result.hasErrors()) {
			List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
			model.addAttribute("listProyecto",listProyecto);
			return "regproducto";
		}
		productoimp.crearProducto(producto);
		atributo.addFlashAttribute("guardar", "Se ha registrado el producto con exito");
       return "redirect:/tablaproducto";
    }
	
	
	@GetMapping("/modificarProducto")
	public String editar(Producto producto, Model model) {
	Producto prod = new Producto();
	prod = productoimp.buscarById(producto.getId());
	model.addAttribute("producto",prod);
	List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
	model.addAttribute("listProyecto",listProyecto);
    return  "modificarproducto";
	}
	
	
	
	
	@PostMapping("/editarproducto")
	public String editarProducto(@Valid Producto producto, Model model, RedirectAttributes atributo) {
		productoimp.actualizarProducto(producto);
		List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
		model.addAttribute("listProyecto",listProyecto);
		atributo.addFlashAttribute("warning", "Se ha modificado el producto con exito");
        return "redirect:/tablaproducto";
	}
		
	
	@GetMapping("/eliminarProducto/{id}")
		public String delete(Model model, @PathVariable int id) {
		productoimp.delete(id);
		List<Proyecto> listProyecto = this.proyectoImp.Buscartodos();
		model.addAttribute("listProyecto",listProyecto);
		return "redirect/tablaproducto";
	}
}
