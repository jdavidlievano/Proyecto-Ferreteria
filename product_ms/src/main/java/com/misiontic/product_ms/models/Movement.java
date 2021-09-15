package com.misiontic.product_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Movement {
    @Id
    private String id;
    private String userId;
    private String productId;
    private String movement;
    private Integer quantity;
    private Date dateMovement;

    public Movement(String id, String userId, String productId, String movement, Integer quantity) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.movement = movement;
        this.quantity = quantity;
        dateMovement = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(Date dateMovement) {
        this.dateMovement = dateMovement;
    }
}
