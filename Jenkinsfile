pipeline {
    agent any
    stages {
        stage('Build artifact') {
        steps {

            dir('covibed_backEnd'){
                bat "mvn clean install -DskipTests"
            }

            }

        }
        }
    }
