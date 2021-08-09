pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "mvn clean compile"
            }
        }
       
		stage('Junit5 Test') { 
            steps {

                sh "mvn test"
            }
        }
        
        stage('Build') { 
            steps {
                sh "mvn package"
            }
        }


        stage('Build Docker image'){
            steps {
              
                sh 'docker build -t  kumarmapanip/docker_customer_master:${BUILD_NUMBER} .'
            }
        }
        

        stage('Docker Login'){
            
            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u kumarmapanip -p ${Dockerpwd}"
                }
            }                
        }

        stage('Docker Push'){
            steps {
                sh 'docker push kumarmapanip/docker_customer_master:${BUILD_NUMBER}'
            }
        }
        
        stage('Docker deploy'){
            steps {
               
                sh 'docker run -itd -p  8081:9003 kumarmapanip/docker_customer_master:${BUILD_NUMBER}'
            }
        }


		stage('Jacoco Coverage Report') {
        	steps{
            		jacoco()
			}
		}
        
        stage('Archiving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}

