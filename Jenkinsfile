// Variables for the tool name as provided in 'Manage Jenkins > Global Tool Configuration'
def mavenVersion = 'maven 3.8.6'
def javaVersion = 'Java 19'

pipeline {
    options {
        timeout (time: 5, unit: 'MINUTES') // timeout after 5 minutes
        retry(1)  // if the build fails try one more time
    }
    agent any
    tools {

        maven mavenVersion
        jdk javaVersion
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
                bat 'mvn clean'
                bat 'mvn package -DskipTests'  //skip running the UI tests until later
            }
        }

        stage ('Deploy') {
            steps {
               emailext (
                // requires https://plugins.jenkins.io/email-ext/ plugin to be installed
                to: 'gary.bannerman@incrementalgroup.co.uk',
                subject: "foo",
                body: "bar",
                mimeType: 'text/html'
            );
                input "Confirm delpoyment to the test env"
                archiveArtifacts artifacts: 'target/*.jar'
                echo "Deployment steps here"
            }
        }

        stage ('Test') {
            steps {
                bat 'mvn surefire:test'
                bat 'mvn surefire-report:report-only'
                bat 'mvn site -DgenerateReports=false'
            }
            post {
                always {
                    echo "The tests have run"
                }
                success {
                    // Displays 'Test Results' in menu on build page
                    junit 'target/site/surefire-report.html'
                }
                failure {
                    echo "Test Failure"
                }
            }
        }

    }
}   