package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hopArrival")
public class HopArrivalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column
    private Long id;
    @Column
    @NotNull(message = "Code cannot be null")
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;
    @Column
    @NotNull(message = "Description cannot be null")
    @Pattern(regexp = "^[A-Za-z\s0-9-]+$")
    private String description;
    @Column
    @NotNull(message = "Date and Time cannot be null")
    private OffsetDateTime dateTime;

}
