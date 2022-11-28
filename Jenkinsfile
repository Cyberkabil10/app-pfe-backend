pipeline {
    agent any
    environment{
        repo_name = '683929775058.dkr.ecr.eu-west-3.amazonaws.com'
    }
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
       /* stage('Build backend auth') {
            steps {
             dir('covibed-Auth'){
                script{
                def INSTANCE_NAME = "v1.0-${env.BUILD_NUMBER}"
                docker.withRegistry("'${env.AWS_REGISTRY_URL}'/backendauth-repo", "ecr:eu-west-3:aws-credentials") {
                def customImage = docker.build("${repo_name}/backendauth-repo")
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
                docker.withRegistry('${env.AWS_REGISTRY_URL}/backend-repo', 'ecr:eu-west-3:aws-credentials') {
                def backendImage = docker.build("${repo_name}/backend-repo")
                backendImage.push("${IMAGE_NAME}")
                backendImage.push("latest")
           }
            }
             }}
        }*/
        stage('email notification'){
          steps {
          emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
          recipientProviders: [[$class: 'RecipientsRecipientProvider']],
          subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
               }
        }

    }
}

