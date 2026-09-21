package com.be.chip.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TABLE_SONG")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "song_id")
    private UUID songId;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Column(name = "song_duration")
    private String songDuration;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    public Song(UUID songId, String title, Artist artist, String songDuration, LocalDate releaseDate) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.songDuration = songDuration;
        this.releaseDate = releaseDate;
    }

    public Song() {
    }

    public UUID getSongId() {
        return songId;
    }

    public void setSongId(UUID songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
