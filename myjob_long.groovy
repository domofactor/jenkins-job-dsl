pipelineJob('myjob') {
  if (disabled) {
    disabled()
  }
  description 'some description'

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
              github('domofactor/jenkins-job-dsl', 'https')
              branches('master')
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
