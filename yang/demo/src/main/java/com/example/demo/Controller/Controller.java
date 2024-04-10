package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controller.Repository.PersonaRepository;
import com.example.demo.Model.Persona;

@RestController
@RequestMapping("/persona")
public class Controller

{
    @Autowired
    PersonaRepository personaRepository;

    //aggiungere
    @PostMapping("/register")
        public void addPersona(@RequestBody Persona persona) {
            personaRepository.save(persona);  
        }
    @PostMapping("/login")
        public Persona loginPersona(@RequestParam String username,@RequestParam String password) {
            return personaRepository.findByUsernameAndPassword(username,password);  
        }

        

 
}
