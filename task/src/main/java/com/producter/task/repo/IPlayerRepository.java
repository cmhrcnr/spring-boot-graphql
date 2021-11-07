package com.producter.task.repo;

import com.producter.task.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepository extends JpaRepository<Player, Long> {
}
