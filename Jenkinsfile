pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/mansiii77/attendance-management-system.git'
            }
        }

        stage('Run Tests') {
            steps {
                bat '.\\mvnw.cmd test'
            }
        }

        stage('Build Application') {
            steps {
                bat '.\\mvnw.cmd clean package'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t attendance-app:%BUILD_NUMBER% .'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker rm -f attendance-container || exit 0'
                bat 'docker run -d -p 8085:8081 --name attendance-container attendance-app:%BUILD_NUMBER%'
            }
        }
    }

    post {

        success {
            echo 'SUCCESS 🚀 Build Completed'
        }

        failure {
            echo 'FAILED ❌ Check logs'
        }
    }
}