pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the branch that raised the pull request
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build your application using Gradle
                sh './gradlew build'
            }
        }

        stage('Test') {
            steps {
                // Run your tests with Gradle
                sh './gradlew test'
            }
        }

        stage('Coverage') {
            steps {
                // Run coverage verification
                sh './gradlew jacocoTestCoverageVerification'
            }
        }

        stage('Check Coverage') {
            steps {
                script {
                    // Fail the build if coverage is not 100%
                    def coverageResult = readFile 'build/reports/jacoco/test/jacocoTestCoverageVerification/jacocoTestCoverageVerification.xml'
                    if(!coverageResult.contains('rules violated: 0')) {
                        error "Code coverage is less than 100%"
                    }
                }
            }
        }

        stage('Package') {
            when {
                // Only run this stage when merging to master branch
                branch 'master'
            }
            steps {
                // Package your application
                sh './gradlew assemble'
            }
        }
    }

    post {
        always {
            // Collect artifacts
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            // Collect test results
            junit 'build/test-results/test/*.xml'
            // Collect coverage report
            jacoco execPattern: 'build/jacoco/test.exec'
        }
    }

    triggers {
        // Trigger the build when a pull request is raised
        pullRequestRaised()
    }
}
