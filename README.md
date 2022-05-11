# chopin-hmdb-parser

```bash
sbt test
```

```bash
sbt clean coverage test coverageReport
<chromium/firefox> ./target/scala-2.13/scoverage-report/index.html
```

```bash
sbt run
```

or
```bash
sbt assembly
java -jar ./assembly/chopin-hmdb-generator-assembly-<version>.jar <args>
```
