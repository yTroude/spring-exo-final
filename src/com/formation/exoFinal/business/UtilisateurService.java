package com.formation.exoFinal.business;


import com.formation.exoFinal.beans.Utilisateur;
import com.formation.exoFinal.exceptions.InscriptionException;
import com.formation.exoFinal.exceptions.AuthentificationException;

public interface UtilisateurService {
    Utilisateur authentification (String login, String password) throws AuthentificationException;
    void inscription(String login, String password, String mail, int age) throws InscriptionException;

}
