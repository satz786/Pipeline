node {
    
   
        stage('EIB-Sprin')
        {
            
                echo "EIB completed";
                
            
        }

    stage('Checkout')
    {
        checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/satz786/TestLeafV1.git']])
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
