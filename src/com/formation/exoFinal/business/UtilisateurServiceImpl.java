package com.formation.exoFinal.business;

import com.formation.exoFinal.access.UtilisateurRepository;
import com.formation.exoFinal.entities.UtilisateurEntity;
import com.formation.exoFinal.beans.Utilisateur;
import com.formation.exoFinal.exceptions.AuthentificationException;
import com.formation.exoFinal.exceptions.InscriptionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public Utilisateur authentification(String login, String password) throws AuthentificationException {
        UtilisateurEntity ue = utilisateurRepository.get(login);
        if(ue == null || !ue.getPassword().equals(password)){
            throw new AuthentificationException();
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAge(ue.getAge());
        utilisateur.setLogin(ue.getLogin());
        utilisateur.setMail(ue.getMail());
        return utilisateur;
    }

    @Override
    public void inscription(String login, String password, String mail, int age) throws InscriptionException {
        if (utilisateurRepository.get(login)!=null || age<16){
            throw new InscriptionException();
        }

        utilisateurRepository.add(login, password, mail, age);
    }

    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }
}
