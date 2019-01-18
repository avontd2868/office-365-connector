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
package com.google.enterprise.cloudsearch.o365.model;

import com.google.api.client.json.GenericJson;
import java.util.List;

/**
 * The abstract class describes the list of identities
 */
public abstract class DirectoryObjects extends GenericJson {

  public abstract boolean isValid();

  public abstract List<? extends DirectoryObject> getValue();

  public abstract String getOdataNextlink();

  public abstract String getOdataDeltalink();
}
