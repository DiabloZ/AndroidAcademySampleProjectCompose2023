package com.suhov.aaspc2023.domain.usecases

import org.koin.core.annotation.Single

@Single
class GitHubUseCasesImpl(
	override val getRepos: GetRepos
) : GitHubUseCases