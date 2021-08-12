package com.cieep.ejercicio01_retrofit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book {
    @SerializedName("ID")
    private String id;
    private String title;
    private String author;
    private String content;
    @SerializedName("content_short")
    private String contentShort;
    private String publisher;
    @SerializedName("publisher_date")
    private String publisherDate;
    private String pages;
    private String language;
    @SerializedName("url_details")
    private String urlDetails;
    @SerializedName("url_download")
    private String urlDownload;
    private String cover;
    private String thumbnail;
    @SerializedName("num_comments")
    private String numComments;
    private List<Category> categories;
    private List<Tag> tags;

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getAuthor() { return author; }
    public void setAuthor(String value) { this.author = value; }

    public String getContent() { return content; }
    public void setContent(String value) { this.content = value; }

    public String getContentShort() { return contentShort; }
    public void setContentShort(String value) { this.contentShort = value; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String value) { this.publisher = value; }

    public String getPublisherDate() { return publisherDate; }
    public void setPublisherDate(String value) { this.publisherDate = value; }

    public String getPages() { return pages; }
    public void setPages(String value) { this.pages = value; }

    public String getLanguage() { return language; }
    public void setLanguage(String value) { this.language = value; }

    public String getURLDetails() { return urlDetails; }
    public void setURLDetails(String value) { this.urlDetails = value; }

    public String getURLDownload() { return urlDownload; }
    public void setURLDownload(String value) { this.urlDownload = value; }

    public String getCover() { return cover; }
    public void setCover(String value) { this.cover = value; }

    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String value) { this.thumbnail = value; }

    public String getNumComments() { return numComments; }
    public void setNumComments(String value) { this.numComments = value; }

    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> value) { this.categories = value; }

    public List<Tag> getTags() { return tags; }
    public void setTags(List<Tag> value) { this.tags = value; }
}
