package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.dto;

import java.util.Arrays;

public class SubsidiaryDTO {

    private long id;
    private String name;
    private String country;
    private String EUVerified;

    private String[] EUCountries = {"Germany", "Austria", "Belgium", "Bulgaria",
            "Cyprus", "Croatia", "Denmark", "Spain", "Slovakia", "Slovenia", "Estonia", "Finland", "France",
            "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malt", "Netherlands",
            "Poland", "Portugal", "Czech Republic", "Romania", "Sweden"};

    public SubsidiaryDTO() {
    }

    public SubsidiaryDTO(long id,String name, String country,String EUVerified) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.EUVerified = checkEUMember(EUVerified);
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getEUVerified() {
        return EUVerified;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEUVerified(String euVerifier) {
        EUVerified = euVerifier;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String checkEUMember(String euVerifier) {
        boolean belongs = Arrays.stream(EUCountries)
                .anyMatch(v -> v.equalsIgnoreCase(euVerifier));
        if (belongs){
            return "EU";
        }else{
            return "NOT UE";
        }
    }
}
