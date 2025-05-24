package com.gabransel.primeiro.repositories;

import com.gabransel.primeiro.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {


}