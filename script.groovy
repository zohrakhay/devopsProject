def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    bat 'mvn clean install -D maven.test.skip=true'
    nexusArtifactUploader artifacts: [[artifactId: 'demo', classifier: '', file: 'target/demo-0.0.1-SNAPSHOT.jar', type: 'jar']], credentialsId: 'nexus-credentials', groupId: 'com.example', nexusUrl: 'localhost:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-snapshots', version: '0.0.1-SNAPSHOT'
}

def sonarScan() {
    echo "Run sonarQube scan..."
    bat "mvn clean verify sonar:sonar -D sonar.projectKey=devops -D maven.test.skip=true  -D sonar.login=squ_9854aec5640594c23dd308012cde3301142f63fc"
    }

return this