def testApp() {
    echo 'testing the application'
}

def buidApp() {
    echo 'building the application'
    echo "building version ${VERSION}"
}

def deployApp() {
    echo 'deploying the application'
    echo "deploying version ${params.VERSION}"
}

return this