package com.abcempresa.movielist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcempresa.movielist.dto.GameListDTO;
import com.abcempresa.movielist.entities.GameList;
import com.abcempresa.movielist.projections.GameMinProjection;
import com.abcempresa.movielist.repositories.GameListRepository;
import com.abcempresa.movielist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired //injecao de instancia do repositorio
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ?  sourceIndex : destinationIndex;
		int max = sourceIndex > destinationIndex ?  sourceIndex : destinationIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
	
}
