package com.misiontic.product_ms.controllers;


import com.misiontic.product_ms.exceptions.MovementNotFoundException;
import com.misiontic.product_ms.exceptions.ProductNotFoundException;
import com.misiontic.product_ms.models.Movement;
import com.misiontic.product_ms.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/movement")
public class MovementController {
    @Autowired
     MovementService movementService;

    @GetMapping
    public ArrayList<Movement> obtenerMovimientos(){
        return movementService.obtenerMovimientos();
    }

    @PostMapping
    public Movement guardarMovimiento(@RequestBody Movement movimiento){
        return this.movementService.guardarMovimiento(movimiento);
    }

    @GetMapping(path = "/{id}")
    public Movement obtenerMovimientoPorId(@PathVariable("id") String id){
        if (this.movementService.obtenerPorId(id) == null)
            throw new MovementNotFoundException("No se encontró un movimiento con el id: " + id);

        return this.movementService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") String id){
        boolean ok = this.movementService.eliminarMovimiento(id);
        if (ok){
            return "Se eliminó el movimiento con id: " + id;
        }else{
            throw new MovementNotFoundException("No se encontró un movimiento con el id: " + id);
        }
    }

    @GetMapping("/queryuid")
    public ArrayList<Movement> obtenerMovimientosPorUserId(@RequestParam("userid") String userId){
        if (this.movementService.obtenerPorUserId(userId) == null || this.movementService.obtenerPorUserId(userId).isEmpty())
            throw new MovementNotFoundException("No se encontraron movimientos para el userId: " + userId);

        return this.movementService.obtenerPorUserId(userId);
    }

    @GetMapping("/querypid")
    public ArrayList<Movement> obtenerMovimientosPorProductId(@RequestParam("productid") String productId){
        if (this.movementService.obtenerPorProductId(productId) == null || this.movementService.obtenerPorProductId(productId).isEmpty())
            throw new MovementNotFoundException("No se encontraron movimientos para el productId: " + productId);
        return this.movementService.obtenerPorProductId(productId);
    }
}
