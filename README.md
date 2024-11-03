# Ahoi Burger

**Repository:** [GitHub](https://github.com/AistleitnerFabian/ahoi-burger)

**Projektbeschreibung:** Eine Mini-API als Coding Challenge für **Ahoi Kappn**.

## Noch fehlende Features

Die folgenden Features sind in der aktuellen Version noch nicht implementiert, werden jedoch in der Live-Demo verfügbar sein:

- **Suchfunktion:** Möglichkeit, Burger und Getränke nach Namen zu durchsuchen
- **Filteroptionen:** Abfrage von Burgern und Getränken nach Preisbereich
- **Containerisierung:** Bereitstellung einer Dockerfile zur einfachen Containerisierung und Deployment der Anwendung

## Swagger UI

Die API-Dokumentation ist unter folgendem Link verfügbar:
- [Swagger UI](http://localhost:8080/swagger-ui)

## Authentifizierung

Nutze den folgenden Header für die Authentifizierung:
- **HTTP Header:** `X-Api-Key`
- **API Key:** `ahoi-burger-secret`

## Environment Variables

| Environment Variable | Description                                       | Default Value                                    |
|----------------------|---------------------------------------------------|--------------------------------------------------|
| `DB_URL`             | Die URL der PostgreSQL-Datenbank                  | `jdbc:postgresql://localhost:5434/burger`        |
| `DB_USERNAME`        | Der Benutzername für die Datenbank                | `postgres`                                       |
| `DB_PASSWORD`        | Das Passwort für die Datenbank                    | `postgres`                                       |
| `API_KEY`            | API-Schlüssel für die Authentifizierung der API   | `ahoi-burger-secret`                             |


## Live Demo

Die Live-Demo ist hier erreichbar:
- [Live Demo](https://ahoi-burger.fabian-aistleitner.at/swagger-ui)

