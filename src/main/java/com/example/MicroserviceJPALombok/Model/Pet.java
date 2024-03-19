package com.example.MicroserviceJPALombok.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private int age;

}
