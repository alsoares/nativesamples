package org.zup.quarkus;

import com.sun.jna.Native;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessingService {

    public static final String CAN_ONLY_GREET_NICKNAMES = "Can only greet nicknames";

    public OutputObject process(InputObject input) {
        if (input.getName().equals("Stuart")) {
            throw new IllegalArgumentException(CAN_ONLY_GREET_NICKNAMES);
        }
        CalculadoraJNA calculadora = (CalculadoraJNA) Native.load("libsomadorJNA.so", CalculadoraJNA.class);
        String result = "Saida: " + calculadora.soma(1, 2);
        OutputObject out = new OutputObject();
        out.setResult(result);
        return out;
    }
}
