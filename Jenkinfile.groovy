pipeline {
    agent any

    triggers {
        cron('H/15 * * * *')
    }

  stages
    {
        stage('EIB-Sprin')
        {
             steps {
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
