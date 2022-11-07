pipeline {
    agent any
    tools { 
       // Tool name as provided in 'Manage Jenkins > Global Tool Configuration'
        maven 'maven 3.8.6' 
        jdk 'Java 19' 
    }

    stages {
        stage('Clone main branch') {
            steps {
                git branch: 'main', url: 'https://github.com/gbannermanIncremental/JenkinsMaven.git'
            }
        }
        
        stage ('Initialize') {
            steps {
                bat '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

	stage ('Build') {
            steps {
                bat 'mvn clean build' 
            }
        }

	
	stage ('Deploy') {
            steps {
                echo "Deployment" 
            }
        }


        stage ('Test') {
            steps {
                bat 'mvn clean test' 
            }
            post {
                success {
                    // Displays 'Test Results' in menu on build page
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }

        