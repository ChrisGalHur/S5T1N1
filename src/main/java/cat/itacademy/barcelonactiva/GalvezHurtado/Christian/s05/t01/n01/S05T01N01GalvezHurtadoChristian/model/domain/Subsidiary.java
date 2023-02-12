package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "subsidiary")
public class Subsidiary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Subsidiary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
