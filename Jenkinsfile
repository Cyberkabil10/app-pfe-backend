pipeline {
    agent any
    stages {
        stage('Build artifact') {
        steps { sh 'mvn clean install -DskipTests' }
        }
        }
    }
}