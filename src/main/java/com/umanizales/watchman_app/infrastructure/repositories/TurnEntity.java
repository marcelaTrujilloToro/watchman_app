package com.umanizales.watchman_app.infrastructure.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "turn", schema = "public", catalog = "watchman-app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TurnEntity {
    @Id
    @Column(name = "code", nullable = false)
    private int code;
    @Basic
    @Column(name = "date ", nullable = false)
    private Date date;
    @Basic
    @Column(name = "hourStart", nullable = false)
    private Time hourStart;
    @Basic
    @Column(name = "hourEnd", nullable = false)
    private Time hourEnd;
    private DiaryEntity diary;
    private NotificationEntity notification;
    private WatchmanEntity watchman;


    @ManyToOne
    @JoinColumn(name = "codeDiary", referencedColumnName = "code", nullable = false)
    public DiaryEntity getDiary() {
        return diary;
    }

    public void setDiary(DiaryEntity diary) {
        this.diary = diary;
    }

    @ManyToOne
    @JoinColumn(name = "codeNotification", referencedColumnName = "code", nullable = false)
    public NotificationEntity getNotification() {
        return notification;
    }

    public void setNotification(NotificationEntity notification) {
        this.notification = notification;
    }

    @ManyToOne
    @JoinColumn(name = "codeWatchman", referencedColumnName = "code", nullable = false)
    public WatchmanEntity getWatchman() {
        return watchman;
    }

    public void setWatchman(WatchmanEntity watchman) {
        this.watchman = watchman;
    }
}
