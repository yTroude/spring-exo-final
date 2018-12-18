package dummies;

import com.formation.exoFinal.access.UtilisateurRepository;
import com.formation.exoFinal.entities.UtilisateurEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UtilisateurRepositoryDummy implements UtilisateurRepository {
    @Override
    public void add(String login, String password, String email, int age) {
        System.out.println("Dummy add");
    }

    @Override
    public UtilisateurEntity get(String login) {

        if(login.equals("jeanbob")) {
            UtilisateurEntity utilisateurEntity = new UtilisateurEntity();
            utilisateurEntity.setLogin(login);
            utilisateurEntity.setPassword("hunter2");
            utilisateurEntity.setAge(12);
            utilisateurEntity.setMail("mail@mail.mail");
            return utilisateurEntity;
        }
        else {
            return null;
        }
    }
}
