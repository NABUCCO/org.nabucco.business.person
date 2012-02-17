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
package org.nabucco.business.person.ui.rcp.communication.resolve;

import org.nabucco.business.person.facade.message.ApplicantMsg;
import org.nabucco.business.person.facade.message.ContactPersonMsg;
import org.nabucco.business.person.facade.message.EmployeeMsg;
import org.nabucco.business.person.facade.message.IndividualPersonMsg;
import org.nabucco.business.person.facade.message.PersonMasterMsg;
import org.nabucco.business.person.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.person.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.business.person.facade.service.resolve.ResolvePerson;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ResolvePersonDelegate<p/>Resolve Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ResolvePersonDelegate extends ServiceDelegateSupport {

    private ResolvePerson service;

    /**
     * Constructs a new ResolvePersonDelegate instance.
     *
     * @param service the ResolvePerson.
     */
    public ResolvePersonDelegate(ResolvePerson service) {
        super();
        this.service = service;
    }

    /**
     * ResolveEmployee.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmployeeMsg.
     * @return the EmployeeMsg.
     * @throws ClientException
     */
    public EmployeeMsg resolveEmployee(EmployeeMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<EmployeeMsg> request = new ServiceRequest<EmployeeMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveEmployee(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolvePerson.class, "resolveEmployee", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolvePerson.resolveEmployee");
    }

    /**
     * ResolvePersonMaster.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PersonMasterMsg.
     * @return the PersonMasterMsg.
     * @throws ClientException
     */
    public PersonMasterMsg resolvePersonMaster(PersonMasterMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PersonMasterMsg> request = new ServiceRequest<PersonMasterMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PersonMasterMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolvePersonMaster(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolvePerson.class, "resolvePersonMaster", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolvePerson.resolvePersonMaster");
    }

    /**
     * ResolveIndividualPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the IndividualPersonMsg.
     * @return the IndividualPersonMsg.
     * @throws ClientException
     */
    public IndividualPersonMsg resolveIndividualPerson(IndividualPersonMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<IndividualPersonMsg> request = new ServiceRequest<IndividualPersonMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<IndividualPersonMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveIndividualPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolvePerson.class, "resolveIndividualPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolvePerson.resolveIndividualPerson");
    }

    /**
     * ResolveContactPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ContactPersonMsg.
     * @return the ContactPersonMsg.
     * @throws ClientException
     */
    public ContactPersonMsg resolveContactPerson(ContactPersonMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ContactPersonMsg> request = new ServiceRequest<ContactPersonMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ContactPersonMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveContactPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolvePerson.class, "resolveContactPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolvePerson.resolveContactPerson");
    }

    /**
     * ResolveApplicant.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ApplicantMsg.
     * @return the ApplicantMsg.
     * @throws ClientException
     */
    public ApplicantMsg resolveApplicant(ApplicantMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ApplicantMsg> request = new ServiceRequest<ApplicantMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ApplicantMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveApplicant(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolvePerson.class, "resolveApplicant", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolvePerson.resolveApplicant");
    }

    /**
     * ResolveDatatypeList.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ResolveDatatypeListRq.
     * @return the ResolveDatatypeListRs.
     * @throws ClientException
     */
    public ResolveDatatypeListRs resolveDatatypeList(ResolveDatatypeListRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ResolveDatatypeListRq> request = new ServiceRequest<ResolveDatatypeListRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ResolveDatatypeListRs> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveDatatypeList(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolvePerson.class, "resolveDatatypeList", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolvePerson.resolveDatatypeList");
    }
}
