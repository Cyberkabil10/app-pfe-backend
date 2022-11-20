pipeline {
    agent any
     def cmd_exec(command) {
        return bat(returnStdout: true, script: "${command}").trim()
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

        stage('Build') {
            steps {
             dir('covibed_backEnd'){

                script{
                def IMAGE_TAG= cmd_exec("git log -n 1 --pretty=format:'%h'")
                bat "echo ${IMAGE_TAG}"
                bat "docker build -t pfe_container_registry:v${IMAGE_TAG} ."
             /* docker.withRegistry('https://683929775058.dkr.ecr.eu-west-3.amazonaws.com/pfe_container_registry', 'ecr:eu-west-3:aws-credentials') {


              def customImage = docker.build("pfe_container_registry:${BUILD_NUMBER} ")


                customImage.push('latest')
           }*/
            }
             }}
        }
    }
}






