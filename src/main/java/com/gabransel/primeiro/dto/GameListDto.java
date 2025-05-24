package com.gabransel.primeiro.dto;

import com.gabransel.primeiro.entities.GameList;

public class GameListDto {

    private Long id;
    private String  name;

    public GameListDto(){
    }

    public GameListDto(GameList entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
