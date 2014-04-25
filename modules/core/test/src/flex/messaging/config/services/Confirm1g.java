/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package flex.messaging.config.services;

import flex.messaging.config.ConfigurationConfirmation;
import flex.messaging.config.MessagingConfiguration;
import flex.messaging.LocalizedException;
import flex.messaging.MessageException;

public class Confirm1g extends ConfigurationConfirmation
{
    public Confirm1g()
    {
    }

    public boolean isNegativeTest()
    {
        return true;
    }

    public MessagingConfiguration getExpectedConfiguration()
    {
        return null;
    }

    public LocalizedException getExpectedException()
    {
        return new MessageException("Invalid service id 'foo-service,'.");
    }
}

