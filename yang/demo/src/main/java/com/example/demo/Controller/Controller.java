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
    @PostMapping()
        public void addPersona(@RequestBody Persona persona) {
            personaRepository.save(persona);  
        }
    //visualizzare
    @GetMapping("/list")
        public List<Persona> list(){
            return personaRepository.findAll();
        }
    @GetMapping("/find")
        public Optional<Persona> find_id(@RequestParam Long id){
            return personaRepository.findById(id);
        }
    //aggioranare
    @PutMapping("/update")
        public String updatePersona(@RequestParam Long id,@RequestBody Persona persona){
            try {
                Optional<Persona> p_Optional = personaRepository.findById(id);  
                Persona p = p_Optional.get();
                p.update(persona.getName(),persona.getSurname(),persona.getAge());
                personaRepository.save(p);
            } catch (Exception e) {
                // TODO: handle exception
                return "Error:id not found";
            }
            return "succesful\n";
            
        }
    //eliminare per id
    @DeleteMapping("/delete")
        public String deleteBy_id(@RequestParam Long id){
            try {
                personaRepository.deleteById(id);
            } catch (Exception e) {
                // TODO: handle exception
                return "Error";
            }
            return "succesful\n";
        }
    //eliminare tutto
    @DeleteMapping("/deleteAll")
        public void delete_all(){
            personaRepository.deleteAll();
        }

    @GetMapping()
        public String findBy_id(@RequestParam Long id){
            Optional<Persona> p_Optional;
            Persona p;
            try {
                p_Optional = personaRepository.findById(id);
                p = p_Optional.get();
            } catch (Exception e) {
                // TODO: handle exception
                return "Error:id not found";
            }
            return p.toString();
        }
        

 
}
