package com.umanizales.watchman_app.infrastructure.repositories;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "diary", schema = "public", catalog = "watchman-app")
public class DiaryEntity {
    private int code;
    private String title;
    private Timestamp hour;
    private byte[] image;
    private String description;

    @Id
    @Column(name = "code", nullable = false)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "hour", nullable = false)
    public Timestamp getHour() {
        return hour;
    }

    public void setHour(Timestamp hour) {
        this.hour = hour;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiaryEntity that = (DiaryEntity) o;

        if (code != that.code) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (hour != null ? !hour.equals(that.hour) : that.hour != null) return false;
        if (!Arrays.equals(image, that.image)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (hour != null ? hour.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
