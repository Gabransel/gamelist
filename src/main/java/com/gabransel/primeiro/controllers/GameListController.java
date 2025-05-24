package com.gabransel.primeiro.controllers;


import com.gabransel.primeiro.dto.GameListDto;
import com.gabransel.primeiro.dto.GameMinDto;
import com.gabransel.primeiro.services.GameListService;
import com.gabransel.primeiro.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;


    @GetMapping
    public List<GameListDto> findAll() {
        List<GameListDto> result = gameListService.findAll();
        return result;

    }

    @GetMapping(value = "{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId) {
        List<GameMinDto> result = gameService.findByList(listId);
        return result;

    }
}
