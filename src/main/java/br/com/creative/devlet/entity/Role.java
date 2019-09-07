package br.com.creative.devlet.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Data
public class Role {

    @Id
    @SequenceGenerator(name = "role_id_generator", sequenceName = "role_id_seq")
    @GeneratedValue(generator = "role_id_generator")
    Long id;

    @Column(name="name", unique = true)
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
