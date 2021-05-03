package com.devputasso.tools;

import com.devputasso.issues.Issue;
import com.devputasso.util.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ServicoGetApi {
    public static String GITHUB_URL_ISSUES = "https://api.github.com/search/issues?q=";
    public static String WORK_KEY = "%20in:body";
    public static String GITHUB_HEADER = "Accept: \"application/vnd.github.cloak-preview\",";
    public static String GITHUB_PER_PAGE = "&per_page=";
    public static String GITHUB_RAGE_LIMIT = "&X-RateLimit-Limit=20";

    public static List<Issue> buscarAPI(String palavra, int per_page) throws Exception {
        try {
            System.out.println("---->" + GITHUB_URL_ISSUES + palavra + WORK_KEY + GITHUB_PER_PAGE + per_page + "<----");
            URL url = new URL(GITHUB_URL_ISSUES + palavra + WORK_KEY + GITHUB_PER_PAGE + per_page+GITHUB_RAGE_LIMIT);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(19000);
            connection.setReadTimeout(19000);

            if (connection.getResponseCode() != 200){
                throw new RuntimeException("HTTP error code : " + connection.getResponseCode());

            }
                BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
                return Util.converteJsonEmString(response);

        } catch (Exception e) {
            return null;
        }
    }
}