package com.hardikgoswami.githubmetrics.network;

import com.hardikgoswami.githubmetrics.network.Owner;
import java.io.Serializable;

public class UserRepo implements Serializable
{

    private Integer id;
    private String name;
    private String full_name;
    private Owner owner;
    private Boolean _private;
    private String html_url;
    private Object description;
    private Boolean fork;
    private String url;
    private String forks_url;
    private String keys_url;
    private String collaborators_url;
    private String teams_url;
    private String hooks_url;
    private String issue_events_url;
    private String events_url;
    private String assignees_url;
    private String branches_url;
    private String tags_url;
    private String blobs_url;
    private String git_tags_url;
    private String git_refs_url;
    private String trees_url;
    private String statuses_url;
    private String languages_url;
    private String stargazers_url;
    private String contributors_url;
    private String subscribers_url;
    private String subscription_url;
    private String commits_url;
    private String git_commits_url;
    private String comments_url;
    private String issue_comment_url;
    private String contents_url;
    private String compare_url;
    private String merges_url;
    private String archive_url;
    private String downloads_url;
    private String issues_url;
    private String pulls_url;
    private String milestones_url;
    private String notifications_url;
    private String labels_url;
    private String releases_url;
    private String deployments_url;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String git_url;
    private String ssh_url;
    private String clone_url;
    private String svn_url;
    private Object homepage;
    private Integer size;
    private Integer stargazers_count;
    private Integer watchers_count;
    private String language;
    private Boolean has_issues;
    private Boolean has_downloads;
    private Boolean has_wiki;
    private Boolean has_pages;
    private Integer forks_count;
    private Object mirror_url;
    private Integer open_issues_count;
    private Integer forks;
    private Integer open_issues;
    private Integer watchers;
    private String default_branch;
    private final static long serialVersionUID = 461172976270492625L;

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
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The full_name
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * 
     * @param full_name
     *     The full_name
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * 
     * @return
     *     The owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The owner
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * 
     * @return
     *     The _private
     */
    public Boolean getPrivate() {
        return _private;
    }

