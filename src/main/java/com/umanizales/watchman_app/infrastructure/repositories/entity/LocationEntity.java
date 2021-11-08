package com.umanizales.watchman_app.infrastructure.repositories.entity;

import com.umanizales.watchman_app.domain.LocationDTO;
import com.umanizales.watchman_app.domain.WatchmanDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "location", schema = "public", catalog = "watchman-app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LocationEntity {
    @Id
    @Column(name = "code", nullable = false)
    private int code;
    @Basic
    @Column(name = "name", nullable = false, length = 70)
    private String name;
    @Basic
    @Column(name = "address", nullable = false, length = 50)
    private String address;

    public LocationEntity(LocationDTO locationDTO) {
        BeanUtils.copyProperties(locationDTO, this);
        // this.code = UUID.randomUUID();
    }

    public LocationDTO toLocationDTO(){
        LocationDTO locationDTO = new LocationDTO();
        BeanUtils.copyProperties(this, locationDTO);
        return locationDTO;
    }
}
