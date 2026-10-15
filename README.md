# task-manager
Jira-esque project using Angular and Spring Boot. 

## Backend API

The backend defaults to the PostgreSQL settings from `docker-compose.yml`; override them with
`SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, and `SPRING_DATASOURCE_PASSWORD`.

## Start DB

```shell
docker compose up -d
```

## Dependencies

### Spring Boot (Backend)
- Spring Web: REST API endpoints.

- Spring Data JPA: database persistence.

- PostgreSQL Drive: connect to PostgreSQL.

- Validation: validate incoming requests.

- Spring Boot DevTools