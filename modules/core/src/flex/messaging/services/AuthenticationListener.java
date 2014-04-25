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
package flex.messaging.services;

import java.util.EventListener;

/**
 * The listener interface for receiving <tt>AuthenticationEvent</tt>s.
 * <tt>AuthenticationListener</tt>s are registered with the <tt>AuthenticationService</tt>
 * and allow for custom post-processing of successful user login and logout events.
 */
public interface AuthenticationListener extends EventListener
{
    /**
     * Invoked after a user has successfully logged in.
     */
    void loginSucceeded(AuthenticationEvent event);
    
    /**
     * Invoked after a user has successfully logged out.
     */
    void logoutSucceeded(AuthenticationEvent event);
}
