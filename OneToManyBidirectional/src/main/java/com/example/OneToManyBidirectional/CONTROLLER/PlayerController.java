package com.example.OneToManyBidirectional.CONTROLLER;


import com.example.OneToManyBidirectional.ENTITY.Player;
import com.example.OneToManyBidirectional.ENTITY.PlayerProfile;
import com.example.OneToManyBidirectional.ENTITY.Registration;
import com.example.OneToManyBidirectional.SERVICE.PlayerProfileService;
import com.example.OneToManyBidirectional.SERVICE.PlayerService;
import com.example.OneToManyBidirectional.SERVICE.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService service;

    @Autowired
    PlayerProfileService profileService;

    @Autowired
    RegistrationService registrationService;

    @GetMapping
    public List<Player> allPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id){
        return service.getOnePlayer(id);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return service.addPlayers(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deletePlayer(id);
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public Player assignDetail(@PathVariable int id, @PathVariable int profile_id) {
        PlayerProfile profile = profileService.getOnePlayerProfile(profile_id);
        System.out.println(profile);
        return service.assignPlayerProfile(id, profile);
    }

    @PutMapping("/{id}/registrations/{registration_id}")
    public Player assignRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getOneRegistration(registration_id);
        System.out.println(registration);
        return service.assignRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public Player removeRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getOneRegistration(registration_id);
        System.out.println(registration);
        return service.deleteRegistration(id, registration);
    }
}