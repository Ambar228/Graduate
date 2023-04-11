package edu.bru.eventmicroservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table (name = "EVENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "ID")
    private Long id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "DESCRIPTION")
    private String description;

    @Column (name = "PICTURE")
    private String picture;

    @Column (name = "DATA")
    private Date date;

    @ManyToOne
    private Type type;
}
