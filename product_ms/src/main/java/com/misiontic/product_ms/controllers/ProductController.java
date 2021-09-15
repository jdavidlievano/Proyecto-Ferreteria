package com.misiontic.product_ms.controllers;

import com.misiontic.product_ms.exceptions.ProductNotFoundException;
import com.misiontic.product_ms.models.Product;
import com.misiontic.product_ms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public ArrayList<Product> obtenerProductos(){
        return productService.obtenerProductos();
    }

    @PostMapping()
    public Product guardarProducto(@RequestBody Product producto){
        return this.productService.guardarProducto(producto);
    }

    @GetMapping(path = "/{id}")
    public Product obtenerProductoPorId(@PathVariable("id") String id){
        if (this.productService.obtenerPorId(id) == null)
            throw new ProductNotFoundException("No se encontró un producto con el id: " + id);

        return this.productService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<Product> obtenerProductoPorNombre(@RequestParam("name") String nombre){
        if (this.productService.obtenerPorNombre(nombre) == null || this.productService.obtenerPorNombre(nombre).isEmpty() )
            throw new ProductNotFoundException("No se encontraron productos con el nombre: " + nombre);

        return this.productService.obtenerPorNombre(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") String id){
        boolean ok = this.productService.eliminarProducto(id);
        if (ok){
            return "Se eliminó el producto con id: " + id;
        }else{
            throw new ProductNotFoundException("No se encontró un producto con el id: " + id);
        }
    }

    @PutMapping(value = "/{id}")
    public Product actualizarProducto(@PathVariable("id") String id, @RequestBody Product product){
        product.setId(id);
        Product productDB = productService.actualizarProducto(product);
        if (productDB == null){
            throw new ProductNotFoundException("No se encontró un producto con el id: " + id);
        }
        return productDB;
    }

    @GetMapping(value = "/{id}/stock")
    public Product actualizarStockProducto(@PathVariable("id") String id, @RequestParam("quantity") Integer quantity){
        Product producto = productService.actualizarStock(id, quantity);
        if (producto == null){
            throw new ProductNotFoundException("No se encontró un producto con el id: " + id);
        }
        return producto;
    }
}
