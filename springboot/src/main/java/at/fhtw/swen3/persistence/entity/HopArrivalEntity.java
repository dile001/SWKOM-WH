package at.fhtw.swen3.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HopArrivalEntity {
    private Long id;
    private String code;
    private String description;
    private OffsetDateTime dateTime;
    private Long parcel;

    public HopArrivalEntity(String code, String description, OffsetDateTime dateTime){
        this.code = code;
        this.description = description;
        this.dateTime = dateTime;
    }
}
