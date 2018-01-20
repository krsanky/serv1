package org.oldcode.javaweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("main ...");
        //Settings s = new Settings();
        //s.read();
        Consumer<String> c = System.out::println;
        //
        //BiConsumer<HttpServletRequest, HttpServletResponse> myDo =  (req, res) -> System.out.println("hey");

    }
}
