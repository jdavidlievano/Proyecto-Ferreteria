package com.misiontic.product_ms.repositories;

import com.misiontic.product_ms.models.Movement;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface MovementRepository extends MongoRepository <Movement, String> {
    public abstract ArrayList<Movement> findByUserId (String userId);
    public abstract ArrayList<Movement> findByProductId (String productId);

}
