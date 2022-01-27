pipeline {
    agent any

    stages {
        stage('Compile and test') {
            steps {
                withMaven {
                    sh 'for stuff in {1..10} ; do date +%Hh%mm%Ss; echo "## ${stuff} - Sleeping 1 more minute"; sleep 60 ; done'
                }
            }
        }
    }
}
