def call(String environment, String appVersion) {
    echo "Deploying to ${environment} environment..."
    
    // We export the APP_VERSION so the docker-compose.yml file can read it
    // We use '--pull always' to ensure it grabs the newly pushed image from Docker Hub
    // We use '-d' to run it in the background
    sh """
        export APP_VERSION=${appVersion}
        docker compose -f docker-compose.yml pull
        docker compose -f docker-compose.yml up -d
    """
    
    echo "Deployment to ${environment} successful!"
}
