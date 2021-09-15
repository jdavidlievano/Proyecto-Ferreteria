package com.misiontic.product_ms.services;

import com.misiontic.product_ms.models.Movement;
import com.misiontic.product_ms.models.Product;
import com.misiontic.product_ms.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovementService {
    @Autowired
    MovementRepository movementRepository;

    public ArrayList<Movement> obtenerMovimientos(){
        return (ArrayList<Movement>) movementRepository.findAll();
    }

    public Movement guardarMovimiento(Movement movimiento){
        return movementRepository.save(movimiento);
    }

    public boolean eliminarMovimiento(String id){
        try{
            Movement movimiento = movementRepository.findById(id).orElse(null);
            if (movimiento == null)
                return false;

            movementRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

    public Movement obtenerPorId(String id){
        return movementRepository.findById(id).orElse(null);
    }

    public ArrayList<Movement> obtenerPorUserId(String userId){
        return movementRepository.findByUserId(userId);
    }

    public ArrayList<Movement> obtenerPorProductId(String productId){
        return movementRepository.findByProductId(productId);
    }
}
