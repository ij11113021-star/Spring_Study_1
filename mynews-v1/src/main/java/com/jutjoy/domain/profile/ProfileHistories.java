package com.jutjoy.domain.profile;

import java.sql.Timestamp;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@DynamicUpdate
@Table(name="profile_histories")
@Data
@EntityListeners(AuditingEntityListener.class)
public class ProfileHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "profile_id")
    private Integer profileId;

    @LastModifiedDate
    @Column(name = "edited_date")
    private Timestamp editedDate;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Profile profile;
}
