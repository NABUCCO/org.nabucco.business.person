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
package org.nabucco.business.person.ui.rcp.communication.search;

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
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

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
     * @param message the EmployeeSearchRq.
     * @return the EmployeeListMsg.
     * @throws ClientException
     */
    public EmployeeListMsg searchEmployee(EmployeeSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmployeeSearchRq> request = new ServiceRequest<EmployeeSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchPerson.searchEmployee");
    }

    /**
     * SearchEmployeeId.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmployeeIdSearchRq.
     * @return the EmployeeIdListMsg.
     * @throws ClientException
     */
    public EmployeeIdListMsg searchEmployeeId(EmployeeIdSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmployeeIdSearchRq> request = new ServiceRequest<EmployeeIdSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeIdListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchPerson.searchEmployeeId");
    }

    /**
     * SearchPersonCharacteristicByPersonMasterId.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PersonCharacteristicSearchRq.
     * @return the PersonCharacteristicMsg.
     * @throws ClientException
     */
    public PersonCharacteristicMsg searchPersonCharacteristicByPersonMasterId(PersonCharacteristicSearchRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<PersonCharacteristicSearchRq> request = new ServiceRequest<PersonCharacteristicSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PersonCharacteristicMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchPerson.searchPersonCharacteristicByPersonMasterId");
    }

    /**
     * SearchIndividualPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the IndividualPersonSearchRq.
     * @return the IndividualPersonListMsg.
     * @throws ClientException
     */
    public IndividualPersonListMsg searchIndividualPerson(IndividualPersonSearchRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<IndividualPersonSearchRq> request = new ServiceRequest<IndividualPersonSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<IndividualPersonListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchPerson.searchIndividualPerson");
    }

    /**
     * SearchContactPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ContactPersonSearchRq.
     * @return the ContactPersonListMsg.
     * @throws ClientException
     */
    public ContactPersonListMsg searchContactPerson(ContactPersonSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ContactPersonSearchRq> request = new ServiceRequest<ContactPersonSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ContactPersonListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchPerson.searchContactPerson");
    }

    /**
     * SearchApplicant.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ApplicantSearchRq.
     * @return the ApplicantListMsg.
     * @throws ClientException
     */
    public ApplicantListMsg searchApplicant(ApplicantSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ApplicantSearchRq> request = new ServiceRequest<ApplicantSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ApplicantListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchPerson.searchApplicant");
    }

    /**
     * SearchPersonDatatype.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PersonSearchRq.
     * @return the PersonMsg.
     * @throws ClientException
     */
    public PersonMsg searchPersonDatatype(PersonSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PersonSearchRq> request = new ServiceRequest<PersonSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PersonMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchPerson.searchPersonDatatype");
    }

    /**
     * SearchPersonMaster.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PersonMasterSearchRq.
     * @return the PersonMasterListMsg.
     * @throws ClientException
     */
    public PersonMasterListMsg searchPersonMaster(PersonMasterSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PersonMasterSearchRq> request = new ServiceRequest<PersonMasterSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PersonMasterListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
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
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchPerson.searchPersonMaster");
    }
}
