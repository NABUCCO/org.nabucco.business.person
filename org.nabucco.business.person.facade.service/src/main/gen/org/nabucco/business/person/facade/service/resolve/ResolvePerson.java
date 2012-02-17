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
package org.nabucco.business.person.facade.service.resolve;

import org.nabucco.business.person.facade.message.ApplicantMsg;
import org.nabucco.business.person.facade.message.ContactPersonMsg;
import org.nabucco.business.person.facade.message.EmployeeMsg;
import org.nabucco.business.person.facade.message.IndividualPersonMsg;
import org.nabucco.business.person.facade.message.PersonMasterMsg;
import org.nabucco.business.person.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.person.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ResolvePerson<p/>Resolve Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface ResolvePerson extends Service {

    /**
     * Missing description at method resolveEmployee.
     *
     * @param rq the ServiceRequest<EmployeeMsg>.
     * @return the ServiceResponse<EmployeeMsg>.
     * @throws ResolveException
     */
    ServiceResponse<EmployeeMsg> resolveEmployee(ServiceRequest<EmployeeMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolvePersonMaster.
     *
     * @param rq the ServiceRequest<PersonMasterMsg>.
     * @return the ServiceResponse<PersonMasterMsg>.
     * @throws ResolveException
     */
    ServiceResponse<PersonMasterMsg> resolvePersonMaster(ServiceRequest<PersonMasterMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveIndividualPerson.
     *
     * @param rq the ServiceRequest<IndividualPersonMsg>.
     * @return the ServiceResponse<IndividualPersonMsg>.
     * @throws ResolveException
     */
    ServiceResponse<IndividualPersonMsg> resolveIndividualPerson(ServiceRequest<IndividualPersonMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveContactPerson.
     *
     * @param rq the ServiceRequest<ContactPersonMsg>.
     * @return the ServiceResponse<ContactPersonMsg>.
     * @throws ResolveException
     */
    ServiceResponse<ContactPersonMsg> resolveContactPerson(ServiceRequest<ContactPersonMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveApplicant.
     *
     * @param rq the ServiceRequest<ApplicantMsg>.
     * @return the ServiceResponse<ApplicantMsg>.
     * @throws ResolveException
     */
    ServiceResponse<ApplicantMsg> resolveApplicant(ServiceRequest<ApplicantMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveDatatypeList.
     *
     * @param rq the ServiceRequest<ResolveDatatypeListRq>.
     * @return the ServiceResponse<ResolveDatatypeListRs>.
     * @throws ResolveException
     */
    ServiceResponse<ResolveDatatypeListRs> resolveDatatypeList(ServiceRequest<ResolveDatatypeListRq> rq)
            throws ResolveException;
}