    /**
     * 
     * @param _private
     *     The private
     */
    public void setPrivate(Boolean _private) {
        this._private = _private;
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
     *     The description
     */
    public Object getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The fork
     */
    public Boolean getFork() {
        return fork;
    }

    /**
     * 
     * @param fork
     *     The fork
     */
    public void setFork(Boolean fork) {
        this.fork = fork;
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
     *     The forks_url
     */
    public String getForks_url() {
        return forks_url;
    }

    /**
     * 
     * @param forks_url
     *     The forks_url
     */
    public void setForks_url(String forks_url) {
        this.forks_url = forks_url;
    }

    /**
     * 
     * @return
     *     The keys_url
     */
    public String getKeys_url() {
        return keys_url;
    }

    /**
     * 
     * @param keys_url
     *     The keys_url
     */
    public void setKeys_url(String keys_url) {
        this.keys_url = keys_url;
    }

    /**
     * 
     * @return
     *     The collaborators_url
     */
    public String getCollaborators_url() {
        return collaborators_url;
    }

    /**
     * 
     * @param collaborators_url
     *     The collaborators_url
     */
    public void setCollaborators_url(String collaborators_url) {
        this.collaborators_url = collaborators_url;
    }

    /**
     * 
     * @return
     *     The teams_url
     */
    public String getTeams_url() {
        return teams_url;
    }

    /**
     * 
     * @param teams_url
     *     The teams_url
     */
    public void setTeams_url(String teams_url) {
        this.teams_url = teams_url;
    }

    /**
     * 
     * @return
     *     The hooks_url
     */
    public String getHooks_url() {
        return hooks_url;
    }

    /**
     * 
     * @param hooks_url
     *     The hooks_url
     */
    public void setHooks_url(String hooks_url) {
        this.hooks_url = hooks_url;
    }

    /**
     * 
     * @return
     *     The issue_events_url
     */
    public String getIssue_events_url() {
        return issue_events_url;
    }

    /**
     * 
     * @param issue_events_url
     *     The issue_events_url
     */
    public void setIssue_events_url(String issue_events_url) {
        this.issue_events_url = issue_events_url;
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
     *     The assignees_url
     */
    public String getAssignees_url() {
        return assignees_url;
    }

    /**
     * 
     * @param assignees_url
     *     The assignees_url
     */
    public void setAssignees_url(String assignees_url) {
        this.assignees_url = assignees_url;
    }

    /**
     * 
     * @return
     *     The branches_url
     */
    public String getBranches_url() {
        return branches_url;
    }

    /**
     * 
     * @param branches_url
     *     The branches_url
     */
    public void setBranches_url(String branches_url) {
        this.branches_url = branches_url;
    }

    /**
     * 
     * @return
     *     The tags_url
     */
    public String getTags_url() {
        return tags_url;
    }

    /**
     * 
     * @param tags_url
     *     The tags_url
     */
    public void setTags_url(String tags_url) {
        this.tags_url = tags_url;
    }

    /**
     * 
     * @return
     *     The blobs_url
     */
    public String getBlobs_url() {
        return blobs_url;
    }

    /**
     * 
     * @param blobs_url
     *     The blobs_url
     */
    public void setBlobs_url(String blobs_url) {
        this.blobs_url = blobs_url;
    }

    /**
     * 
     * @return
     *     The git_tags_url
     */
    public String getGit_tags_url() {
        return git_tags_url;
    }

    /**
     * 
     * @param git_tags_url
     *     The git_tags_url
     */
    public void setGit_tags_url(String git_tags_url) {
        this.git_tags_url = git_tags_url;
    }

    /**
     * 
     * @return
     *     The git_refs_url
     */
    public String getGit_refs_url() {
        return git_refs_url;
    }

    /**
     * 
     * @param git_refs_url
     *     The git_refs_url
     */
    public void setGit_refs_url(String git_refs_url) {
        this.git_refs_url = git_refs_url;
    }

    /**
     * 
     * @return
     *     The trees_url
     */
    public String getTrees_url() {
        return trees_url;
    }

    /**
     * 
     * @param trees_url
     *     The trees_url
     */
    public void setTrees_url(String trees_url) {
        this.trees_url = trees_url;
    }

    /**
     * 
     * @return
     *     The statuses_url
     */
    public String getStatuses_url() {
        return statuses_url;
    }

    /**
     * 
     * @param statuses_url
     *     The statuses_url
     */
    public void setStatuses_url(String statuses_url) {
        this.statuses_url = statuses_url;
    }

    /**
     * 
     * @return
     *     The languages_url
     */
    public String getLanguages_url() {
        return languages_url;
    }

    /**
     * 
     * @param languages_url
     *     The languages_url
     */
    public void setLanguages_url(String languages_url) {
        this.languages_url = languages_url;
    }

    /**
     * 
     * @return
     *     The stargazers_url
     */
    public String getStargazers_url() {
        return stargazers_url;
    }

    /**
     * 
     * @param stargazers_url
     *     The stargazers_url
     */
    public void setStargazers_url(String stargazers_url) {
        this.stargazers_url = stargazers_url;
    }

    /**
     * 
     * @return
     *     The contributors_url
     */
    public String getContributors_url() {
        return contributors_url;
    }

    /**
     * 
     * @param contributors_url
     *     The contributors_url
     */
    public void setContributors_url(String contributors_url) {
        this.contributors_url = contributors_url;
    }

    /**
     * 
     * @return
     *     The subscribers_url
     */
    public String getSubscribers_url() {
        return subscribers_url;
    }

    /**
     * 
     * @param subscribers_url
     *     The subscribers_url
     */
    public void setSubscribers_url(String subscribers_url) {
        this.subscribers_url = subscribers_url;
    }

    /**
     * 
     * @return
     *     The subscription_url
     */
    public String getSubscription_url() {
        return subscription_url;
    }

    /**
     * 
     * @param subscription_url
     *     The subscription_url
     */
    public void setSubscription_url(String subscription_url) {
        this.subscription_url = subscription_url;
    }

    /**
     * 
     * @return
     *     The commits_url
     */
    public String getCommits_url() {
        return commits_url;
    }

    /**
     * 
     * @param commits_url
     *     The commits_url
     */
    public void setCommits_url(String commits_url) {
        this.commits_url = commits_url;
    }

    /**
     * 
     * @return
     *     The git_commits_url
     */
    public String getGit_commits_url() {
        return git_commits_url;
    }

    /**
     * 
     * @param git_commits_url
     *     The git_commits_url
     */
    public void setGit_commits_url(String git_commits_url) {
        this.git_commits_url = git_commits_url;
    }

    /**
     * 
     * @return
     *     The comments_url
     */
    public String getComments_url() {
        return comments_url;
    }

    /**
     * 
     * @param comments_url
     *     The comments_url
     */
    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    /**
     * 
     * @return
     *     The issue_comment_url
     */
    public String getIssue_comment_url() {
        return issue_comment_url;
    }

    /**
     * 
     * @param issue_comment_url
     *     The issue_comment_url
     */
    public void setIssue_comment_url(String issue_comment_url) {
        this.issue_comment_url = issue_comment_url;
    }

    /**
     * 
     * @return
     *     The contents_url
     */
    public String getContents_url() {
        return contents_url;
    }

    /**
     * 
     * @param contents_url
     *     The contents_url
     */
    public void setContents_url(String contents_url) {
        this.contents_url = contents_url;
    }

    /**
     * 
     * @return
     *     The compare_url
     */
    public String getCompare_url() {
        return compare_url;
    }

    /**
     * 
     * @param compare_url
     *     The compare_url
     */
    public void setCompare_url(String compare_url) {
        this.compare_url = compare_url;
    }

    /**
     * 
     * @return
     *     The merges_url
     */
    public String getMerges_url() {
        return merges_url;
    }

    /**
     * 
     * @param merges_url
     *     The merges_url
     */
    public void setMerges_url(String merges_url) {
        this.merges_url = merges_url;
    }

    /**
     * 
     * @return
     *     The archive_url
     */
    public String getArchive_url() {
        return archive_url;
    }

    /**
     * 
     * @param archive_url
     *     The archive_url
     */
    public void setArchive_url(String archive_url) {
        this.archive_url = archive_url;
    }

    /**
     * 
     * @return
     *     The downloads_url
     */
    public String getDownloads_url() {
        return downloads_url;
    }

    /**
     * 
     * @param downloads_url
     *     The downloads_url
     */
    public void setDownloads_url(String downloads_url) {
        this.downloads_url = downloads_url;
    }

    /**
     * 
     * @return
     *     The issues_url
     */
    public String getIssues_url() {
        return issues_url;
    }

    /**
     * 
     * @param issues_url
     *     The issues_url
     */
    public void setIssues_url(String issues_url) {
        this.issues_url = issues_url;
    }

    /**
     * 
     * @return
     *     The pulls_url
     */
    public String getPulls_url() {
        return pulls_url;
    }

    /**
     * 
     * @param pulls_url
     *     The pulls_url
     */
    public void setPulls_url(String pulls_url) {
        this.pulls_url = pulls_url;
    }

    /**
     * 
     * @return
     *     The milestones_url
     */
    public String getMilestones_url() {
        return milestones_url;
    }

    /**
     * 
     * @param milestones_url
     *     The milestones_url
     */
    public void setMilestones_url(String milestones_url) {
        this.milestones_url = milestones_url;
    }

    /**
     * 
     * @return
     *     The notifications_url
     */
    public String getNotifications_url() {
        return notifications_url;
    }

    /**
     * 
     * @param notifications_url
     *     The notifications_url
     */
    public void setNotifications_url(String notifications_url) {
        this.notifications_url = notifications_url;
    }

    /**
     * 
     * @return
     *     The labels_url
     */
    public String getLabels_url() {
        return labels_url;
    }

    /**
     * 
     * @param labels_url
     *     The labels_url
     */
    public void setLabels_url(String labels_url) {
        this.labels_url = labels_url;
    }

    /**
     * 
     * @return
     *     The releases_url
     */
    public String getReleases_url() {
        return releases_url;
    }

    /**
     * 
     * @param releases_url
     *     The releases_url
     */
    public void setReleases_url(String releases_url) {
        this.releases_url = releases_url;
    }

    /**
     * 
     * @return
     *     The deployments_url
     */
    public String getDeployments_url() {
        return deployments_url;
    }

    /**
     * 
     * @param deployments_url
     *     The deployments_url
     */
    public void setDeployments_url(String deployments_url) {
        this.deployments_url = deployments_url;
    }

    /**
     * 
     * @return
     *     The created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * 
     * @param created_at
     *     The created_at
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * 
     * @return
     *     The updated_at
     */
    public String getUpdated_at() {
        return updated_at;
    }

    /**
     * 
     * @param updated_at
     *     The updated_at
     */
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    /**
     * 
     * @return
     *     The pushed_at
     */
    public String getPushed_at() {
        return pushed_at;
    }

    /**
     * 
     * @param pushed_at
     *     The pushed_at
     */
    public void setPushed_at(String pushed_at) {
        this.pushed_at = pushed_at;
    }

    /**
     * 
     * @return
     *     The git_url
     */
    public String getGit_url() {
        return git_url;
    }

    /**
     * 
     * @param git_url
     *     The git_url
     */
    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    /**
     * 
     * @return
     *     The ssh_url
     */
    public String getSsh_url() {
        return ssh_url;
    }

    /**
     * 
     * @param ssh_url
     *     The ssh_url
     */
    public void setSsh_url(String ssh_url) {
        this.ssh_url = ssh_url;
    }

    /**
     * 
     * @return
     *     The clone_url
     */
    public String getClone_url() {
        return clone_url;
    }

    /**
     * 
     * @param clone_url
     *     The clone_url
     */
    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }

    /**
     * 
     * @return
     *     The svn_url
     */
    public String getSvn_url() {
        return svn_url;
    }

    /**
     * 
     * @param svn_url
     *     The svn_url
     */
    public void setSvn_url(String svn_url) {
        this.svn_url = svn_url;
    }

    /**
     * 
     * @return
     *     The homepage
     */
    public Object getHomepage() {
        return homepage;
    }

    /**
     * 
     * @param homepage
     *     The homepage
     */
    public void setHomepage(Object homepage) {
        this.homepage = homepage;
    }

    /**
     * 
     * @return
     *     The size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 
     * @param size
     *     The size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 
     * @return
     *     The stargazers_count
     */
    public Integer getStargazers_count() {
        return stargazers_count;
    }

    /**
     * 
     * @param stargazers_count
     *     The stargazers_count
     */
    public void setStargazers_count(Integer stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    /**
     * 
     * @return
     *     The watchers_count
     */
    public Integer getWatchers_count() {
        return watchers_count;
    }

    /**
     * 
     * @param watchers_count
     *     The watchers_count
     */
    public void setWatchers_count(Integer watchers_count) {
        this.watchers_count = watchers_count;
    }

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The has_issues
     */
    public Boolean getHas_issues() {
        return has_issues;
    }

    /**
     * 
     * @param has_issues
     *     The has_issues
     */
    public void setHas_issues(Boolean has_issues) {
        this.has_issues = has_issues;
    }

    /**
     * 
     * @return
     *     The has_downloads
     */
    public Boolean getHas_downloads() {
        return has_downloads;
    }

    /**
     * 
     * @param has_downloads
     *     The has_downloads
     */
    public void setHas_downloads(Boolean has_downloads) {
        this.has_downloads = has_downloads;
    }

    /**
     * 
     * @return
     *     The has_wiki
     */
    public Boolean getHas_wiki() {
        return has_wiki;
    }

    /**
     * 
     * @param has_wiki
     *     The has_wiki
     */
    public void setHas_wiki(Boolean has_wiki) {
        this.has_wiki = has_wiki;
    }

    /**
     * 
     * @return
     *     The has_pages
     */
    public Boolean getHas_pages() {
        return has_pages;
    }

    /**
     * 
     * @param has_pages
     *     The has_pages
     */
    public void setHas_pages(Boolean has_pages) {
        this.has_pages = has_pages;
    }

    /**
     * 
     * @return
     *     The forks_count
     */
    public Integer getForks_count() {
        return forks_count;
    }

    /**
     * 
     * @param forks_count
     *     The forks_count
     */
    public void setForks_count(Integer forks_count) {
        this.forks_count = forks_count;
    }

    /**
     * 
     * @return
     *     The mirror_url
     */
    public Object getMirror_url() {
        return mirror_url;
    }

    /**
     * 
     * @param mirror_url
     *     The mirror_url
     */
    public void setMirror_url(Object mirror_url) {
        this.mirror_url = mirror_url;
    }

    /**
     * 
     * @return
     *     The open_issues_count
     */
    public Integer getOpen_issues_count() {
        return open_issues_count;
    }

    /**
     * 
     * @param open_issues_count
     *     The open_issues_count
     */
    public void setOpen_issues_count(Integer open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    /**
     * 
     * @return
     *     The forks
     */
    public Integer getForks() {
        return forks;
    }

    /**
     * 
     * @param forks
     *     The forks
     */
    public void setForks(Integer forks) {
        this.forks = forks;
    }

    /**
     * 
     * @return
     *     The open_issues
     */
    public Integer getOpen_issues() {
        return open_issues;
    }

    /**
     * 
     * @param open_issues
     *     The open_issues
     */
    public void setOpen_issues(Integer open_issues) {
        this.open_issues = open_issues;
    }

    /**
     * 
     * @return
     *     The watchers
     */
    public Integer getWatchers() {
        return watchers;
    }

    /**
     * 
     * @param watchers
     *     The watchers
     */
    public void setWatchers(Integer watchers) {
        this.watchers = watchers;
    }

    /**
     * 
     * @return
     *     The default_branch
     */
    public String getDefault_branch() {
        return default_branch;
    }

    /**
     * 
     * @param default_branch
     *     The default_branch
     */
    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }

}
