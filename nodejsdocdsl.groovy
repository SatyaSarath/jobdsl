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
            	tag('${BUILD_NUMBER}')
            	registryCredentials('docker-hub')
            	forcePull(false)
		force(false)
            	createFingerprints(false)
            	skipDecorate()
		}
		
	}
}
