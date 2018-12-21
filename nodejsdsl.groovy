job('nodejobdsl'){
	scm{
		git('https://github.com/SatyaSarath/docker-demo.git')
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
