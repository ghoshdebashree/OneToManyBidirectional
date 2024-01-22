package com.example.OneToManyBidirectional.ENTITY;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Registration {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} , fetch=FetchType.LAZY)//, fetch=FetchType.LAZY
    @JoinColumn(name="player_id", referencedColumnName = "id")
    //@JsonManagedReference
    private Player player;
        }