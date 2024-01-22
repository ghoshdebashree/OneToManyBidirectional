package com.example.OneToManyBidirectional.REPOSITORY;

import com.example.OneToManyBidirectional.ENTITY.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Integer> {
}
