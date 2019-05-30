package controller;

import repository.PersonneRepository;

import java.util.Arrays;

public class PersonneCotroller {

    public void insert(String nom,String prenom,Integer age){
        PersonneRepository p = new PersonneRepository();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setAge(age);
        p.save();
    }

    public String[][] all(){
        PersonneRepository p = new PersonneRepository();
        return p.findAll();
    }

    public String[] first(int id){
        PersonneRepository p = new PersonneRepository();
        return p.show(id);
    }

    public Integer[] ids(){
        PersonneRepository p = new PersonneRepository();
        return p.findIds();
    }

    public void update(String nom,String prenom,Integer age,Integer id){
        PersonneRepository p = new PersonneRepository();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setAge(age);
        p.update(id);
    }

    public void delete(int id){
        PersonneRepository p = new PersonneRepository();
        p.delete(id);
    }
}
