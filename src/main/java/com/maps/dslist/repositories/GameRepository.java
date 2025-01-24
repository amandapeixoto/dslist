package com.maps.dslist.repositories;

import com.maps.dslist.dto.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
