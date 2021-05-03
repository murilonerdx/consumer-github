package com.devputasso.util;

import com.devputasso.issues.Issue;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public static List<Issue> converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String[] listaRaiz;
        List<String> geral = new ArrayList<>();
        String response, jsonEmString = "";
        List<Issue> issues = new ArrayList<>();
        List<Integer> sequencia = new ArrayList<>();
        Issue issue = new Issue();

        List<String> listaUsers = new ArrayList<>();


        while ((response = buffereReader.readLine()) != null) {
            int a = 0;
            String[] listaSeparador;
            jsonEmString += response;
            listaRaiz = jsonEmString.substring(55).split(",");
            int carga = listaRaiz.length - a;
            for (String s : listaRaiz) {
                listaSeparador = s.split(",");
                geral.add(Arrays.toString(listaSeparador));
            }

            while (a < listaRaiz.length) {
                String linha;
                linha = geral.get(a).replaceAll("^[\"]|", "");
                if (linha.substring(2, 7).equals("title")) {
                    sequencia.add(a);
                } else if (linha.substring(2, 6).equals("user")) {
                    sequencia.add(a);
                } else if (linha.substring(2, 6).equals("body")) {
                    sequencia.add(a);
                } else if (linha.substring(2, 5).equals("url")) {
                    sequencia.add(a);
                }
                a++;
            }
        }

        int contador = 0;
        for (int l : sequencia) {

            if (geral.get(l).substring(2, 7).equals("title")) {
                contador = 0;
                String title = geral.get(l).replaceAll("^[\"]|", "").substring(10, geral.get(l).length() - 2);
                issue.setTitle(title);
                contador++;
            } else if (geral.get(l).substring(2, 6).equals("user")) {

                contador++;
                String user = geral.get(l).replaceAll("^[\"]|", "").substring(18, geral.get(l).length() - 2);
                if (listaUsers.contains(user)) {
                    System.out.println("Usuario já tem registro");
                    break;
                } else {
                    issue.setLogin(user);
                    listaUsers.add(user);
                }

            }
            if (geral.get(l).substring(2, 6).equals("body")) {
                contador++;
                String body = geral.get(l).replaceAll("^[\"]|", "").substring(9, geral.get(l).length() - 2);
                issue.setBody(body);
            } else if (geral.get(l).substring(2, 5).equals("url")) {
                contador++;
                String url = geral.get(l).replaceAll("^[\"]|", "").substring(8, geral.get(l).length() - 2);
                issue.setUrl(url);
            }
            if (contador == 4) {
                issues.add(issue);
                issue = new Issue();
            }

        }
        return issues;
    }
}
