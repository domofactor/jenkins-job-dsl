import com.domofactor.PipelineJobBuilder

job = new PipelineJobBuilder(
        name: 'myjob',
        description: 'myjob that was build using extended job-dsl',
        github_org: 'domofactor',
        github_repo: 'jenkins-job-dsl',
        branch: 'master'
)

job.build(this)
