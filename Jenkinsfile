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
        stage('Build backend auth') {
            steps {
             dir('covibed-Auth'){
                script{
                //def pomPath = findFiles(glob: "**/extravars.properties")[0].path
                def props = readProperties file: findFiles(glob: "**/extravars.properties")[0].path
                env.AWS_REGISTRY_URL = props.AWS_REGISTRY_URL
                env.AWS_REGION=props.AWS_REGION
                def INSTANCE_NAME = "v1.0-${env.BUILD_NUMBER}"
                docker.withRegistry('${AWS_REGISTRY_URL}/backendauth-repo', '${AWS_REGION}:aws-credentials') {
                //def customImage = docker.build("683929775058.dkr.ecr.eu-west-3.amazonaws.com/backendauth-repo")
                //customImage.push("${INSTANCE_NAME}")
                //customImage.push("latest")
           }
            }
             }}
        }
        /*stage('Build backend') {
            steps {
             dir('covibed_backEnd'){
                script{
                def IMAGE_NAME = "v1.0.${env.BUILD_NUMBER}"
                docker.withRegistry('https://683929775058.dkr.ecr.eu-west-3.amazonaws.com/backend-repo', 'ecr:eu-west-3:aws-credentials') {
                def backendImage = docker.build("683929775058.dkr.ecr.eu-west-3.amazonaws.com/backend-repo")
                backendImage.push("${IMAGE_NAME}")
                backendImage.push("latest")
           }
            }
             }}
        }*/

    }
}

