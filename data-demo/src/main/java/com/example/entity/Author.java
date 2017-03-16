package com.example.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/16/2017.
 */

@Entity
@Table(name = "author")
public class Author {

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public Date dob;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    public Set<Book> books;

}
