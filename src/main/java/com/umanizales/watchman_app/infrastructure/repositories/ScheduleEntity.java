package com.umanizales.watchman_app.infrastructure.repositories;

import javax.persistence.*;

@Entity
@Table(name = "schedule", schema = "public", catalog = "watchman-app")
public class ScheduleEntity {
    private int code;
    private WatchmanEntity whatchman;
    private RouteEntity route;

    @Id
    @Column(name = "code", nullable = false)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntity that = (ScheduleEntity) o;

        if (code != that.code) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return code;
    }

    @ManyToOne
    @JoinColumn(name = "codeWatchman", referencedColumnName = "code", nullable = false)
    public WatchmanEntity getWhatchman() {
        return whatchman;
    }

    public void setWhatchman(WatchmanEntity whatchman) {
        this.whatchman = whatchman;
    }

    @ManyToOne
    @JoinColumn(name = "codeRoute", referencedColumnName = "code", nullable = false)
    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }
}
