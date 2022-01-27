pipeline {
    agent any

    stages {
        stage('Compile and test') {
            steps {
                withMaven {
                    sh "mvn clean test"
                }
            }
        }
    }
}
