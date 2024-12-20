package parser;

import java.util.List;

public class Article {
  private String name;
  private String description;
  private String date;
  private String link;
  private List<String> mediaLinks;

  public Article(String name, String description, String date, String link, List<String> mediaLinks) {
    this.name = name;
    this.description = description;
    this.date = date;
    this.link = link;
    this.mediaLinks = mediaLinks;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getDate() {
    return date;
  }

  public String getLink() {
    return link;
  }

  public List<String> getMediaLinks() {
    return mediaLinks;
  }
}