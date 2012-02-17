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

import org.nabucco.business.person.facade.datatype.EmployeeRole;
import org.nabucco.business.person.facade.message.EmployeeRoleListMsg;
import org.nabucco.business.person.facade.message.produce.EmployeeRoleProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * 
 * ProduceEmployeeRoleServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class ProduceEmployeeRoleServiceHandlerImpl extends ProduceEmployeeRoleServiceHandler {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /*
     * (non-Javadoc)
     * 
     * @see org.nabucco.business.person.impl.service.produce.ProduceEmployeeRoleServiceHandler#
     * produceEmployeeRole(org.nabucco.business.person.facade.message.produce.EmployeeRoleProduceRq)
     */
    @Override
    protected EmployeeRoleListMsg produceEmployeeRole(EmployeeRoleProduceRq msg) throws ProduceException {

        EmployeeRoleListMsg response = new EmployeeRoleListMsg();

        for (int i = 0; i < msg.getNumber().getValue(); i++) {
            EmployeeRole datatype = new EmployeeRole();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);

            response.getEmployeeRoleList().add(datatype);
        }

        return response;
    }

}
