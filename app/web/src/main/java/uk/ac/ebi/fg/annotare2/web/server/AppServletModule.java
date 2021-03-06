/*
 * Copyright 2009-2012 European Molecular Biology Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or impl
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.ebi.fg.annotare2.web.server;

import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import uk.ac.ebi.fg.annotare2.web.server.auth.AuthenticationService;
import uk.ac.ebi.fg.annotare2.web.server.auth.AuthenticationServiceImpl;
import uk.ac.ebi.fg.annotare2.web.server.auth.LoginServlet;
import uk.ac.ebi.fg.annotare2.web.server.auth.SecurityFilter;

/**
 * @author Olga Melnichuk
 */
public class AppServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        filter("/UserApp/*", "/index.html").through(SecurityFilter.class);

        serve("/login").with(LoginServlet.class);

        bind(SecurityFilter.class).in(Scopes.SINGLETON);
        bind(LoginServlet.class).in(Scopes.SINGLETON);

        bind(AuthenticationService.class).to(AuthenticationServiceImpl.class).in(Scopes.SINGLETON);
    }
}
