/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.person.ui.web.communication.search;

import org.nabucco.business.person.facade.message.ApplicantListMsg;
import org.nabucco.business.person.facade.message.ContactPersonListMsg;
import org.nabucco.business.person.facade.message.EmployeeIdListMsg;
import org.nabucco.business.person.facade.message.EmployeeListMsg;
import org.nabucco.business.person.facade.message.IndividualPersonListMsg;
import org.nabucco.business.person.facade.message.PersonCharacteristicMsg;
import org.nabucco.business.person.facade.message.PersonMasterListMsg;
import org.nabucco.business.person.facade.message.PersonMsg;
import org.nabucco.business.person.facade.message.search.ApplicantSearchRq;
import org.nabucco.business.person.facade.message.search.ContactPersonSearchRq;
import org.nabucco.business.person.facade.message.search.EmployeeIdSearchRq;
import org.nabucco.business.person.facade.message.search.EmployeeSearchRq;
import org.nabucco.business.person.facade.message.search.IndividualPersonSearchRq;
import org.nabucco.business.person.facade.message.search.PersonCharacteristicSearchRq;
import org.nabucco.business.person.facade.message.search.PersonMasterSearchRq;
import org.nabucco.business.person.facade.message.search.PersonSearchRq;
import org.nabucco.business.person.facade.service.search.SearchPerson;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

/**
 * SearchPersonDelegate<p/>Search Service for Person<p/>
 *
 * @version 1.2
 * @author Dominic Trumpfheller, Holger Librenz, PRODYNA AG, 2011-07-19
 */
public class SearchPersonDelegate extends ServiceDelegateSupport {

    private SearchPerson service;

    /**
     * Constructs a new SearchPersonDelegate instance.
     *
     * @param service the SearchPerson.
     */
    public SearchPersonDelegate(SearchPerson service) {
        super();
        this.service = service;
    }

    /**
     * SearchEmployee.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EmployeeSearchRq.
     * @return the EmployeeListMsg.
     * @throws SearchException
     */
    public EmployeeListMsg searchEmployee(EmployeeSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<EmployeeSearchRq> request = new ServiceRequest<EmployeeSearchRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchEmployee(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchPerson.class, "searchEmployee", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchPerson.searchEmployee");
    }

    /**
     * SearchEmployeeId.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EmployeeIdSearchRq.
     * @return the EmployeeIdListMsg.
     * @throws SearchException
     */
    public EmployeeIdListMsg searchEmployeeId(EmployeeIdSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<EmployeeIdSearchRq> request = new ServiceRequest<EmployeeIdSearchRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeIdListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchEmployeeId(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchPerson.class, "searchEmployeeId", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchPerson.searchEmployeeId");
    }

    /**
     * SearchPersonCharacteristicByPersonMasterId.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the PersonCharacteristicSearchRq.
     * @return the PersonCharacteristicMsg.
     * @throws SearchException
     */
    public PersonCharacteristicMsg searchPersonCharacteristicByPersonMasterId(PersonCharacteristicSearchRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<PersonCharacteristicSearchRq> request = new ServiceRequest<PersonCharacteristicSearchRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PersonCharacteristicMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchPersonCharacteristicByPersonMasterId(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchPerson.class, "searchPersonCharacteristicByPersonMasterId", duration,
                        exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException(
                "Cannot execute service operation: SearchPerson.searchPersonCharacteristicByPersonMasterId");
    }

    /**
     * SearchIndividualPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the IndividualPersonSearchRq.
     * @return the IndividualPersonListMsg.
     * @throws SearchException
     */
    public IndividualPersonListMsg searchIndividualPerson(IndividualPersonSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<IndividualPersonSearchRq> request = new ServiceRequest<IndividualPersonSearchRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<IndividualPersonListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchIndividualPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchPerson.class, "searchIndividualPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchPerson.searchIndividualPerson");
    }

    /**
     * SearchContactPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ContactPersonSearchRq.
     * @return the ContactPersonListMsg.
     * @throws SearchException
     */
    public ContactPersonListMsg searchContactPerson(ContactPersonSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<ContactPersonSearchRq> request = new ServiceRequest<ContactPersonSearchRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ContactPersonListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchContactPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchPerson.class, "searchContactPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchPerson.searchContactPerson");
    }

    /**
     * SearchApplicant.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ApplicantSearchRq.
     * @return the ApplicantListMsg.
     * @throws SearchException
     */
    public ApplicantListMsg searchApplicant(ApplicantSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<ApplicantSearchRq> request = new ServiceRequest<ApplicantSearchRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ApplicantListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchApplicant(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchPerson.class, "searchApplicant", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchPerson.searchApplicant");
    }

    /**
     * SearchPersonDatatype.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the PersonSearchRq.
     * @return the PersonMsg.
     * @throws SearchException
     */
    public PersonMsg searchPersonDatatype(PersonSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<PersonSearchRq> request = new ServiceRequest<PersonSearchRq>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PersonMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchPersonDatatype(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchPerson.class, "searchPersonDatatype", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchPerson.searchPersonDatatype");
    }

    /**
     * SearchPersonMaster.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the PersonMasterSearchRq.
     * @return the PersonMasterListMsg.
     * @throws SearchException
     */
    public PersonMasterListMsg searchPersonMaster(PersonMasterSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<PersonMasterSearchRq> request = new ServiceRequest<PersonMasterSearchRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PersonMasterListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchPersonMaster(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchPerson.class, "searchPersonMaster", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchPerson.searchPersonMaster");
    }
}
