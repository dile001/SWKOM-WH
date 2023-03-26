package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parcel")
public class ParcelEntity {
    @Id
    @Column
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;
    @Column
    @NotNull(message = "Weight cannot be null")
    @Min(value = 0, message = "Weight cannot be negative")
    private Float weight;
    @OneToOne
    @JoinColumn(name = "fk_recipient")
    @NotNull(message = "Recipient ID cannot be null")
    private RecipientEntity recipient;
    @OneToOne
    @JoinColumn(name = "fk_sender")
    @NotNull(message = "Sender ID cannot be null")
    private RecipientEntity sender;
    @Column
    @NotNull(message = "State cannot be null")
    private TrackingInformation.StateEnum state;
    @OneToMany(mappedBy = "parcel")
    @NotNull(message = "Visited Hops cannot be null")
    private List<HopArrivalEntity> visitedHops;
    @OneToMany(mappedBy = "parcel")
    @NotNull(message = "Future Hops cannot be null")
    private List<HopArrivalEntity> futureHops;
}
