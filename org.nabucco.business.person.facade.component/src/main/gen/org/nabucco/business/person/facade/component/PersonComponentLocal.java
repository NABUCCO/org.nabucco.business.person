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
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;

/**
 * PersonComponentLocal<p/>Person component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface PersonComponentLocal extends PersonComponent {

    /**
     * Getter for the ComponentRelationServiceLocal.
     *
     * @return the ComponentRelationService.
     * @throws ServiceException
     */
    ComponentRelationService getComponentRelationServiceLocal() throws ServiceException;

    /**
     * Getter for the QueryFilterServiceLocal.
     *
     * @return the QueryFilterService.
     * @throws ServiceException
     */
    QueryFilterService getQueryFilterServiceLocal() throws ServiceException;

    /**
     * Getter for the MaintainPersonLocal.
     *
     * @return the MaintainPerson.
     * @throws ServiceException
     */
    MaintainPerson getMaintainPersonLocal() throws ServiceException;

    /**
     * Getter for the ProducePersonLocal.
     *
     * @return the ProducePerson.
     * @throws ServiceException
     */
    ProducePerson getProducePersonLocal() throws ServiceException;

    /**
     * Getter for the ResolvePersonLocal.
     *
     * @return the ResolvePerson.
     * @throws ServiceException
     */
    ResolvePerson getResolvePersonLocal() throws ServiceException;

    /**
     * Getter for the SearchPersonLocal.
     *
     * @return the SearchPerson.
     * @throws ServiceException
     */
    SearchPerson getSearchPersonLocal() throws ServiceException;
}
