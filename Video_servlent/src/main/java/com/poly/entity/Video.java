package com.poly.entity;

import javax.persistence.*;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code; // Mã video

    @Column(length = 1000)
    private String description;

    private String poster;

    private Integer views = 0;

    private Integer shares = 0;

    private Integer likes = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // Constructors
    public Video() {}

    public Video(String title, String code, String description, String poster, Category category) {
        this.title = title;
        this.code = code;
        this.description = description;
        this.poster = poster;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public Integer getViews() { return views; }
    public void setViews(Integer views) { this.views = views; }

    public Integer getShares() { return shares; }
    public void setShares(Integer shares) { this.shares = shares; }

    public Integer getLikes() { return likes; }
    public void setLikes(Integer likes) { this.likes = likes; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
