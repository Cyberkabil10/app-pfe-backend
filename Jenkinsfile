pipeline {
    agent any
    stages {
        stage('Build artifact') {
        steps {

            dir "covibed_backend"
            bat "mvn clean install -DskipTestst"}

        }
        }
    }
