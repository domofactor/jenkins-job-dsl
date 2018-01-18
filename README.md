# Jenkins Job DSL Example
this repo shows how to leverage Jenkins seed jobs and extend the job-dsl plugin

## Requirements

* Docker

## Getting Started

* `docker build -t jenkins .`
* `docker run -i jenkins`

## Usage

1. access jenkins at ![http://localhost:8080](http://localhost:8080).
1. in jenkins, run seed job `myseedjob`.
1. in jenkins, run job `myjob` that was generated from the seed job.

## Testing

`./gradlew --info`
