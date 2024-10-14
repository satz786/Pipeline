pipeline {
    agent any

 


      parameters {
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to build')
        boolean(name: 'DEPLOY', defaultValue: false, description: 'Deploy after build')
        choice(name: 'ENVIRONMENT', choices: ['dev', 'staging', 'prod'], description: 'Select environment')
    }


    
  stages
    {
        stage('EIB-Sprin')
        {
             steps {
                  echo "Building branch: ${params.BRANCH_NAME}"
                echo "EIB completed";
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
