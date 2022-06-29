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

import com.mycompany.app.daoImp.CompraImp;
import com.mycompany.app.daoImp.PedidoImp;
import com.mycompany.app.daoImp.ProductoImp;
import com.mycompany.app.modelo.Compra;
import com.mycompany.app.modelo.Pedido;
import com.mycompany.app.modelo.Producto;


@Controller
@RequestMapping
public class PedidoController {
	
	@Autowired
	PedidoImp pedidoImp;
	@Autowired
	ProductoImp productoImp;
	@Autowired
	CompraImp compraImp;
	@GetMapping("/tablapedido")
	public String Listar(Model model) {
		List<Pedido> listPedido = this.pedidoImp.Buscartodos();
		model.addAttribute("listPedido", listPedido);
		return "tablapedido";
	}
	
	@GetMapping("/regpedido")
    public String crearPedido (Model model){
		model.addAttribute("pedido", new Pedido());
		List<Producto> listProducto = this.productoImp.Buscartodos();
		model.addAttribute("listProducto", listProducto);
		List<Compra> listCompra = this.compraImp.Buscartodos();
		model.addAttribute("listCompra", listCompra);
        return "regpedido";  
     }
	
	
	@PostMapping("/guardarPedido")
   public String crearPedido(@Valid Pedido pedido, BindingResult result, Model model, RedirectAttributes atributo){
		if(result.hasErrors()) {
			List<Producto> listProducto = this.productoImp.Buscartodos();
			model.addAttribute("listProducto", listProducto);
			List<Compra> listCompra = this.compraImp.Buscartodos();
			model.addAttribute("listCompra", listCompra);
			return "regpedido";
		}
		pedidoImp.crearPedido(pedido);
		atributo.addFlashAttribute("guardar", "Pedido se guardo con exito");
       return "redirect:/tablapedido";
    }
	
	
	@GetMapping("/modificarPedido")
	public String editar(Pedido pedido, Model model) {
	Pedido ped = new Pedido();
	ped = pedidoImp.buscarById(pedido.getId());
	model.addAttribute("pedido",ped);
	List<Producto> listProducto = this.productoImp.Buscartodos();
	model.addAttribute("listProducto", listProducto);
	List<Compra> listCompra = this.compraImp.Buscartodos();
	model.addAttribute("listCompra", listCompra);
		return "modificarpedido";
	}
	
	
	
	
	@PostMapping("/editarpedido")
	public String editarProducto(@Valid Pedido pedido, Model model, RedirectAttributes atributo) {
		pedidoImp.actualizarPedido(pedido);
		List<Producto> listProducto = this.productoImp.Buscartodos();
		model.addAttribute("listProducto", listProducto);
		List<Compra> listCompra = this.compraImp.Buscartodos();
		model.addAttribute("listCompra", listCompra);
		atributo.addFlashAttribute("warning", "El pedido se ha modificado correctamente");
        return "redirect:/tablapedido";
	}
		
	
	@GetMapping("/eliminarPedido/{id}")
		public String delete(Model model, @PathVariable int id) {
		pedidoImp.delete(id);
		return "redirect/tablapedido";
	}
}
