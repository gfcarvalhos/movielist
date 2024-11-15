package com.abcempresa.movielist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcempresa.movielist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{ 

}
