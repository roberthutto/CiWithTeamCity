import com.robert.rest.controllers.CoreRestController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by work on 1/20/15.
 */
public class CoreRestControllerTest {


    @Test
    public void testReflect() {

        CoreRestController controller = new CoreRestController();

        ResponseEntity<?> responseEntity = controller.getOffers("test");

        Assert.assertEquals(responseEntity.getStatusCode().toString(), HttpStatus.OK.toString());

    }

}
