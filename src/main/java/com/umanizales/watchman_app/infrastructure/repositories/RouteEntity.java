package com.umanizales.watchman_app.infrastructure.repositories;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "route", schema = "public", catalog = "watchman-app")
public class RouteEntity {
    private int code;
    private Timestamp hour;
    private CheckPointEntity chechPoint;
    private TurnEntity turn;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteEntity that = (RouteEntity) o;

        if (code != that.code) return false;
        if (hour != null ? !hour.equals(that.hour) : that.hour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (hour != null ? hour.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "codeCheckpoint", referencedColumnName = "code", nullable = false)
    public CheckPointEntity getChechPoint() {
        return chechPoint;
    }

    public void setChechPoint(CheckPointEntity chechPoint) {
        this.chechPoint = chechPoint;
    }

    @ManyToOne
    @JoinColumn(name = "codeTurn", referencedColumnName = "code", nullable = false)
    public TurnEntity getTurn() {
        return turn;
    }

    public void setTurn(TurnEntity turn) {
        this.turn = turn;
    }
}
