package com.formation.exoFinal;


import com.formation.exoFinal.business.UtilisateurService;
import com.formation.exoFinal.exceptions.AuthentificationException;
import com.formation.exoFinal.exceptions.InscriptionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.formation.exoFinal")
public class Application {
    private static ApplicationContext applicationContext;

    @Autowired
    private UtilisateurService utilisateurService;

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(Application.class);

        Application application = applicationContext.getBean(Application.class);
        application.job();
    }

    public void job() {



        //plante
        try {
            utilisateurService.authentification("login","password");
        } catch (AuthentificationException e) {
            System.out.println("Exemple 1 doit passer ici");
            e.printStackTrace();
        }

        //marche
        try {
            utilisateurService.inscription("login", "password", "mail@mail.mail", 19);
            System.out.println("Exemple 2 doit passer ici");
        } catch (InscriptionException e) {
            e.printStackTrace();
        }

        //marche
        try {
            utilisateurService.authentification("login","password");
            System.out.println("Exemple 3 doit passer ici");
        } catch (AuthentificationException e) {
            e.printStackTrace();
        }

        //plante
        try {
            utilisateurService.inscription("login", "password", "mail@mail.mail", 19);
        } catch (InscriptionException e) {
            System.out.println("Exemple 4 doit passer ici");
            e.printStackTrace();
        }



    }
}
