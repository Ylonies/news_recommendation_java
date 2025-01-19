package org.example.entity;

import java.util.UUID;

public class Catalog {
    private UUID id;
    private String name;
    private UUID userId;

    public Catalog(UUID id, String name, UUID userId){
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public Catalog(String name){
        this.id = UUID.randomUUID();
        this.name = name;
        this.userId = null;
    }
    public UUID getId(){
        return id;
    }
    public String getName() {
        return name;
    }
}