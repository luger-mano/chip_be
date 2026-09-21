CREATE TABLE listeners
(
    listener_id    UUID PRIMARY KEY,
    full_name      VARCHAR(255),
    email          VARCHAR(255),
    password       VARCHAR(255),
    phone          VARCHAR(50),
    date_birth     DATE,
    account_active BOOLEAN,
    created_at     DATE,
    last_access    TIMESTAMP
);

CREATE TABLE artists
(
    listener_id UUID PRIMARY KEY,
    artist_name VARCHAR(255),
    bio         TEXT,

    CONSTRAINT fk_artist_listener
        FOREIGN KEY (listener_id)
            REFERENCES listeners (listener_id)
            ON DELETE CASCADE
);

CREATE TABLE songs
(
    song_id       UUID PRIMARY KEY,
    title         VARCHAR(255),
    artist_id     UUID NOT NULL,
    song_duration VARCHAR(50),
    release_date  DATE,

    CONSTRAINT fk_song_artist
        FOREIGN KEY (artist_id)
            REFERENCES artists (listener_id)
            ON DELETE CASCADE
);

CREATE TABLE shows
(
    show_id         UUID PRIMARY KEY,
    concert_name    VARCHAR(255),
    concert_price   DOUBLE PRECISION,
    concert_date    TIMESTAMP,
    link_box_office VARCHAR(500),
    artist_id       UUID NOT NULL,

    CONSTRAINT fk_show_artist
        FOREIGN KEY (artist_id)
            REFERENCES artists (listener_id)
            ON DELETE CASCADE
);

CREATE TABLE playlists
(
    playlist_id   UUID PRIMARY KEY,
    playlist_name VARCHAR(255),
    listener_id   UUID NOT NULL,
    created_at    DATE,

    CONSTRAINT fk_playlist_listener
        FOREIGN KEY (listener_id)
            REFERENCES listeners (listener_id)
            ON DELETE CASCADE
);

CREATE TABLE playlist_songs
(
    playlist_id UUID NOT NULL,
    song_id     UUID NOT NULL,

    PRIMARY KEY (playlist_id, song_id),

    CONSTRAINT fk_playlist_songs_playlist
        FOREIGN KEY (playlist_id)
            REFERENCES playlists (playlist_id)
            ON DELETE CASCADE,

    CONSTRAINT fk_playlist_songs_song
        FOREIGN KEY (song_id)
            REFERENCES songs (song_id)
            ON DELETE CASCADE
);
