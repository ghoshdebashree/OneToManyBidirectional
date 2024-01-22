package com.example.OneToManyBidirectional.SERVICE;

import com.example.OneToManyBidirectional.ENTITY.Player;
import com.example.OneToManyBidirectional.ENTITY.PlayerProfile;
import com.example.OneToManyBidirectional.ENTITY.Registration;
import com.example.OneToManyBidirectional.REPOSITORY.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    public Player getPlayer(int id){
        return playerRepository.findById(id).get();
    }
    public Player addPlayers(Player player){
        return playerRepository.save(player);
    }
    public void deletePlayer(int id){
        playerRepository.deleteById(id);
    }
    public Player assignPlayerProfile(int id, PlayerProfile playerProfile){
        Player player = playerRepository.findById(id).get();
        player.setPlayerProfile(playerProfile);

        //BIDIRECTIONAL APPROACH

        player.getPlayerProfile().setPlayer(player);
        return playerRepository.save(player);
    }
    public Player assignRegistration(int id, Registration registration){
        Player player = playerRepository.findById(id).get();
        player.registerPlayer(registration);
        return playerRepository.save(player);
    }

    public Player deleteRegistration(int id, Registration registration){
        Player player = playerRepository.findById(id).get();
        player.removeRegistration(registration);
        return playerRepository.save(player);
    }
}
