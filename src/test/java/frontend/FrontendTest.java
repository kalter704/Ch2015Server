package frontend;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by vasiliy on 07.01.16.
 */
public class FrontendTest {

    @Test
    public void testDoGet() throws Exception {

        final StringWriter stringWriter = new StringWriter();
        final PrintWriter writer = new PrintWriter(stringWriter);

        HttpServletRequest request = mock(HttpServletRequest.class);

        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(writer);

        Frontend front = new Frontend();
        front.doGet(request, response);

        final String rightResponse = '{'
                + "\"namePerem\":\"right\""
                + '}';

        assertEquals(rightResponse, stringWriter.toString());
    }

    @Test
    public void testDoPost() throws Exception {

    }
}