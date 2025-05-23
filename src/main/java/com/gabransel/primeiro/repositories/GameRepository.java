package com.gabransel.primeiro.repositories;

import com.gabransel.primeiro.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {


}