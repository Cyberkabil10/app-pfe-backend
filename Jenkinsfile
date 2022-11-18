pipeline {
    agent any
    stages {
        stage('Build artifact') {
        steps {
            dir('covibed_backEnd'){
                    withMaven { bat "mvn clean install -DskipTests"}
            }

        }

        }
         stage('test quality with sonarqube') {
         steps {
            dir('covibed_backEnd'){
                    withMaven { bat "mvn sonar:sonar"}
            }

        }

        }
    }
}
