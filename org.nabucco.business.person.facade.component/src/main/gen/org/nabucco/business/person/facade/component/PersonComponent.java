/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.business.person.facade.component;

import org.nabucco.business.person.facade.service.maintain.MaintainPerson;
import org.nabucco.business.person.facade.service.produce.ProducePerson;
import org.nabucco.business.person.facade.service.resolve.ResolvePerson;
import org.nabucco.business.person.facade.service.search.SearchPerson;
import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;

/**
 * PersonComponent<p/>Person component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface PersonComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.business.person";

    final String COMPONENT_PREFIX = "pers";

    final String JNDI_NAME = ((((JNDI_PREFIX + "/") + COMPONENT_NAME) + "/") + "org.nabucco.business.person.facade.component.PersonComponent");

    /**
     * Getter for the MaintainPerson.
     *
     * @return the MaintainPerson.
     * @throws ServiceException
     */
    MaintainPerson getMaintainPerson() throws ServiceException;

    /**
     * Getter for the ProducePerson.
     *
     * @return the ProducePerson.
     * @throws ServiceException
     */
    ProducePerson getProducePerson() throws ServiceException;

    /**
     * Getter for the ResolvePerson.
     *
     * @return the ResolvePerson.
     * @throws ServiceException
     */
    ResolvePerson getResolvePerson() throws ServiceException;

    /**
     * Getter for the SearchPerson.
     *
     * @return the SearchPerson.
     * @throws ServiceException
     */
    SearchPerson getSearchPerson() throws ServiceException;
}
