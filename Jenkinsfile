pipeline{
    
    environment{
        registry = "tarungujjar/swe645-microservices"
        registryCredential = 'Docker'
        DOCKERHUB_PASS = 'swe645_Tarun'
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
                    sh 'docker login -u tarungujjar -p ${DOCKERHUB_PASS}'
                    // docker.withRegistry('',registryCredential) {
                    def image = docker.build('tarungujjar/swe645-microservices:'+ dateTag, '.')
                        // docker.withRegistry('',registryCredential) {
                    image.push()
                        
                    
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
