package com.suhov.aaspc2023.data.usecases

class GitHubUseCasesImpl(
	override val getRepos: GetRepos
) : GitHubUseCases

object GitHubCasesImplTimeTemp {
	val getRepos = GetRepos
}