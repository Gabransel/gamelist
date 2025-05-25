package com.gabransel.primeiro.services;


import com.gabransel.primeiro.dto.GameListDto;
import com.gabransel.primeiro.dto.GameMinDto;

import com.gabransel.primeiro.entities.GameList;
import com.gabransel.primeiro.projections.GameMinProjection;
import com.gabransel.primeiro.repositories.GameListRepository;

import com.gabransel.primeiro.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> result = gameListRepository.findAll();
       return result.stream().map(x -> new GameListDto(x)).toList();

    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
