package com.domofactor

import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

/**
 * JobBuilder Class for creating a standardized job
 */
@Builder(builderStrategy = SimpleStrategy, prefix = '')
class PipelineJobBuilder {
  Boolean disabled = false
  String name = 'somejob'
  String description = 'some description'
  String github_org = 'domofactor'
  String github_repo = 'jenkins-job-dsl'
  String branch = 'master'

  Job build(DslFactory dslFactory) {
    // job config examples: https://github.com/jenkinsci/job-dsl-plugin/tree/master/job-dsl-core/src/main/docs/examples/javaposse/jobdsl/dsl/Job
    dslFactory.pipelineJob(name) {
      if (disabled) {
        disabled()
      }
      description description

      wrappers {
        timestamps()
        maskPasswords()
        colorizeOutput()
      }

      definition {
        cpsScm {
          scm {
            git {
              remote {
                  github("${github_org}/${github_repo}", 'https')
                  branches(branch)
              }
            }
          }
          scriptPath("Jenkinsfile")
        }
      }
      configure {
         it / definition / lightweight(true)
      }
    }
  }
}
