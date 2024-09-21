package com.store.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    // Many-to-One relationship with Application
    @ManyToOne
    @JoinColumn(name = "app_id", nullable = false)
    private Application application;

    // Assuming a User entity exists and it has a One-to-Many relationship with Review
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private Date reviewDate;

    // Getters and Setters
    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", application=" + application + ", user=" + user + ", comment="
				+ comment + ", rating=" + rating + ", reviewDate=" + reviewDate + "]";
	}

    
}