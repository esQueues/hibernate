package project1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Person owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Item(String name, Person owner) {
        this.name = name;
        this.owner = owner;
    }

    public Item() {

    }
}
