package com.domofactor

import javaposse.jobdsl.dsl.*
import spock.lang.Specification

class PipelineJobBuilderTest extends Specification {

  JobParent jobParent = new MockJobParent()
  PipelineJob pipelinejob

  def setup() {
      pipelinejob = new PipelineJob(
                      name: 'test-job',
                      description: 'testing'
      )
  }

  void 'test output'() {
      when:
      Job job = pipelinejob.build(jobParent)

      then:
      job.name == 'test-job'
  }
}
