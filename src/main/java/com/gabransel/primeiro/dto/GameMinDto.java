package com.gabransel.primeiro.dto;


import com.gabransel.primeiro.entities.Game;

public class GameMinDto {

    private Long id;
    private String title;
    private double score;
    private String imgUrl;
    private String shortDescription;

    public GameMinDto() {
    }

    public GameMinDto(Game entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.score = entity.getScore();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getScore() {
        return score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
