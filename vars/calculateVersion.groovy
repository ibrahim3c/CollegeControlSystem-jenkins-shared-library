// Reads a 'VERSION' file in your repo and appends branch info/build numbers
def call() {
    def baseVersion = readFile('VERSION').trim()
    def appVersion = ""

    if (env.BRANCH_NAME == 'master') {
        appVersion = "${baseVersion}.${env.BUILD_NUMBER}"
    } else if (env.BRANCH_NAME == 'develop') {
        appVersion = "${baseVersion}-dev.${env.BUILD_NUMBER}"
    } else {
        appVersion = "${baseVersion}-${env.BRANCH_NAME}.${env.BUILD_NUMBER}"
    }
    
    echo "Calculated Version: ${appVersion}"
    return appVersion
}