# Sample Quarkus App for Edge Demo

## Testing dev
```bash
mvn quarkus:dev
```

## Testing prod



```bash
podman run --name some-postgres -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres
mvn quarkus:dev --Dquarkus.profile=prod
```


```bash
mvn clean package -Pnative -Dquarkus.container-image.build=true -Dquarkus.native.reuse-existing=true
```

