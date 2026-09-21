package com.be.chip.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TABLE_PLAYLIST")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "playlist_id")
    private UUID playlistId;

    @Column(name = "playlist_name")
    private String playlistName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listener_id", nullable = false)
    private Listener listener;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToMany
    @JoinTable(
            name = "playlist_songs",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs = new ArrayList<>();

    public Playlist(UUID playlistId, String playlistName, Listener listener, LocalDate createdAt, List<Song> songs) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.listener = listener;
        this.createdAt = createdAt;
        this.songs = songs;
    }

    public Playlist() {
    }

    public UUID getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(UUID playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
