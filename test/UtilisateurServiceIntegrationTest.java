import com.formation.exoFinal.access.UtilisateurRepositoryImpl;
import com.formation.exoFinal.beans.Utilisateur;
import com.formation.exoFinal.business.UtilisateurService;
import com.formation.exoFinal.business.UtilisateurServiceImpl;
import com.formation.exoFinal.exceptions.AuthentificationException;
import com.formation.exoFinal.exceptions.InscriptionException;
import dummies.UtilisateurRepositoryDummy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {UtilisateurServiceImpl.class, UtilisateurRepositoryDummy.class})
public class UtilisateurServiceIntegrationTest {
    @Autowired
    UtilisateurService utilisateurService;

    @Test
    public void contextLoads(){
        assertTrue(true);
    }

    @Test
    public void should_authenticate(){
        //GIVEN
        String login = "jeanbob";
        Utilisateur utilisateur = null;
        //WHEN
        try {
            utilisateur = utilisateurService.authentification("jeanbob","hunter2");
        } catch (AuthentificationException e) {
            e.printStackTrace();
        }
        //THEN
        assertEquals(utilisateur.getLogin(),"jeanbob");
        assertEquals(utilisateur.getAge(),12);
        assertEquals(utilisateur.getMail(),"mail@mail.mail");
    }

    @Test
    public void should_subscribe(){
        //GIVEN
        String login = "kekedu14";
        String password = "abc123";
        String mail = "a@a.a";
        int age = 17;
        //WHEN
        try {
            utilisateurService.inscription(login,password,mail,age);
        //THEN
            assertTrue(true);

        } catch (InscriptionException e) {
            e.printStackTrace();
            fail();
        }

    }

}
