CREATE TABLE IF NOT EXISTS contents (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  desc text,
  status VARCHAR(20),
  content_type VARCHAR(20),
  date_created TIMESTAMP,
  date_updated TIMESTAMP,
  url VARCHAR(255)
);

