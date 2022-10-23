package at.fhtw.swen3.model.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipient")
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column
    private Long id;
    @Column
    @NotNull(message = "Name cannot be null")
    private String name;
    @Column
    @NotNull(message = "Street cannot be null")
    @Pattern(regexp = "^[A-Za-z]+\s[A-Za-z0-9/]+$")
    private String street;
    @Column
    @NotNull(message = "Postal Code cannot be null")
    @Pattern(regexp = "^A-[0-9]{4}$")
    private String postalCode;
    @Column
    @NotNull(message = "City cannot be null")
    @Pattern(regexp = "^[A-Z][A-Za-z\s0-9-]+$")
    private String city;
    @Column
    @NotNull(message = "Country cannot be null")
    @Pattern(regexp = "^[A-Z][A-Za-z\s0-9-]+$")
    private String country;
    @OneToOne(mappedBy = "recipient")
    private ParcelEntity recipientParcel;
    @OneToOne(mappedBy = "sender")
    private ParcelEntity senderParcel;

    public RecipientEntity(String name, String street, String postalCode, String city, String country){
        this.name = name;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }
}
