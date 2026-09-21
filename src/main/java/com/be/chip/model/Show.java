package com.be.chip.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TABLE_PLAYLIST")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID showId;

    @Column(name = "concert_name")
    private String concertName;

    @Column(name = "concert_price")
    private double concertPrice;

    @FutureOrPresent
    @Column(name = "concert_date")
    private LocalDateTime concertDate;

    @Column(name = "link_box_office")
    private String linkBoxOffice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    public Show(UUID showId, String concertName, double concertPrice, LocalDateTime concertDate, String linkBoxOffice, Artist artist) {
        this.showId = showId;
        this.concertName = concertName;
        this.concertPrice = concertPrice;
        this.concertDate = concertDate;
        this.linkBoxOffice = linkBoxOffice;
        this.artist = artist;
    }

    public Show() {
    }

    public UUID getShowId() {
        return showId;
    }

    public void setShowId(UUID showId) {
        this.showId = showId;
    }

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public double getConcertPrice() {
        return concertPrice;
    }

    public void setConcertPrice(double concertPrice) {
        this.concertPrice = concertPrice;
    }

    public LocalDateTime getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(LocalDateTime concertDate) {
        this.concertDate = concertDate;
    }

    public String getLinkBoxOffice() {
        return linkBoxOffice;
    }

    public void setLinkBoxOffice(String linkBoxOffice) {
        this.linkBoxOffice = linkBoxOffice;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
