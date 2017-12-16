import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LocaleTest
{
    @Test
    public void test() {
        ResourceBundle rb = ResourceBundle.getBundle("RBundle", new Locale("no", "NO", "NY"));
        assertEquals("Hello in nn_NO", rb.getString("hello"));
        assertEquals("say in nn_NO", rb.getString("say"));
        assertEquals("Hello in nn_NO", rb.getString("hello"));
        // so far so good, because caching did not apply, we loaded the bundle only once
        // we won't get the same result if we load the bundle again (due to cashing)
        rb = ResourceBundle.getBundle("RBundle", new Locale("no", "NO", "NY"));
        assertEquals("Hello in nn_NO", rb.getString("hello"));
        assertEquals("say in nn_NO", rb.getString("say"));
        assertEquals("Hello in nn_NO", rb.getString("hello"));
    }
}
