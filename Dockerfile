FROM jenkins/jenkins:lts-alpine
ENV PASSWORD='admin'
ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false
ENV JENKINS_OPTS=--argumentsRealm.passwd.admin=${PASSWORD} --argumentsRealm.roles.user=admin --argumentsRealm.roles.admin=admin
COPY myseedjob.groovy /usr/share/jenkins/ref/init.groovy.d/
RUN /usr/local/bin/install-plugins.sh job-dsl blueocean workflow-aggregator
