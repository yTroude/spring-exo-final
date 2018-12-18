import com.formation.exoFinal.access.UtilisateurRepository;
import com.formation.exoFinal.access.UtilisateurRepositoryImpl;
import com.formation.exoFinal.entities.UtilisateurEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {UtilisateurRepositoryImpl.class})
public class UtilisateurRepositoryTest {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Test
    public void contextLoads(){
        assertTrue(true);
    }

    @Test
    public void should_add_user(){
        //GIVEN
        String login="testLogin";
        String password="testPassword";
        String email="testEmail";
        int age=0;
        //WHEN
        utilisateurRepository.add(login,password,email,age);
        //THEN
        assertTrue(true);
    }

    @Test
    public void should_return_null_when_get_unknownLogin(){
        //GIVEN
        String login = "unknownLogin";
        //WHEN
        UtilisateurEntity utilisateurEntity = utilisateurRepository.get(login);
        //THEN
        assertNull(utilisateurEntity);
    }
}
