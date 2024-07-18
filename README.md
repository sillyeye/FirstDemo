# Getting Started

## Build the project
```bash
gradle build
```

## Docker related commands
```bash
# Shutdown the running containers defined in compose.yml
docker-compose down

# Build the docker image
docker-compose build

# Run the docker containers defined in compose.yml in detached mode
docker-compose up -d

# Check the docker logs
docker-compose logs

# Check the running containers
docker ps

# Login the mysql container
docker exec -it first-mysql-container mysql -uroot -ppassword
```

## Mysql
```
# Show all databases
show databases;

# Switch to the first_demo database.
use first_demo;

# Show all tables in current database
show tables;

# Query all records from users table
select * from users;

# Delete one record whose name is equal to Ken from users table
delete from users where name = "Ken";
```

## Urls

* The GET url to get all users. http://localhost:8080/users/all
```json
[{"name":"Alice","age":30},{"name":"Bob","age":25},{"name":"John Doe","age":30}]
```

* The POST url to create the user
```bash
curl -X POST http://localhost:8080/users/create \
-H "Content-Type: application/json" \
-d '{"name": "John Doe", "age": 30}'
```
