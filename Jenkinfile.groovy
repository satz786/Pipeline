node {
    
   
        stage('EIB-Sprin')
        {
            
                echo "EIB completed";
                
            
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
