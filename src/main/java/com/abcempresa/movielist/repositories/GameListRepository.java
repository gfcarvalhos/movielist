package com.abcempresa.movielist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcempresa.movielist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
