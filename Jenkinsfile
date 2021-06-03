pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Testing') {
            steps {
                sh "mvn test -Dmaven.test.failure.ignore=true"
            }
        }
        stage('Allure-report') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
        }

    }

}