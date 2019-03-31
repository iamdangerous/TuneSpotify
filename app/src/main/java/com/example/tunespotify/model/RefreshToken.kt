package com.example.tunespotify.model

data class RefreshToken(val accessToken: String, val token_type: String, val scope: String, val expires_in: String)