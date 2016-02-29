class clone_repository {
	vcsrepo { '/GitRepository/ContentSphere':
	  ensure   => latest,
  	  provider => git,
	  source   => 'https://reader-inbetween:pass%40123@github.com/Inbetween/ContentSphere.git',
	  revision => 'tempDecemberRelease',
	}
}
