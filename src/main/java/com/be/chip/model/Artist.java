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
@Table(name = "TABLE_ARTIST")
public class Artist extends Listener{

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "bio")
    private String bio;

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Song> songs = new ArrayList<>();

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Show> shows = new ArrayList<>();

    public Artist(UUID listenerId, String fullName, String email, String password, String phone, LocalDate dateBirth, Boolean account_active, LocalDate createdAt, LocalDateTime lastAccess, List<Playlist> playlists, String artistName, String bio, List<Song> songs, List<Show> shows) {
        super(listenerId, fullName, email, password, phone, dateBirth, account_active, createdAt, lastAccess, playlists);
        this.artistName = artistName;
        this.bio = bio;
        this.songs = songs;
        this.shows = shows;
    }

    public Artist() {
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
