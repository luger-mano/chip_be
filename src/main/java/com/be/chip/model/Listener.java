package com.be.chip.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TABLE_LISTENER")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Listener {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "listener_id")
    private UUID listenerId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    // private Plan plan;
    // private Playlist playlist;

    @Column(name = "account_active")
    private Boolean account_active;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_access")
    private LocalDateTime lastAccess;

    @OneToMany(
            mappedBy = "listener",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Playlist> playlists = new ArrayList<>();

    public Listener(UUID listenerId, String fullName, String email, String password, String phone, LocalDate dateBirth, Boolean account_active, LocalDate createdAt, LocalDateTime lastAccess, List<Playlist> playlists) {
        this.listenerId = listenerId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dateBirth = dateBirth;
        this.account_active = account_active;
        this.createdAt = createdAt;
        this.lastAccess = lastAccess;
        this.playlists = playlists;
    }

    public Listener() {

    }

    public UUID getListenerId() {
        return listenerId;
    }

    public void setListenerId(UUID listenerId) {
        this.listenerId = listenerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Boolean getAccount_active() {
        return account_active;
    }

    public void setAccount_active(Boolean account_active) {
        this.account_active = account_active;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
