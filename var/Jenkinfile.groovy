pipeline {
    agent any

 


      parameters {
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to build')
        booleanParam(name: 'DEPLOY', defaultValue: true, description: 'Deploy after build')
        choice(name: 'ENVIRONMENT', choices: ['dev', 'staging', 'prod'], description: 'Select environment')
    }


    
  stages
    {
        stage('EIB-Sprin')
        {
             steps {
                  echo "Building branch: ${params.BRANCH_NAME}"
                echo "EIB completed";
                  echo "Selected environment: ${params.ENVIRONMENT}"
             } 
            
        }

    stage('Checkout')
    {
         steps {
        checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/satz786/OwnProject.git']])
         }
    }
 
        stage('Build_OwnProject')
        {
         steps {
        build 'OwnProject'
          echo "Own project";
         }
        }
        stage('Clear-EIB')
        {
         steps {
            echo "EIB cleared";
         }
        }
    }
}
