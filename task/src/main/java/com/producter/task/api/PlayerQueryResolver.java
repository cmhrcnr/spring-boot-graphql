package com.producter.task.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.producter.task.entity.Player;
import com.producter.task.repo.IPlayerRepository;
import com.producter.task.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver {

    @Autowired
    PlayerService playerService;

    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }
}
