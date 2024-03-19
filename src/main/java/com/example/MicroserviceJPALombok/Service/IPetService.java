package com.example.MicroserviceJPALombok.Service;

import com.example.MicroserviceJPALombok.Model.Pet;

import java.util.List;

public interface IPetService {

    List<Pet> getPets();
    Pet getPet(String name);
    void deletePet(int id);
    boolean addPet(Pet pet);
    void updatePet(Pet pet);
}
