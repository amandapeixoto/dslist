package com.maps.dslist.services;

import com.maps.dslist.dto.GameListDTO;
import com.maps.dslist.entities.GameList;
import com.maps.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired // Injeta automaticamente a dependência, evitando instanciação manual
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true) // Melhora a performance ao evitar bloqueios e rastreamento de mudanças
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional // Garante que operações de escrita sejam feitas de forma atômica
    public GameListDTO insert(GameListDTO dto) {
        GameList entity = new GameList();
        entity.setName(dto.getName());
        entity = gameListRepository.save(entity);
        return new GameListDTO(entity);
    }

    @Transactional
    public GameListDTO update(Long id, GameListDTO dto) {
            GameList entity = gameListRepository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = gameListRepository.save(entity);
            return new GameListDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
            gameListRepository.deleteById(id);
    }

}
