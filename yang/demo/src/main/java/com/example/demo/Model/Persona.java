package com.example.demo.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String name;
    public String surname;
    public int age;

    Persona(){

    }

    Persona(String name,String surname,int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public int getAge() {
        return age;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void update(String name,String surname,int age){
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "{id="+getId()+",name="+getName()+",surname="+getSurname()+",age="+getAge()+"}";
    }
}
