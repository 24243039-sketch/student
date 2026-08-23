pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out Student Management System from GitHub...'
            }
        }

        stage('Compile') {
            steps {
                echo 'Compiling Java source code...'

                bat '''
                    if exist out rmdir /s /q out
                    mkdir out

                    javac -d out src\\Student.java src\\Main.java
                '''
            }
        }

        stage('Test') {
            steps {
                echo 'Testing compiled Java classes...'

                bat '''
                    if not exist out\\com\\example\\student\\Student.class (
                        echo Student.class not found!
                        exit /b 1
                    )

                    if not exist out\\com\\example\\student\\Main.class (
                        echo Main.class not found!
                        exit /b 1
                    )

                    echo Java compilation test passed successfully.
                '''
            }
        }

        stage('Run') {
            steps {
                echo 'Running Student Management System...'

                bat '''
                    java -cp out com.example.student.Main
                '''
            }
        }

        stage('Archive') {
            steps {
                echo 'Archiving application...'

                archiveArtifacts artifacts: 'out/**',
                                 fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Student Management System...'

                bat '''
                    if exist deploy rmdir /s /q deploy
                    mkdir deploy

                    xcopy /E /I /Y out deploy

                    echo Student Management System deployment completed.
                '''
            }
        }
    }

    post {
        success {
            echo '======================================'
            echo '     Student Management System'
            echo '       CI/CD PIPELINE SUCCESSFUL'
            echo '======================================'
        }

        failure {
            echo '======================================'
            echo '     Student Management System'
            echo '        CI/CD PIPELINE FAILED'
            echo '======================================'
        }
    }
}