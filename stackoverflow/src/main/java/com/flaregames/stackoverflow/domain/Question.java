package com.flaregames.stackoverflow.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/*
Question Domain Object
 */
@Builder
@Entity(name = "Question")
@Table(name = "question")
public class Question {
    public Question() {
    }

    public Question(Integer id, Set<Tag> tags, boolean isAnswered, int viewCount, int answerCount, String createDate, int userId) {
        this.id = id;
        this.tags = tags;
        this.isAnswered = isAnswered;
        this.viewCount = viewCount;
        this.answerCount = answerCount;
        this.createDate = createDate;
        this.userId = userId;
    }

    @Id  // primary key
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_tag",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))

    private Set<Tag> tags = new HashSet<>();

    @Column(name = "is_answered")
    private boolean isAnswered;

    @Column(name = "view_count")
    private int viewCount;

    @Column(name = "answer_count")
    private int answerCount;

    @Column(name = "creation_date")
    private String createDate;

    @Column(name = "user_id")
    private int userId;


    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getQuestions().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getQuestions().remove(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        return id != null && id.equals(((Question) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
