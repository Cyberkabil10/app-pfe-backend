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
        /*stage('Build backend auth') {
            steps {
             dir('covibed-Auth'){
                script{
                def INSTANCE_NAME = "v1.0-${env.BUILD_NUMBER}"
                docker.withRegistry("${env.AWS_REGISTRY_URL}/backendauth-repo", "ecr:eu-west-3:aws-credentials") {
                def customImage = docker.build("${env.AWS_REPO_NAME}/backendauth-repo")
                customImage.push("${INSTANCE_NAME}")
                customImage.push("latest")
           }
            }
             }}
        }
        stage('Build backend') {
            steps {
             dir('covibed_backEnd'){
                script{
                def IMAGE_NAME = "v1.0.${env.BUILD_NUMBER}"
                docker.withRegistry("${env.AWS_REGISTRY_URL}/backend-repo", "ecr:eu-west-3:aws-credentials") {
                def backendImage = docker.build("${env.AWS_REPO_NAME}/backend-repo")
                backendImage.push("${IMAGE_NAME}")
                backendImage.push("latest")
           }
            }
             }}
        }*/
        stage('Build dataBase Image') {
            steps {
             dir('DB'){
                script{
                def DBIMAGE_NAME = "v1.0.${env.BUILD_NUMBER}"
                docker.withRegistry("${env.AWS_REGISTRY_URL}/database-repo", "ecr:eu-west-3:aws-credentials") {
                def dbImage = docker.build("${env.AWS_REPO_NAME}/database-repo")
                dbImage.push("${DBIMAGE_NAME}")
                dbImage.push("latest")
           }
            }
             }}
        }

        stage('email notification'){
          steps {
          emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
          recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
          subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
               }
        }

    }
}

