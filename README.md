# chopin-hmdb-parser
[![chopin-hmdb-parser-circleci](https://circleci.com/gh/fgiacomoni/chopin-hmdb-parser.svg?style=shield)](https://app.circleci.com/pipelines/github/fgiacomoni)

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
