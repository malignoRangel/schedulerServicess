#!/usr/bin/env groovy

/* Only keep the 2 most recent builds. */
def projectProperties = [
    buildDiscarder(logRotator(numToKeepStr: '2')),
]

if (!env.CHANGE_ID) {
  projectProperties.add(pipelineTriggers([pollSCM('H/5 * * * *')]))
  projectProperties.add(disableConcurrentBuilds())
}
properties(projectProperties)


try {

  timeout(time: 20, unit: 'MINUTES') {
    
    node ('master') {
        
        
    //   Parameters
    //   def PROJECT_NAME   = ''
    //   def SONAR_PROJECT  = 'DDTGA-RFG-rsGestionContrato'
    //   def TEMPLATE_NAME  = ''
    //   def POM_ARTIFACTID = ''
    //   def POM_VERSION    = ''
    //   def TAG            = ''
    //   def URL            = ''
    //   def PORT           = 9093

      final VERSION_FILE   = 'VERSION'

      stage ('\u278A Checkout') {
        checkout scm
      }
      
    //   stage ('\u278B Prepare') {
    //     def pom = readMavenPom file: 'pom.xml'

    //     POM_ARTIFACTID = pom.artifactId
    //     POM_VERSION = pom.version

    //     TEMPLATE_NAME = POM_ARTIFACTID.toLowerCase()

    //     if (! fileExists(VERSION_FILE)) {
    //       error("Application version tracking file ${VERSION_FILE} does not exists!")
    //       return
    //     }

    //     TAG = readFile(VERSION_FILE).trim()

    //     switch(env.GIT_BRANCH) {
    //       case 'dev':
    //         PROJECT_NAME = 'bdb-de-rfg'
    //         TAG = "${TAG}_beta${env.BUILD_NUMBER}"
    //         URL = 'rsgestioncontratode.s-cloudapps.bancodebogota.net'
    //         break
    //       case ~/(release|hotfix)\/.+$/:
    //         PROJECT_NAME = 'bdb-qa-rfg'
    //         TAG = "${TAG}_rc${env.BUILD_NUMBER}"
    //         URL = 'rsgestioncontratoqa.s-cloudapps.bancodebogota.net'
    //         break
    //       case 'master':
    //         PROJECT_NAME = 'bdb-pr-rfg'
    //         TAG = "${TAG}"
    //         URL = 'rsgestioncontrato.ac.bancodebogota.com.co'
    //         break
    //       default:
    //         error("The branch ${GIT_BRANCH} does not exists!")
    //         break
    //     }
    //   }

      stage ('\u278C Build App') {
        sh '''                    
            mvn clean install -Dspring.profiles.active=qa -Dspring.backgroundpreinitializer.ignore=true
        '''
		// sh "mvn clean package -Dspring.profiles.active=de"
      }



    //   stage ('\u278D Cleanup') {
    //     openshift.withCluster() {
    //       openshift.withProject(PROJECT_NAME) {
    //         if (env.GIT_BRANCH != 'master' || env.GIT_BRANCH != ~/(release|hotfix)\/.+$/) {
    //           openshift.selector('all', [ app : TEMPLATE_NAME ]).delete() 
    //           if (openshift.selector('bc', TEMPLATE_NAME).exists()) { 
    //             openshift.selector('bc', TEMPLATE_NAME).delete()
    //           }
    //         }
    //         if (openshift.selector('configmap', TEMPLATE_NAME).exists()) { 
    //           openshift.selector('configmap', TEMPLATE_NAME).delete()
    //         }
    //       }
    //     }
    //   }

    //   stage ('\u278E Unit Tests') {
    //     if (env.GIT_BRANCH != 'master') {
    //       sh "mvn org.jacoco:jacoco-maven-plugin:prepare-agent test \
    //           -Dmaven.test.failure.ignore=true -Dspring.profiles.active=de"
    //       junit testResults: '**/target/surefire-reports/*.xml', 
    //         allowEmptyResults: true
    //     } else {
    //       echo 'Pass'
    //     }
    //   }

    //   stage ('\u278F Code Analysis') {
    //     if (env.GIT_BRANCH != 'master') {
    //       sh "mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000 \
	//  	                  	-Dsonar.dynamicAnalysis=reuseReports \
    //                     -Dsonar.java.coveragePlugin=jacoco   \
    //                     -Dsonar.projectKey=${SONAR_PROJECT}  \
    //                     -Dsonar.projectName=${SONAR_PROJECT}"
    //     } else {
    //       echo 'Pass'
    //     }
    //   }

    //   stage ('\u2790 Build Image') {
    //     openshift.withCluster() {
    //       openshift.withProject(PROJECT_NAME) {
    //         if (!openshift.selector('bc', TEMPLATE_NAME).exists()) {
    //           openshift.newBuild("--name=${TEMPLATE_NAME}", 
    //             "--strategy=docker",
    //             "--docker-image=openjdk:8-jre-alpine",
    //             "--binary=true")
    //         }
    //         def build = openshift.selector('bc', TEMPLATE_NAME).startBuild(
    //           "--from-file=.", "--wait=true")
            
    //         timeout(5) {
    //           build.untilEach {
    //             return it.object().status.phase == 'Complete'
    //           }
    //         }
    //       }
    //     }
    //   }

    //   stage ('\u2791 Create Tag') {
    //     openshift.withCluster() {
    //       openshift.withProject(PROJECT_NAME) {
    //         openshift.tag("${TEMPLATE_NAME}:latest", "${TEMPLATE_NAME}:${TAG}")
    //       }
    //     }
    //   }

    //   stage ('\u2792 Deploy') {
    //     openshift.withCluster() {
    //       openshift.withProject(PROJECT_NAME) {
    //         if (openshift.selector('dc', TEMPLATE_NAME).exists()) {
    //           sh "oc process -f openshift-template.yaml  \
    //             --param TEMPLATE_NAME=${TEMPLATE_NAME}   \
    //             --param PROJECT_NAME=${PROJECT_NAME}     \
    //             --param CONFIGMAP_NAME=${TEMPLATE_NAME}  \
    //             --param TAG=${TAG}                       \
    //             --param URL=${URL} | oc apply -f-"
    //         } else {
    //           openshift.newApp("openshift-template.yaml", 
    //             "--param TEMPLATE_NAME=${TEMPLATE_NAME}",
    //             "--param PROJECT_NAME=${PROJECT_NAME}",
    //             "--param CONFIGMAP_NAME=${TEMPLATE_NAME}",
    //             "--param TAG=${TAG}",
    //             "--param URL=${URL}")
    //         }

    //         timeout(5) {
    //           openshift.selector('dc', "${TEMPLATE_NAME}").related('pods').untilEach(1) {
    //             return (it.object().status.phase == "Running")
    //           }
    //         }
    //       }
    //     }
    //   }

    } // end node
  } // end timeout

} catch (err) {
  currentBuild.result = 'FAILURE'
  throw err
} finally {

} // end try
