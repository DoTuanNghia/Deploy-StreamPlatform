package com.stream.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbluser")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Member {

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Channel> channels;   // 1 User có N Channel
}
