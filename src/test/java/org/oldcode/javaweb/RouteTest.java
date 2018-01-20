package org.oldcode.javaweb;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class RouteTest {
    @Mock
    private HttpServletRequest httpServletReq;

    @Test
    void myFirstTest() {
        System.out.println("This test method should be run");
        assertEquals(2, 1 + 1);
    }

    @Test
    void parseTest() {
        //HttpServletRequest servlReq = Mockito.mock(HttpServletRequest.class);
        httpServletReq = Mockito.mock(HttpServletRequest.class);
        when(httpServletReq.getServletPath())
                .thenReturn("/controller123-method_42-qwe123--dfgdfg34534---123bnm-kkssksk.1");
        Route r = Route.parse(httpServletReq);
        assertEquals("controller123", r.controller);
        assertEquals("method_42", r.method);
        assertEquals("1", r.version);
        assertTrue(r.valid);
    }
}