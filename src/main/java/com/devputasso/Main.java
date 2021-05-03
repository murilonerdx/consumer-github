package com.devputasso;

import com.devputasso.issues.Issue;
import com.devputasso.tools.ServicoGetApi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


        List<String> palavras = Arrays.asList(
                "arrombado",
                "bosta",
                "buceta",
                "caralho",
                "vai%20tomar%20no%20cu",
                "vtnc",
                "desgraca",
                "meu%20pau",
                "foda",
                "foda-se",
                "fodido",
                "fodase",
                "merda",
                "porra",
                "puta",
                "mundiça",
                "cacildis",
                "catapimbas",
                "carambolas",
                "cacete",
                "bolsonaro"
        );
        int max = 5;
        for (String palavra : palavras.subList(0, max)) {
            List<Issue> issues = ServicoGetApi.buscarAPI(palavra, 1);

            if (issues != null) {
                for (Issue e : issues) {
                    System.out.printf("Corpo: %s \nUsuario: %s \nTitulo : %s \nURL: %s\n", e.getBody(), e.getLogin(), e.getTitle(), e.getUrl());
                    System.out.println("=================================================================");
                }
            }

        }

    }

}
