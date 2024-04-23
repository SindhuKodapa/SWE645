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
        // stage('Build Docker Image and Push'){
        //     steps{
        //         script {
        //             sh 'docker login -u tarungujjar -p ${DOCKERHUB_PASS}'
        //             // docker.withRegistry('',registryCredential) {
        //             def image = docker.build('tarungujjar/swe645-microservices:'+ dateTag, '.')
        //                 // docker.withRegistry('',registryCredential) {
        //             image.push()
                        
                    
        //         }
        //     }
        // }
        stage('Docker Build') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        def customImage = docker.build('tarungujjar/survey:' + dateTag)
                    }
                }
            }
        }
        // Push to DockerHub Stage
        stage('Push to Docker Hub') {
            steps {
                script {
                    // sh 'echo ${BUILD_TIMESTAMP}'
                    docker.withRegistry('', registryCredential) {
                        def image = docker.build('tarungujjar/survey:' + dateTag, '.')
                        docker.withRegistry('', registryCredential) {
                            image.push()
                        }
                    }
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
