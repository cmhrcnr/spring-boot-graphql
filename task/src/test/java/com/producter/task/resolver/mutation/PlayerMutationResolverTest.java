package com.producter.task.resolver.mutation;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.producter.task.api.PlayerMutationResolver;
import com.producter.task.dto.PlayerDto;
import com.producter.task.entity.Player;
import com.producter.task.entity.Position;
import com.producter.task.service.PlayerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.mockito.Mockito.doReturn;

@GraphQLTest
public class PlayerMutationResolverTest {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @MockBean
    PlayerService playerMutationResolver;

    static Player player = new Player();

    @BeforeAll
    static void setUp() {
        player.setName("caner");
        player.setSurname("erken");
        player.setPosition(Position.C);
    }

    @Test
    public void createPlayer() throws IOException {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName("caner");
        playerDto.setSurname("erken");
        playerDto.setPosition(Position.C);

        doReturn(player).when(playerMutationResolver).createPlayer(playerDto);
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/create-player.graphql");
        Assertions.assertThat(response.isOk()).isTrue();
        Assertions.assertThat(response.get("$.data.createPlayer.id")).isNotNull();
        Assertions.assertThat(response.get("$.data.createPlayer.name")).isEqualTo(playerDto.getName());

    }

    @Test
    public void deleteUser() throws IOException {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(1l);

        doReturn(player).when(playerMutationResolver).deletePlayer(playerDto);
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/delete-player.graphql");
        Assertions.assertThat(response.isOk()).isTrue();

    }
}
