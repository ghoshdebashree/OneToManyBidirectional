package com.example.OneToManyBidirectional.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;



@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})// , fetch=FetchType.LAZY)//, fetch=FetchType.LAZY
    @JoinColumn(name="player_id", referencedColumnName = "id")
    //@JsonBackReference
    private Player player;

    public Registration() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Registration [id=" + id + ", player=" + player + "]";
    }
}