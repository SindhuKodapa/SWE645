pipeline{
    
    environment{
        registry = "tarungujjar/swe645-microservices"
        registryCredential = 'Docker'
        def dateTag = new Date().format("yyyyMMdd-HHmmss")
	}
agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage('Maven clean & Install'){
            steps{
                script{
                    sh 'mvn clean'
                    sh 'mvn install'
                }
            }
        }
        stage('Build Docker Image and Push'){
            steps{
                script {
                    sh 'sudo docker login -u tarungujjar -p swe645_Tarun'
                        //docker.withRegistry('',registryCredential) {
                    sh 'docker build -t tarungujjar/survey .'
                    sh 'docker push tarungujjar/survey'
                }
            }
        }
        
        stage('Deploying to single node in Rancher'){
            steps{
                script {
                    sh 'kubectl set image deployment/swe645-hw3-deployment container-0=tarungujjar/swe645-microservices:'+dateTag
                }
            }
        }
    }
    post{
        always {
			sh 'docker logout'
		}
	}    
}