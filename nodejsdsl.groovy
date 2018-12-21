job('nodejobdsl'){
	scm{
		git('git@github.com:SatyaSarath/jobdsl.git')
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
