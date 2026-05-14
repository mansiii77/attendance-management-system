pipeline {
    agent any

    environment {
        IMAGE_NAME = "attendance-app"
        BUILD_TAG = "${BUILD_NUMBER}"
    }

    stages {

        stage('Clone') {
            steps {
                echo 'Cloning repository...'
            }
        }

        stage('Build Maven') {
            steps {
                bat '.\\mvnw.cmd clean package'
            }
        }

        stage('Run Tests') {
            steps {
                bat '.\\mvnw.cmd test'
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t %IMAGE_NAME%:%BUILD_TAG% ."
            }
        }

        stage('Docker Images') {
            steps {
                bat 'docker images'
            }
        }
    }

    post {

        success {
            echo 'Build Successful!'
        }

        failure {
            echo 'Build Failed!'
        }

        always {
            echo 'Pipeline Finished'
        }
    }
}