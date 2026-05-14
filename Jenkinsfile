pipeline {
    agent any

    stages {

        stage('Build Maven') {
            steps {
                bat '.\\mvnw.cmd clean package'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t attendance-app .'
            }
        }

    }
}