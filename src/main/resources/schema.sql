CREATE TABLE IF NOT EXISTS contents (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255),
  description text,
  status VARCHAR(20),
  content_type VARCHAR(20),
  date_created TIMESTAMP,
  date_updated TIMESTAMP,
  url VARCHAR(255)
);

