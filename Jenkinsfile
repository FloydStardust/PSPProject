 node {
    stage('SCM') {
        git 'https://github.com/FloydStardust/PSPProject.git'
    }
    stage('QA') {
        sh 'sonar-scanner'
    }
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
        sh "docker stop psp || true"
        sh "docker rm psp || true"
        sh "docker run --name psp --net=host -d tomcat:8.5"
        sh "docker cp target/qa-monitor.war psp:/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
