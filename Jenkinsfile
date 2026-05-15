pipeline {
    agent any

    triggers {
        githubPush()
    }

    stages {

        stage('Build Maven') {
            steps {
                bat '.\\mvnw.cmd clean package'
            }
        }

        stage('Test') {
            steps {
                bat '.\\mvnw.cmd test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t attendance-app:latest .'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker rm -f attendance-container || exit 0'
                bat 'docker run -d -p 8085:8081 --name attendance-container attendance-app:latest'
            }
        }
    }

    post {
        success {
            echo "SUCCESS 🚀 Build Completed"
        }

        failure {
            echo "FAILED ❌ Check logs"
        }
    }
}