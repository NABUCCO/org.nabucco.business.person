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
package org.nabucco.business.person.ui.rcp.communication.maintain;

import org.nabucco.business.person.facade.message.ApplicantMsg;
import org.nabucco.business.person.facade.message.ContactPersonMsg;
import org.nabucco.business.person.facade.message.EmployeeMsg;
import org.nabucco.business.person.facade.message.IndividualPersonMsg;
import org.nabucco.business.person.facade.service.maintain.MaintainPerson;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * MaintainPersonDelegate<p/>Maintain Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class MaintainPersonDelegate extends ServiceDelegateSupport {

    private MaintainPerson service;

    /**
     * Constructs a new MaintainPersonDelegate instance.
     *
     * @param service the MaintainPerson.
     */
    public MaintainPersonDelegate(MaintainPerson service) {
        super();
        this.service = service;
    }

    /**
     * MaintainEmployee.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmployeeMsg.
     * @return the EmployeeMsg.
     * @throws ClientException
     */
    public EmployeeMsg maintainEmployee(EmployeeMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<EmployeeMsg> request = new ServiceRequest<EmployeeMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainEmployee(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainPerson.class, "maintainEmployee", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainPerson.maintainEmployee");
    }

    /**
     * MaintainContactPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ContactPersonMsg.
     * @return the ContactPersonMsg.
     * @throws ClientException
     */
    public ContactPersonMsg maintainContactPerson(ContactPersonMsg message, ServiceSubContext... subContexts)
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
                response = service.maintainContactPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainPerson.class, "maintainContactPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainPerson.maintainContactPerson");
    }

    /**
     * MaintainIndividualPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the IndividualPersonMsg.
     * @return the IndividualPersonMsg.
     * @throws ClientException
     */
    public IndividualPersonMsg maintainIndividualPerson(IndividualPersonMsg message, ServiceSubContext... subContexts)
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
                response = service.maintainIndividualPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainPerson.class, "maintainIndividualPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainPerson.maintainIndividualPerson");
    }

    /**
     * DeleteEmployee.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmployeeMsg.
     * @return the EmployeeMsg.
     * @throws ClientException
     */
    public EmployeeMsg deleteEmployee(EmployeeMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<EmployeeMsg> request = new ServiceRequest<EmployeeMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.deleteEmployee(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainPerson.class, "deleteEmployee", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainPerson.deleteEmployee");
    }

    /**
     * MaintainApplicant.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ApplicantMsg.
     * @return the ApplicantMsg.
     * @throws ClientException
     */
    public ApplicantMsg maintainApplicant(ApplicantMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ApplicantMsg> request = new ServiceRequest<ApplicantMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ApplicantMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainApplicant(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainPerson.class, "maintainApplicant", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainPerson.maintainApplicant");
    }
}
