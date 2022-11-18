pipeline {
    agent any
    stages {
        stage('Build artifact') {
        steps {

            dir('covibed_backEnd'){

                    withMaven {
      bat "mvn clean install -DskipTests"
    }
            }

            }

        }
        }
    }
