package com.formation.exoFinal.access;


import com.formation.exoFinal.entities.UtilisateurEntity;

public interface UtilisateurRepository {

    void add(String login, String password, String email, int age);
    UtilisateurEntity get(String login);
}
