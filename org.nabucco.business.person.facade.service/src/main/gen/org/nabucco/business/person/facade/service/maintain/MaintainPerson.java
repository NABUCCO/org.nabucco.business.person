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
package org.nabucco.business.person.facade.service.maintain;

import org.nabucco.business.person.facade.message.ApplicantMsg;
import org.nabucco.business.person.facade.message.ContactPersonMsg;
import org.nabucco.business.person.facade.message.EmployeeMsg;
import org.nabucco.business.person.facade.message.IndividualPersonMsg;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * MaintainPerson<p/>Maintain Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface MaintainPerson extends Service {

    /**
     * Missing description at method maintainEmployee.
     *
     * @param rq the ServiceRequest<EmployeeMsg>.
     * @return the ServiceResponse<EmployeeMsg>.
     * @throws MaintainException
     */
    ServiceResponse<EmployeeMsg> maintainEmployee(ServiceRequest<EmployeeMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainContactPerson.
     *
     * @param rq the ServiceRequest<ContactPersonMsg>.
     * @return the ServiceResponse<ContactPersonMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ContactPersonMsg> maintainContactPerson(ServiceRequest<ContactPersonMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method maintainIndividualPerson.
     *
     * @param rq the ServiceRequest<IndividualPersonMsg>.
     * @return the ServiceResponse<IndividualPersonMsg>.
     * @throws MaintainException
     */
    ServiceResponse<IndividualPersonMsg> maintainIndividualPerson(ServiceRequest<IndividualPersonMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method deleteEmployee.
     *
     * @param rq the ServiceRequest<EmployeeMsg>.
     * @return the ServiceResponse<EmployeeMsg>.
     * @throws MaintainException
     */
    ServiceResponse<EmployeeMsg> deleteEmployee(ServiceRequest<EmployeeMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainApplicant.
     *
     * @param rq the ServiceRequest<ApplicantMsg>.
     * @return the ServiceResponse<ApplicantMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ApplicantMsg> maintainApplicant(ServiceRequest<ApplicantMsg> rq) throws MaintainException;
}
