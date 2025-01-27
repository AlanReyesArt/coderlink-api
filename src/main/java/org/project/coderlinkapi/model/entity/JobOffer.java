package org.project.coderlinkapi.model.entity;


import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "joboffer")
@Data
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_offer_id;
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    @Column(name = "budget", nullable = false)
    private Double budget;
    @Column(name = "duration", nullable = false)
    private int duration;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;
    //@ElementCollection
    //    @CollectionTable(name = "job_offer_skills", joinColumns = @JoinColumn(name = "job_offer_id"))
    //    @Column(name = "habilidad")
    //    private List<String> habilidades;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_customer_id"))
    private Customer client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_project_id"))
    private Project project;
}
