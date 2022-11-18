pipeline {
    agent any
    stages {
        stage('Build artifact for microservice covibed_backend') {
        steps {
            dir('covibed_backEnd'){withMaven { bat "mvn clean install -DskipTests"}}

        }

        }
         stage('test quality with sonarqube covibed_backend') {
         steps {
            dir('covibed_backEnd'){withMaven { bat "mvn sonar:sonar"}}

        }
        }

        stage('Build artifact for microservice covibed_Auth') {
        steps {
            dir('covibed-Auth'){withMaven { bat "mvn clean install -DskipTests"}}

        }

        }
         stage('test quality with sonarqube covibed_Auth') {
         steps {
            dir('covibed-Auth'){withMaven { bat "mvn sonar:sonar"}}

        }

        }
        stage('Build') {
            steps {
             dir('covibed_backEnd'){
                script{
              docker.withRegistry('https://683929775058.dkr.ecr.eu-west-3.amazonaws.com/pfe_container_registry', 'ecr:eu-west-3:aws-credentials') {

              def customImage = bat "docker build -t testimagebackend:latest"

        /* Push the container to the custom Registry */
                customImage.push()
           }
            }
             }}
        }
    }
}

