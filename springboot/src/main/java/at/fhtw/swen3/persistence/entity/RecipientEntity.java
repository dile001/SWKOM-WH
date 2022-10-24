package at.fhtw.swen3.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipientEntity {
    private Long id;
    private String name;
    private String street;
    private String postalCode;
    private String city;
    private String country;
    private Long recipientParcel;
    private Long senderParcel;

    public RecipientEntity(String name, String street, String postalCode, String city, String country){
        this.name = name;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }
}
