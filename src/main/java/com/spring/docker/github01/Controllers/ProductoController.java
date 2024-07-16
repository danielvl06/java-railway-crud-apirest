package com.spring.docker.github01.Controllers;



import com.spring.docker.github01.entities.Producto;
import com.spring.docker.github01.repositories.ProdcutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {


    @Autowired
    private ProdcutoRepository prodcutoRepository;

    @GetMapping("")
    public List<Producto> getAllProductos (){
        return prodcutoRepository.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){

        return prodcutoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Integer id,@RequestBody Producto producto){

        Producto productoAux = prodcutoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No se encuentra el producto con el ID :"+id));
        productoAux.setNombre(producto.getNombre());
        productoAux.setPrecio(producto.getPrecio());

        return prodcutoRepository.save(productoAux);
    }

    @GetMapping("/{id}")
    public Producto findProductoById(@PathVariable Integer id){
        return  prodcutoRepository.findById(id).orElseThrow(() ->
              new RuntimeException("No se encuentra el producto con el ID :"+id));

    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Integer id){
        Producto producto = prodcutoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No se encuentra el producto con el ID :"+id));

        prodcutoRepository.delete(producto);
        return "El producto con el ID"+ id +" fue eliminado correctamente ";
    }

}
