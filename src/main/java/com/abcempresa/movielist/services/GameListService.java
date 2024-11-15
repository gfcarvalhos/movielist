package com.abcempresa.movielist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcempresa.movielist.dto.GameListDTO;
import com.abcempresa.movielist.entities.GameList;
import com.abcempresa.movielist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired //injecao de instancia do repositorio
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
}
