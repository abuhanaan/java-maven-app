def buildJar() {
    echo 'building the application ...'
    sh 'mvn package'
}

def buildImage() {
    echo 'building the docker image ...'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo',
    usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t abuhanaan/demo-app:jma-2.0 ."
        echo "Using username: $USER"
        echo "Using password: $PASS"
        sh "echo \$PASS | docker login -u \$USER --password-stdin"
        sh 'docker push abuhanaan/demo-app:jma-2.0'
    }
}

def testApp() {
    echo "testing the application..."
}

def deployApp() {
    echo 'Deploying the application...'
}

return this