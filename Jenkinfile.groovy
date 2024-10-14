pipeline {


 agent any
    triggers {
        cron('H/15 * * * *')
    }

    
  
        stage('EIB-Sprin')
        {
            
                echo "EIB completed";
                
            
        }

    stage('Checkout')
    {
        checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/satz786/OwnProject.git']])
    }
        stage('Build_OwnProject')
        {
        
        build 'TestLeaf_Git'
          echo "Own project";
            
        }
        stage('Clear-EIB')
        {
        
            echo "EIB cleared";
            
        }
    
}
