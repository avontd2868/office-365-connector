/*
 * Copyright © 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.enterprise.cloudsearch.o365;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * {@link HttpRequestInitializer} implementation for adding access token and common headers to
 * outgoing requests.
 */
class RequestInitalizer implements HttpRequestInitializer {

  private final ApiConnection apiConnection;

  RequestInitalizer(ApiConnection apiConnnection) {
    this.apiConnection = checkNotNull(apiConnnection, "ApiConnection can not be null");
  }

  @Override
  public void initialize(HttpRequest request) throws IOException {
    request.getHeaders().setAccept("application/json");
    try {
      request.getHeaders().setAuthorization("Bearer " + apiConnection.getAccessToken());
    } catch (ExecutionException e) {
      throw new IOException("Error obtaining authentication token", e);
    }
  }
}
