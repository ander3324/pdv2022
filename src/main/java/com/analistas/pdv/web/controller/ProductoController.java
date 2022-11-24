package com.analistas.pdv.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.analistas.pdv.model.entities.Categoria;
import com.analistas.pdv.model.entities.Producto;
import com.analistas.pdv.model.service.ICategoriaService;
import com.analistas.pdv.model.service.IProductoService;

@Controller
@RequestMapping("/productos")
@SessionAttributes("producto")
public class ProductoController {

    //Nuevamente la DI
    @Autowired
    IProductoService productoService;

    @Autowired
    ICategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {

        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("productos", productoService.buscarTodo());

        return "productos/list";
    }

    @GetMapping("/nuevo")
    public String nuevo (Model model) {

        model.addAttribute("titulo", "Nuevo Producto");
        model.addAttribute("producto", new Producto());
       
        return "productos/form";
    }

    @GetMapping("/editar/{id}")
    public String editar (@PathVariable("id") Long id, Model model) {

        Producto producto = productoService.buscarPorId(id);

        model.addAttribute("titulo", "Nuevo Producto");
        model.addAttribute("producto", producto);
       
        return "productos/form";
    }

    @PostMapping("/guardar")
    public String guardar (@Valid Producto producto, BindingResult result, 
        @RequestParam("cat") Long idCat, 
        Model model, RedirectAttributes msgFlash, SessionStatus status) {

        //Verificar si hay errores...
        if(result.hasErrors()) {
            model.addAttribute("danger", "Corrija los Errores...");
            return "productos/form";
        }

        producto.setCategoria(categoriaService.buscarPorId(idCat));
        productoService.guardar(producto);

        msgFlash.addFlashAttribute("success", "Producto Guardado Correctamente...");
        status.setComplete();

        return "redirect:/productos/listado";
    }

    @GetMapping("/borrar/{id}")
    public String deshabOrHabProducto(@PathVariable("id") Long id, RedirectAttributes msgFlash) {

        Producto producto = productoService.buscarPorId(id);
        producto.setActivo(!producto.isActivo());  //Si está activo, lo desactiva. Si está desacitivado, lo activa...
        productoService.guardar(producto);

        msgFlash.addFlashAttribute("warning", producto.isActivo() ? "Producto habilitado" : "Producto deshabilitado");

        return "redirect:/productos/listado";
    }

    @ModelAttribute("categorias")
    public List<Categoria> getCategorias() {
        return categoriaService.buscarTodo();
    }
}
