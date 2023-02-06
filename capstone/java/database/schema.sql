ROLLBACK;
BEGIN TRANSACTION;
DROP TABLE IF EXISTS users, band, follower,photo, genre, genre_band, notification, inbox;
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	darkMode boolean DEFAULT TRUE NOT NULL;
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE
CREATE TABLE band(
	band_id SERIAL,
	band_name text NOT NULL,
	description text,
	image varchar(260),
	user_id int NOT NULL,
	CONSTRAINT PK_band PRIMARY KEY(band_id),
	CONSTRAINT FK_band_users FOREIGN KEY(user_id) REFERENCES users(user_id)
	);
CREATE TABLE follower(
	user_id int,
	band_id int,
	CONSTRAINT PK_follower PRIMARY KEY(user_id, band_id),
	CONSTRAINT FK_follower_users FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT FK_follower_band FOREIGN KEY (band_id) REFERENCES band(band_id)
	);

CREATE TABLE photo (
	photo_id SERIAL,
	img_url varchar(260),
	band_id int,
	CONSTRAINT PK_photo PRIMARY KEY (photo_id),
	CONSTRAINT FK_photo_band FOREIGN KEY (band_id) REFERENCES band(band_id)
);
CREATE TABLE genre(
	genre_id SERIAL,
	genre_name varchar NOT NULL UNIQUE,
	CONSTRAINT PK_genre PRIMARY KEY(genre_id)
);
CREATE TABLE genre_band(
	genre_id int,
	band_id int,
	CONSTRAINT PK_genre_band PRIMARY KEY(genre_id, band_id),
	CONSTRAINT FK_genre_band_genre FOREIGN KEY(genre_id) REFERENCES genre(genre_id),
	CONSTRAINT FK_genre_band_band FOREIGN KEY (band_id) REFERENCES band(band_id)
);

CREATE TABLE notification(
	notif_id SERIAL,
	band_id int,
	message text NOT NULL,
	message_date DATE,
	CONSTRAINT PK_notification PRIMARY KEY(notif_id),
	CONSTRAINT FK_notification_band FOREIGN KEY (band_id) REFERENCES band(band_id)
);
CREATE TABLE inbox(
	notif_id int,
	user_id int,
	CONSTRAINT PK_inbox PRIMARY KEY(user_id, notif_id),
	CONSTRAINT FK_inbox_user FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT FK_inbox_notification FOREIGN KEY (notif_id) REFERENCES  notification(notif_id)
);
COMMIT TRANSACTION;
