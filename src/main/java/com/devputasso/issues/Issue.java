package com.devputasso.issues;

public class Issue {

    private String body;
    private String url;
    private String title;
    private String login;

    public Issue(String body, String url, String title, String login) {
        this.body = body;
        this.url = url;
        this.title = title;
        this.login = login;
    }
//[{\"login\":]| \"title\":| \"body\":| \"url\":| \"repository_url\":"
    public Issue(){}

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "body='" + body + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
