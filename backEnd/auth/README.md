# servermate: auth service:

## prerequisits:

- [docker](https://docker.com): used to containerize and run the services.
- [jdk-17](https://adoptium.net/): required to build the spring boot app.

## Starting:

build spring boot app:
```bash
$ grade bootJar
```

next use docker compose to start services and build the app image:
```bash
$ docker compose up -d
```

## usage:

- `POST /auth/login`: check if user is found in db by providing `email` and `password` in request payload.
- `POST /auth/register`: add new user to db by providing `email` and `password` in request payload. 

