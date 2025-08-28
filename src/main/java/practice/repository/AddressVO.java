package practice.repository;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public final class AddressVO {
    private final String city;
    private final String street;
    private final String zipcode;

    public AddressVO(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AddressVO adv = (AddressVO) o;
        return city == adv.city && street == adv.street && zipcode == adv.zipcode;
    }


    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }

    @Override
    public String toString() {
        return "AddressVO{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
