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
package org.nabucco.business.person.impl.service.resolve;

import org.nabucco.business.person.facade.datatype.IndividualPerson;
import org.nabucco.business.person.facade.message.IndividualPersonMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * 
 * ResolveIndividualPersonServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ResolveIndividualPersonServiceHandlerImpl extends ResolveIndividualPersonServiceHandler {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected IndividualPersonMsg resolveIndividualPerson(IndividualPersonMsg msg) throws ResolveException {

        IndividualPerson individualPerson = msg.getIndividualPerson();

        try {
            individualPerson = super.getPersistenceManager().find(msg.getIndividualPerson());
            individualPerson.getRelationList().size();

        } catch (Exception e) {
            throw new ResolveException("Cannot resolve IndividualPerson with id " + individualPerson.getId(), e);
        }

        IndividualPersonMsg response = new IndividualPersonMsg();
        response.setIndividualPerson(individualPerson);
        return response;
    }

}
