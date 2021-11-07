package com.umanizales.watchman_app.infrastructure.repositories.entity;

import com.umanizales.watchman_app.domain.WatchmanDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "watchman", schema = "public", catalog = "watchman-app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WatchmanEntity {
    @Id
    @Column(name = "code", nullable = false)
    private UUID code;
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic
    @Column(name = "lastname", nullable = false, length = 30)
    private String lastname;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "telephone", nullable = false, length = 10)
    private String telephone;

    public WatchmanEntity(WatchmanDTO watchmanDTO) {
        BeanUtils.copyProperties(watchmanDTO, this);
        this.code = UUID.randomUUID();
    }

    public WatchmanDTO toWatchmanDTO(){
        WatchmanDTO watchmanDTO = new WatchmanDTO();
        BeanUtils.copyProperties(this, watchmanDTO);
        return watchmanDTO;
    }
}
