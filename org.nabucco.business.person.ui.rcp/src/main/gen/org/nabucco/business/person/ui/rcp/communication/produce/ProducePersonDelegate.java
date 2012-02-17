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
package org.nabucco.business.person.ui.rcp.communication.produce;

import org.nabucco.business.person.facade.message.ApplicantListMsg;
import org.nabucco.business.person.facade.message.BankAccountListMsg;
import org.nabucco.business.person.facade.message.ContactPersonListMsg;
import org.nabucco.business.person.facade.message.EmployeeAccountingDataListMsg;
import org.nabucco.business.person.facade.message.EmployeeContractDataListMsg;
import org.nabucco.business.person.facade.message.EmployeeListMsg;
import org.nabucco.business.person.facade.message.EmployeeRoleListMsg;
import org.nabucco.business.person.facade.message.IndividualPersonListMsg;
import org.nabucco.business.person.facade.message.produce.ApplicantProduceRq;
import org.nabucco.business.person.facade.message.produce.BankAccountProduceRq;
import org.nabucco.business.person.facade.message.produce.ContactPersonProduceRq;
import org.nabucco.business.person.facade.message.produce.EmployeeAccountingDataProduceRq;
import org.nabucco.business.person.facade.message.produce.EmployeeContractDataProduceRq;
import org.nabucco.business.person.facade.message.produce.EmployeeProduceRq;
import org.nabucco.business.person.facade.message.produce.EmployeeRoleProduceRq;
import org.nabucco.business.person.facade.message.produce.IndividualPersonProduceRq;
import org.nabucco.business.person.facade.service.produce.ProducePerson;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ProducePersonDelegate<p/>Produce Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ProducePersonDelegate extends ServiceDelegateSupport {

    private ProducePerson service;

    /**
     * Constructs a new ProducePersonDelegate instance.
     *
     * @param service the ProducePerson.
     */
    public ProducePersonDelegate(ProducePerson service) {
        super();
        this.service = service;
    }

    /**
     * ProduceEmployee.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmployeeProduceRq.
     * @return the EmployeeListMsg.
     * @throws ClientException
     */
    public EmployeeListMsg produceEmployee(EmployeeProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmployeeProduceRq> request = new ServiceRequest<EmployeeProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEmployee(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceEmployee", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProducePerson.produceEmployee");
    }

    /**
     * ProduceEmployeeRole.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmployeeRoleProduceRq.
     * @return the EmployeeRoleListMsg.
     * @throws ClientException
     */
    public EmployeeRoleListMsg produceEmployeeRole(EmployeeRoleProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmployeeRoleProduceRq> request = new ServiceRequest<EmployeeRoleProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeRoleListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEmployeeRole(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceEmployeeRole", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProducePerson.produceEmployeeRole");
    }

    /**
     * ProduceBankAccount.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the BankAccountProduceRq.
     * @return the BankAccountListMsg.
     * @throws ClientException
     */
    public BankAccountListMsg produceBankAccount(BankAccountProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<BankAccountProduceRq> request = new ServiceRequest<BankAccountProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<BankAccountListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceBankAccount(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceBankAccount", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProducePerson.produceBankAccount");
    }

    /**
     * ProduceEmployeeAccountingData.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmployeeAccountingDataProduceRq.
     * @return the EmployeeAccountingDataListMsg.
     * @throws ClientException
     */
    public EmployeeAccountingDataListMsg produceEmployeeAccountingData(EmployeeAccountingDataProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<EmployeeAccountingDataProduceRq> request = new ServiceRequest<EmployeeAccountingDataProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeAccountingDataListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEmployeeAccountingData(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceEmployeeAccountingData", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProducePerson.produceEmployeeAccountingData");
    }

    /**
     * ProduceEmployeeContractData.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmployeeContractDataProduceRq.
     * @return the EmployeeContractDataListMsg.
     * @throws ClientException
     */
    public EmployeeContractDataListMsg produceEmployeeContractData(EmployeeContractDataProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<EmployeeContractDataProduceRq> request = new ServiceRequest<EmployeeContractDataProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeContractDataListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEmployeeContractData(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceEmployeeContractData", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProducePerson.produceEmployeeContractData");
    }

    /**
     * ProduceIndividualPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the IndividualPersonProduceRq.
     * @return the IndividualPersonListMsg.
     * @throws ClientException
     */
    public IndividualPersonListMsg produceIndividualPerson(IndividualPersonProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<IndividualPersonProduceRq> request = new ServiceRequest<IndividualPersonProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<IndividualPersonListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceIndividualPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceIndividualPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProducePerson.produceIndividualPerson");
    }

    /**
     * ProduceContactPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ContactPersonProduceRq.
     * @return the ContactPersonListMsg.
     * @throws ClientException
     */
    public ContactPersonListMsg produceContactPerson(ContactPersonProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ContactPersonProduceRq> request = new ServiceRequest<ContactPersonProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ContactPersonListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceContactPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceContactPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProducePerson.produceContactPerson");
    }

    /**
     * ProduceApplicant.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ApplicantProduceRq.
     * @return the ApplicantListMsg.
     * @throws ClientException
     */
    public ApplicantListMsg produceApplicant(ApplicantProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ApplicantProduceRq> request = new ServiceRequest<ApplicantProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ApplicantListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceApplicant(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceApplicant", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProducePerson.produceApplicant");
    }
}
