node {
    
   
        stage('EIB-Sprin')
        {
            
                echo "EIB completed";
                
            
        }
        stage('TestLeaf_Git')
        {
        
        build 'TestLeaf_Git'
          echo "Own project";
            
        }
        stage('Clear-EIB')
        {
        
            echo "EIB cleared";
            
        }
    
}
