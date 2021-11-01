package com.umanizales.watchman_app.infrastructure.repositories;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "readingLog", schema = "public", catalog = "watchman-app")
public class ReadingLogEntity {
    private int code;
    private Timestamp hour;
    private Date date;
    private WatchmanEntity watchman;
    private CheckPointEntity checkPoint;

    @Id
    @Column(name = "code", nullable = false)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReadingLogEntity that = (ReadingLogEntity) o;

        if (code != that.code) return false;
        if (hour != null ? !hour.equals(that.hour) : that.hour != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (hour != null ? hour.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "codeWatchman", referencedColumnName = "code", nullable = false)
    public WatchmanEntity getWatchman() {
        return watchman;
    }

    public void setWatchman(WatchmanEntity watchman) {
        this.watchman = watchman;
    }

    @ManyToOne
    @JoinColumn(name = "codeCheckPoint", referencedColumnName = "code", nullable = false)
    public CheckPointEntity getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(CheckPointEntity checkPoint) {
        this.checkPoint = checkPoint;
    }
}
