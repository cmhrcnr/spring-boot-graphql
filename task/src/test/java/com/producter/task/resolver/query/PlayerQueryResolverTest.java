package com.producter.task.resolver.query;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.producter.task.api.PlayerQueryResolver;
import com.producter.task.entity.Player;
import com.producter.task.service.PlayerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.doReturn;

@GraphQLTest
public class PlayerQueryResolverTest {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @MockBean
    PlayerService playerQueryResolver;

    @Test
    public void getUser() throws Exception {

        Player player = new Player();
        player.setName("caner");
        player.setSurname("erken");
        doReturn(player).when(playerQueryResolver).getPlayers();

        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/get-players.graphql");
        Assertions.assertThat(response.isOk()).isTrue();
        Assertions.assertThat(response.get("$.data.getPlayers.id")).isNotNull();
        Assertions.assertThat(response.get("$.data.getPlayers.name")).isEqualTo("caner");
    }
}
