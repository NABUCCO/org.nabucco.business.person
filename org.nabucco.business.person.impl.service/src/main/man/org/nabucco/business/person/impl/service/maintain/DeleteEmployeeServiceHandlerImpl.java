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
package org.nabucco.business.person.impl.service.maintain;

import org.nabucco.business.person.facade.datatype.Employee;
import org.nabucco.business.person.facade.message.EmployeeMsg;
import org.nabucco.business.person.impl.service.maintain.support.MaintainPersonCharacteristicServiceSupport;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * DeleteEmployeeServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class DeleteEmployeeServiceHandlerImpl extends DeleteEmployeeServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected EmployeeMsg deleteEmployee(EmployeeMsg msg) throws MaintainException {

        MaintainPersonCharacteristicServiceSupport handler = new MaintainPersonCharacteristicServiceSupport(
                this.getPersistenceManager());

        msg.getEmployee().setDatatypeState(DatatypeState.DELETED);
        Employee employee = handler.maintain(msg.getEmployee());

        EmployeeMsg response = new EmployeeMsg();
        response.setEmployee(employee);
        return response;
    }

}
