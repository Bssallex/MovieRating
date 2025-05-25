CREATE TABLE movies(
  id BIGSERIAL PRIMARY KEY,
  movie_title VARCHAR(255),
  description TEXT,
  genre VARCHAR(255),
  review VARCHAR(255),
  user_experience TEXT,
  rating NUMERIC(3,1),
  release_year TIMESTAMP,
  watched_at TIMESTAMP
)