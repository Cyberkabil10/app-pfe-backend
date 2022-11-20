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
                    def props = readProperties file: 'gitversion.properties'

                     env.GitVersion_SemVer = props.GitVersion_SemVer
                     env.GitVersion_BranchName = props.GitVersion_BranchName
                     env.GitVersion_AssemblySemVer = props.GitVersion_AssemblySemVer
                     env.GitVersion_MajorMinorPatch = props.GitVersion_MajorMinorPatch
                     env.GitVersion_Sha = props.GitVersion_Sha

                bat "docker build -t pfe_container_registry: ${env.GitVersion_SemVer} ."
             /* docker.withRegistry('https://683929775058.dkr.ecr.eu-west-3.amazonaws.com/pfe_container_registry', 'ecr:eu-west-3:aws-credentials') {


              def customImage = docker.build("pfe_container_registry:${BUILD_NUMBER} ")


                customImage.push('latest')
           }*/
            }
             }}
        }
    }
}
script {

}

