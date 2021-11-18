package com.producter.task.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.producter.task.dto.PlayerDto;
import com.producter.task.entity.Player;
import com.producter.task.repo.IPlayerRepository;
import com.producter.task.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {

    @Autowired
    PlayerService playerService;

    public Player createPlayer(PlayerDto player) {
        return playerService.createPlayer(player);
    }

    public Boolean deletePlayer(PlayerDto player){
        return playerService.deletePlayer(player);
    }

    private Player dtoToEntity(PlayerDto playerDto){
        Player player=new Player();
        player.setName(playerDto.getName());
        player.setSurname(playerDto.getSurname());
        player.setPosition(playerDto.getPosition());
        return player;
    }
}
