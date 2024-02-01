pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('build jar') {
            steps {
                script {
                    echo 'building the application ...'
                    sh 'mvn package'
                }
            }
        }

        stage('build image') {
            steps {
                script {
                    echo 'building the docker image ...'
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo',
                    usernameVariable: 'USER', passwordVariable: 'PWD')]) {
                        sh "docker build -t abuhanaan/demo-app:jma-2.0 ."
                        sh "echo \$PWD | docker login -u \$USER --password-stdin"
                        sh 'docker push abuhanaan/demo-app:jma-2.0'
                    }
                }
            }
        }


        stage('test') {
            steps {
                script {
                    echo 'Testing the application...'
                }
            }
        }

        stage('deploy') {
            steps {
                script {
                    echo 'Deploying the application...'
                }
            }
        }
    }
}
