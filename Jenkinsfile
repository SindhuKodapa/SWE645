//  GroupName: TeamPRSTV (Preethi Ranganathan, Sindhuja Kodaparthi, Mary Rithika Reddy Gade, Tarun Vinay Gujjar, Vikas Halgar Seetharam)
//  Jenkinsfile defines the pipeline in scm and here, there are 4 stages in
//  this CICD pipeline: Build, Docker build, Push to Docker Hub, Kubectl Get All Nodes, Deploying Rancher to single node

pipeline{
    
    environment{
        registry = "tarungujjar/swe645-image"
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
        stage('Docker Build') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        def customImage = docker.build('tarungujjar/swe645-image:' + dateTag)
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
                        def image = docker.build('tarungujjar/swe645-image:' + dateTag, '.')
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
                    sh 'kubectl set image deployment/swe645-hw3-deployment container-0=tarungujjar/swe645-image:'+dateTag
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