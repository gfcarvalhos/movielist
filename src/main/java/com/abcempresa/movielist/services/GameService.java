package com.abcempresa.movielist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcempresa.movielist.dto.GameMinDTO;
import com.abcempresa.movielist.entities.Game;
import com.abcempresa.movielist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired //injecao de instancia do repositorio
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
