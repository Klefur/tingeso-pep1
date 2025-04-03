pipeline {
    agent any
    tools {
        gradle "gradle"
    }
    stages {
        stage('Build JAR File') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Klefur/tingeso-pep1']])
                dir("main"){
                    sh "gradle clean build"
                }
            }
        }
        stage("Test") {
            steps {
                dir("main"){
                    sh "gradle test"
                }
            }
        }        
        stage("Build and Push Docker Image") {
            steps {
                dir("main"){
                    script {
                        withDockerRegistry(credentialsId: 'docker-credentials') {
                            sh "docker build -t klefurusach/tingeso-pep1 ."
                            sh "docker push klefurusach/tingeso-pep1"
                        }
                    }
                }
            }
        }
    }
}    