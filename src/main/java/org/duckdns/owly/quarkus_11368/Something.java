package org.duckdns.owly.quarkus_11368;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Entity
@Audited
public class Something extends PanacheEntity {
    private String name;

    public Something() {}

    public Something(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
