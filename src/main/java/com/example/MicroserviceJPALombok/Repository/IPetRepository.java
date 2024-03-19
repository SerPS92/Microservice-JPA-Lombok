package com.example.MicroserviceJPALombok.Repository;


import com.example.MicroserviceJPALombok.Model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Integer> {

    Pet findByName(String name);
}
