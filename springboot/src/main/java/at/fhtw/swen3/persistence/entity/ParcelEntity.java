package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParcelEntity {
    private String trackingId;
    private Float weight;
    private Long recipient;
    private Long sender;
    private TrackingInformation.StateEnum state;
    private List<Long> visitedHops;
    private List<Long> futureHops;
}
