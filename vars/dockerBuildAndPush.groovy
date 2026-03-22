def call(String imageName, String tag, String credentialsId) {
    echo "Building and Pushing Docker Image: ${imageName}:${tag}"
    
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh "echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin"
        sh "docker build -t ${imageName}:${tag} -f CollegeControlSystem.Presentation/Dockerfile ."
        sh "docker push ${imageName}:${tag}"
        sh "docker logout"
    }
}
