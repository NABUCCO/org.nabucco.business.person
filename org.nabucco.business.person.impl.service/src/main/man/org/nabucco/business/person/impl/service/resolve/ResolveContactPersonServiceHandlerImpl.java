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

import org.nabucco.business.person.facade.datatype.ContactPerson;
import org.nabucco.business.person.facade.message.ContactPersonMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * ResolveContactPersonServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class ResolveContactPersonServiceHandlerImpl extends ResolveContactPersonServiceHandler {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected ContactPersonMsg resolveContactPerson(ContactPersonMsg msg) throws ResolveException {

        ContactPerson contactPerson = msg.getContactPerson();

        try {
            contactPerson = super.getPersistenceManager().find(msg.getContactPerson());
            contactPerson.getRelationList().size();

        } catch (Exception e) {
            throw new ResolveException("Cannot resolve ContactPerson with id " + contactPerson.getId(), e);
        }

        ContactPersonMsg response = new ContactPersonMsg();
        response.setContactPerson(contactPerson);
        return response;
    }

}
