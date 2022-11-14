package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trackingInformation")
public class TrackingInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column
    private Long id;

    @Column
    private TrackingInformation.StateEnum state;

    @OneToMany(mappedBy = "trackingInformation")
    @NotNull(message = "Visited Hops cannot be null")
    private List<HopArrivalEntity> visitedHops;

    @OneToMany(mappedBy = "trackingInformation")
    @NotNull(message = "Future Hops cannot be null")
    private List<HopArrivalEntity> futureHops;

}
