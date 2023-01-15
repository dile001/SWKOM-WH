package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouse")
public class WarehouseEntity extends HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column
    private Long id;

    @Column
    private Integer level;

    @Column
    @OneToMany(mappedBy = "warehouse")
    private List<WarehouseNextHopsEntity> nextHops;
}
