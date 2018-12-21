job('nodejobdsl'){
	scm{
		git('https://github.com/SatyaSarath/docker-demo.git'){
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
		shell('npm install')
	}
}
