package com.suhov.aaspc2023.data.usecases

import org.koin.core.annotation.Single

@Single
class GitHubUseCasesImpl(
	override val getRepos: GetRepos
) : GitHubUseCases