package domain;

import dao.core.Identefire;

import java.time.LocalDateTime;

public class Category implements Identefire {
    private int id;
    private String title;
    private LocalDateTime created;

    public Category() {
       }
    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Category(int id, String title, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
