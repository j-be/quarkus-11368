# Quarkus-11368
Minimal project to reproduce https://github.com/quarkusio/quarkus/issues/11368.

## Run in `test` profile

`mvn clean install`

**Note:** There is a unit test asserting that the `Something.name` is set in the `DEL` revision.

## Run in `dev` profile:

```
mvn quarkus:dev
scripts/test_with_curl.sh
```

yields:

```
Create
{"id":1,"name":"fromCurl"}
Delete
Fetch deleted
{"id":1,"name":"fromCurl"}
```

## Run in `prod` profile:

```
cd target/
java -jar quarkus-11368-1.0.0-SNAPSHOT-runner.jar
scripts/test_with_curl.sh
```

yields:

```
Create
{"id":1,"name":"fromCurl"}
Delete
Fetch deleted
{"id":1,"name":null}
```

Notice the `null` here in `Fetch deleted`.

## Notes

For simplicity sake `test_with_curl.sh` will always delete and fetch `Something` with `id = 1`. Keep that in
mind in case you want to run this stuff against something persistent, like a Postgres.

## Alternative Steps

Instead of `test_with_curl.sh` you may also run the tests using
`org.duckdns.owly.quarkus_11368.test.SomethingResourceTestFunction` from within your IDE if supported.
