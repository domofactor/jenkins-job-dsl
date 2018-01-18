import jenkins.model.*
import hudson.model.*
import hudson.plugins.git.*
import javaposse.jobdsl.plugin.*

def seedJob = Jenkins.instance.createProject(FreeStyleProject.class, "myseedjob")
def userRemoteConfig = new UserRemoteConfig('https://github.com/domofactor/jenkins-job-dsl', null, null, null)
def scm = new GitSCM(Collections.singletonList(userRemoteConfig),Collections.singletonList(new BranchSpec("master")),false,Collections.<SubmoduleConfig>emptyList(),null,null,null)
def scriptLocation = new ExecuteDslScripts()

seedJob.scm = scm

//we need to turn off script security temporarily into order to use a custom classpath
GlobalConfiguration.all().get(GlobalJobDslSecurityConfiguration.class).useScriptSecurity=false

scriptLocation.setSandbox(true)
scriptLocation.setTargets('jobs/*.groovy')
scriptLocation.setRemovedJobAction(RemovedJobAction.DISABLE)
scriptLocation.setRemovedViewAction(RemovedViewAction.DELETE)
scriptLocation.setLookupStrategy(LookupStrategy.JENKINS_ROOT)
scriptLocation.setAdditionalClasspath('src/main/groovy')

seedJob.buildersList.add(scriptLocation)
seedJob.save()
