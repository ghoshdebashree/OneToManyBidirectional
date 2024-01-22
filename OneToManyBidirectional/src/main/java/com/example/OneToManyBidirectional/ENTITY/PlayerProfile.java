package com.example.OneToManyBidirectional.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

    @Entity
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public class PlayerProfile {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String tweeter;
        @OneToOne(mappedBy = "playerProfile",cascade = CascadeType.ALL)
        //@JsonBackReference
        private Player player;
    }


