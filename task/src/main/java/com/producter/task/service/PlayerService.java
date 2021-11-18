package com.producter.task.service;

import com.producter.task.dto.PlayerDto;
import com.producter.task.entity.Player;
import com.producter.task.entity.Position;
import com.producter.task.repo.IPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final IPlayerRepository playerRepository;

    public Player createPlayer(PlayerDto player) {
        return playerRepository.save(dtoToEntity(player));
    }

    public Boolean deletePlayer(PlayerDto player){
        Player deletedPlayer = playerRepository.getById(player.getId());
        playerRepository.delete(deletedPlayer);
        return true;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    private Player dtoToEntity(PlayerDto playerDto){
        Player player=new Player();
        player.setName(playerDto.getName());
        player.setSurname(playerDto.getSurname());
        player.setPosition(playerDto.getPosition());
        return player;
    }
}
