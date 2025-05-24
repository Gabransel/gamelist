package com.gabransel.primeiro.services;


import com.gabransel.primeiro.dto.GameListDto;
import com.gabransel.primeiro.dto.GameMinDto;

import com.gabransel.primeiro.entities.GameList;
import com.gabransel.primeiro.repositories.GameListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;



    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> result = gameListRepository.findAll();
       return result.stream().map(x -> new GameListDto(x)).toList();

    }
}
