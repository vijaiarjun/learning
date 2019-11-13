package com.example.datastore.security;

import java.io.IOException;

public interface CredentialsProvider {
  String getCredentials() throws IOException;
}
