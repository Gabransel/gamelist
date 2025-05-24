package com.gabransel.primeiro.services;

import com.gabransel.primeiro.dto.GameDto;
import com.gabransel.primeiro.dto.GameMinDto;
import com.gabransel.primeiro.entities.Game;
import com.gabransel.primeiro.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDto findById(Long gameId){
        Game result =gameRepository.findById(gameId).get();
        GameDto dto= new GameDto(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        var result = gameRepository.findAll();
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
        return dto;
    }
}
