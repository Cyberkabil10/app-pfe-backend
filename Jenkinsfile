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
              withDockerRegistry(credentialsId: 'ecr:eu-west-3:aws-credentials', toolName: 'docker ', url: 'https://683929775058.dkr.ecr.eu-west-3.amazonaws.com/pfe_container_registry') {

              def customImage = bat "docker.build("my-image:latest")"

        /* Push the container to the custom Registry */
                customImage.push()
           }
            }
             }}
        }
    }
}

