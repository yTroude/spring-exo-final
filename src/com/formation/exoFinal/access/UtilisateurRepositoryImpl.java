package com.formation.exoFinal.access;


import com.formation.exoFinal.entities.UtilisateurEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

    private static Map<String, UtilisateurEntity> utilisateurs = new HashMap<>();

    @Override
    public void add(String login, String password, String email, int age) {
        if (utilisateurs.get(login)==null) {
            UtilisateurEntity newUser = new UtilisateurEntity();
            newUser.setLogin(login);
            newUser.setPassword(password);
            newUser.setAge(age);
            utilisateurs.put(login,newUser);
        }
    }

    @Override
    public UtilisateurEntity get(String login) {
        return utilisateurs.get(login);
    }

}
