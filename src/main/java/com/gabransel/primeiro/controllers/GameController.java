package com.gabransel.primeiro.controllers;

import com.gabransel.primeiro.dto.GameDto;
import com.gabransel.primeiro.dto.GameMinDto;
import com.gabransel.primeiro.entities.Game;
import com.gabransel.primeiro.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDto findById(@PathVariable Long id) {
        GameDto result = gameService.findById(id);
        return result;
    }
    @GetMapping
    public List<GameMinDto> findAll() {
        List<GameMinDto> result = gameService.findAll();
        return result;

    }
}
