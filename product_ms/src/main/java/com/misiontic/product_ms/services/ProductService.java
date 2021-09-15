package com.misiontic.product_ms.services;

import com.misiontic.product_ms.exceptions.ProductNotFoundException;
import com.misiontic.product_ms.models.Product;
import com.misiontic.product_ms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ArrayList<Product> obtenerProductos(){
        return (ArrayList<Product>) productRepository.findAll();
    }

    public Product guardarProducto(Product producto){
        return productRepository.save(producto);
    }

    public Product actualizarProducto(Product producto){
        Product productDB = obtenerPorId(producto.getId());
        if ( productDB == null){
            return null;
        }
        if (producto.getName() != null){
            productDB.setName(producto.getName());
        }
        if (producto.getStock() != null){
            productDB.setStock(producto.getStock());
        }
        if (producto.getDescription() != null){
            productDB.setDescription(producto.getDescription());
        }
        if (producto.getPrice() != null){
            productDB.setPrice(producto.getPrice());
        }

        return productRepository.save(productDB);
    }

    public Product obtenerPorId(String id){
        return productRepository.findById(id).orElse(null);
    }
    
    public ArrayList<Product> obtenerPorNombre(String name){
        return productRepository.findByName(name);
    }

    public boolean eliminarProducto(String id){
        try{
            Product productDB = productRepository.findById(id).orElse(null);
            if (productDB == null)
                return false;

            productRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

    public Product actualizarStock(String id, Integer quantity){
        Product productDB = obtenerPorId(id);
        if (null == productDB){
            return null;
        }
        Integer stock = productDB.getStock() + quantity;
        productDB.setStock(stock);
        return productRepository.save(productDB);
    }
}
