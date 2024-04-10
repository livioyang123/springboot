package com.example.demo.Controller.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Long>{
    public Persona findByUsernameAndPassword(String username,String password);
}