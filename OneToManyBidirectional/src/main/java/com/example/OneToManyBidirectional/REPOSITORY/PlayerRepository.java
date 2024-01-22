package com.example.OneToManyBidirectional.REPOSITORY;

import com.example.OneToManyBidirectional.ENTITY.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
