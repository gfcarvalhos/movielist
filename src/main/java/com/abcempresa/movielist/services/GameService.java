package com.abcempresa.movielist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcempresa.movielist.dto.GameDTO;
import com.abcempresa.movielist.dto.GameMinDTO;
import com.abcempresa.movielist.entities.Game;
import com.abcempresa.movielist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired //injecao de instancia do repositorio
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true) //anotação para que a ação respeite o modelo ACID das transações
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
}
