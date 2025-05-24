package com.gabransel.primeiro.dto;


import com.gabransel.primeiro.entities.Game;
import com.gabransel.primeiro.projections.GameMinProjection;

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

    public GameMinDto(GameMinProjection projection){
        this.id = projection.getId();
        this.title = projection.getTitle();
        this.score = projection.getScore();
        this.imgUrl = projection.getImgUrl();
        this.shortDescription = projection.getShortDescription();
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
