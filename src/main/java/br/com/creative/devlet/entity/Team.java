package br.com.creative.devlet.entity;

import br.com.creative.devlet.compositekeys.TeamPrimaryKey;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(TeamPrimaryKey.class)
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private String name;

    @Column
    private Timestamp date;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
