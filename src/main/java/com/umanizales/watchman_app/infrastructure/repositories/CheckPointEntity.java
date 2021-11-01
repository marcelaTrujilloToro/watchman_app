package com.umanizales.watchman_app.infrastructure.repositories;

import javax.persistence.*;

@Entity
@Table(name = "checkPoint", schema = "public", catalog = "watchman-app")
public class CheckPointEntity {
    private int code;
    private String description;
    private LocationEntity location;

    @Id
    @Column(name = "code", nullable = false)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

        CheckPointEntity that = (CheckPointEntity) o;

        if (code != that.code) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "codeLocaation", referencedColumnName = "code", nullable = false)
    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }
}
