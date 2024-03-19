package com.example.MicroserviceJPALombok.Controller;

import com.example.MicroserviceJPALombok.Model.Pet;
import com.example.MicroserviceJPALombok.Service.IPetService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    private final IPetService petService;

    public PetController(IPetService petService) {
        this.petService = petService;
    }

    @GetMapping(value = "pets", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pet>> getPets() {
        List<Pet> pets = petService.getPets();
        HttpHeaders headers = new HttpHeaders();
        headers.add("total", String.valueOf(pets.size()));
        return new ResponseEntity<List<Pet>>(pets, headers, HttpStatus.OK);
    }

    @GetMapping(value = "pets/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> getPet(@PathVariable(name = "name") String name) {
        return new ResponseEntity<Pet>(petService.getPet(name), HttpStatus.OK);
    }

    @PostMapping(value = "pets",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addPet(@RequestBody Pet pet) {
        if (petService.addPet(pet)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "pets/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable(name = "id") int id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "pets",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePet(@RequestBody Pet pet){
        if(pet.getId() != 0){
            petService.updatePet(pet);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
}
