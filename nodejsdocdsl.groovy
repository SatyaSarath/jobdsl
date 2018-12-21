job('nodejobdocdsl'){
	scm{
		git('https://github.com/SatyaSarath/docker-demo.git'){ node -> // is hudson.plugins.git.GitSCM
			node / gitConfigName('satyasarath')
			node / gitConfigEmail('satya.kotha@wipro.com')
		}
	}
	triggers{
		scm('H/5 * * * *')
	}
	wrappers{
		nodejs('nodejs')
	}
	steps{
		shell('cat /var/secret/dockerpasswd | docker login --username satyasarath --password-stdin')
		dockerBuildAndPublish {
            	repositoryName('satyasarath/nodejsjob1')
			tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=8}')
            	registryCredentials('docker-hub')
            	forcePull(false)
		forceTag(false)
            	createFingerprints(false)
            	skipDecorate()
		}
		
	}
}
