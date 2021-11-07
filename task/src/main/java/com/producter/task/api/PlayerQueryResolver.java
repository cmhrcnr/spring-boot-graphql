package com.producter.task.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.producter.task.entity.Player;
import com.producter.task.repo.IPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver {

    private final IPlayerRepository playerRepository;

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }
}
