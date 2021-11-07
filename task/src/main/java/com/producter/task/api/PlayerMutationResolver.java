package com.producter.task.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.producter.task.dto.PlayerDto;
import com.producter.task.entity.Player;
import com.producter.task.repo.IPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final IPlayerRepository playerRepository;

    public Player createPlayer(PlayerDto player) {
        return playerRepository.save(dtoToEntity(player));
    }

    public Boolean deletePlayer(PlayerDto player){
        Player deletedPlayer = playerRepository.getById(player.getId());
        playerRepository.delete(deletedPlayer);
        return true;
    }

    private Player dtoToEntity(PlayerDto playerDto){
        Player player=new Player();
        player.setName(playerDto.getName());
        player.setSurname(playerDto.getSurname());
        player.setPosition(playerDto.getPosition());
        return player;
    }
}
