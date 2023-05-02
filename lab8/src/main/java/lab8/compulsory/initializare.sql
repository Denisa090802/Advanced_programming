create table if not exists "albums".public."artists" (id serial constraint artists_pk primary key,name varchar(500));
create table if not exists "albums".public."genres" (id serial constraint generes_pk primary key,name varchar(500));
create table if not exists "albums".public."albums"
(
	id serial
		constraint albums_pk
			primary key,
	artist_id int	constraint artist_fk
			references artists,
	release_year int,
	title varchar(500)
);
create table if not exists "albums".public."albums_genre_assoc"
(
    album_id integer
        constraint albums_genre_assoc_albums_id_fk
            references albums,
    genre_id integer
        constraint albums_genre_assoc_genres_id_fk
            references genres
);