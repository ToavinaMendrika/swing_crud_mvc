package controller;
import repository.PersonneRepository;

public class PersonneCotroller {

    public void insert(String nom,String prenom,Integer age){
        PersonneRepository p = new PersonneRepository();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setAge(age);
        p.save();
    }

}
