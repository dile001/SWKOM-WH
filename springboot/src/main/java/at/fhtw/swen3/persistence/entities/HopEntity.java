package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hop")
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column
    private Long id;
    @Column
    private String hopType;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @Column
    @OneToOne(mappedBy = "geoCoordinate")
    private GeoCoordinateEntity locationCoordinates;
}
