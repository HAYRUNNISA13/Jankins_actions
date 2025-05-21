pipeline {
    agent any
    environment {
    KUBECONFIG = "/var/lib/jenkins/.kube/config"
    }

    triggers {

        githubPush()
    }
    stages {
        stage('Clone') {
            steps {
                git branch: 'main', credentialsId: 'github-creds', url: 'https://github.com/HAYRUNNISA13/Jankins_actions.git'
            }
        }
        stage('Build JAR') {
            steps {
                sh './gradlew clean build -x test'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t hayruncelik692/springboot-app:latest .'
            }
        }
        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
                }
            }
        }
        stage('Docker Push') {
            steps {
                sh 'docker push hayruncelik692/springboot-app:latest'
            }
        }
        stage('K8s Deployment') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
            }
        }
        stage('K8s Service') {
            steps {
                sh 'kubectl apply -f service.yaml'
            }
        }
    }
}
