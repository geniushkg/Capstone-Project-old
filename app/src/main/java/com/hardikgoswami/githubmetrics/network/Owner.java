package com.hardikgoswami.githubmetrics.network;

import java.io.Serializable;

public class Owner implements Serializable
{

    private String login;
    private Integer id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private Boolean site_admin;
    private final static long serialVersionUID = 787471488418342218L;

    /**
     * 
     * @return
     *     The login
     */
    public String getLogin() {
        return login;
    }

    /**
     * 
     * @param login
     *     The login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The avatar_url
     */
    public String getAvatar_url() {
        return avatar_url;
    }

    /**
     * 
     * @param avatar_url
     *     The avatar_url
     */
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    /**
     * 
     * @return
     *     The gravatar_id
     */
    public String getGravatar_id() {
        return gravatar_id;
    }

    /**
     * 
     * @param gravatar_id
     *     The gravatar_id
     */
    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The html_url
     */
    public String getHtml_url() {
        return html_url;
    }

    /**
     * 
     * @param html_url
     *     The html_url
     */
    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    /**
     * 
     * @return
     *     The followers_url
     */
    public String getFollowers_url() {
        return followers_url;
    }

    /**
     * 
     * @param followers_url
     *     The followers_url
     */
    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    /**
     * 
     * @return
     *     The following_url
     */
    public String getFollowing_url() {
        return following_url;
    }

    /**
     * 
     * @param following_url
     *     The following_url
     */
    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    /**
     * 
     * @return
     *     The gists_url
     */
    public String getGists_url() {
        return gists_url;
    }

    /**
     * 
     * @param gists_url
     *     The gists_url
     */
    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    /**
     * 
     * @return
     *     The starred_url
     */
    public String getStarred_url() {
        return starred_url;
    }

    /**
     * 
     * @param starred_url
     *     The starred_url
     */
    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    /**
     * 
     * @return
     *     The subscriptions_url
     */
    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    /**
     * 
     * @param subscriptions_url
     *     The subscriptions_url
     */
    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    /**
     * 
     * @return
     *     The organizations_url
     */
    public String getOrganizations_url() {
        return organizations_url;
    }

    /**
     * 
     * @param organizations_url
     *     The organizations_url
     */
    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    /**
     * 
     * @return
     *     The repos_url
     */
    public String getRepos_url() {
        return repos_url;
    }

    /**
     * 
     * @param repos_url
     *     The repos_url
     */
    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    /**
     * 
     * @return
     *     The events_url
     */
    public String getEvents_url() {
        return events_url;
    }

    /**
     * 
     * @param events_url
     *     The events_url
     */
    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    /**
     * 
     * @return
     *     The received_events_url
     */
    public String getReceived_events_url() {
        return received_events_url;
    }

    /**
     * 
     * @param received_events_url
     *     The received_events_url
     */
    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The site_admin
     */
    public Boolean getSite_admin() {
        return site_admin;
    }

    /**
     * 
     * @param site_admin
     *     The site_admin
     */
    public void setSite_admin(Boolean site_admin) {
        this.site_admin = site_admin;
    }

}
