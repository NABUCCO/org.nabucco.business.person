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
package org.nabucco.business.person.impl.service.produce;

import org.nabucco.business.person.facade.datatype.Employee;
import org.nabucco.business.person.facade.datatype.PersonMaster;
import org.nabucco.business.person.facade.message.EmployeeListMsg;
import org.nabucco.business.person.facade.message.produce.EmployeeProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.security.User;
import org.nabucco.framework.base.facade.datatype.security.UserId;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * 
 * ProduceEmployeeServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class ProduceEmployeeServiceHandlerImpl extends ProduceEmployeeServiceHandler {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.nabucco.business.person.impl.service.produce.ProduceEmployeeServiceHandler#produceEmployee
     * (org.nabucco.business.person.facade.message.produce.EmployeeProduceRq)
     */
    @Override
    protected EmployeeListMsg produceEmployee(EmployeeProduceRq msg) throws ProduceException {

        EmployeeListMsg response = new EmployeeListMsg();

        User user = getContext().getSubject().getUser();
        for (int i = 0; i < msg.getNumber().getValue(); i++) {

            // master
            PersonMaster master = new PersonMaster();
            master.setDatatypeState(DatatypeState.INITIALIZED);
            master.setStatusType(StatusType.ACTIVE);
            master.setOwner(user.getOwner());
            master.setUserId(new UserId(user.getUsername().getValue()));

            // employee
            Employee employee = new Employee();
            employee.setDatatypeState(DatatypeState.INITIALIZED);
            employee.setMaster(master);

            response.getEmployeeList().add(employee);
        }

        return response;

    }

}
