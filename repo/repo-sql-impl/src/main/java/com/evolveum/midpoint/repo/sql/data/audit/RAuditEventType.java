/*
 * Copyright (c) 2010-2013 Evolveum
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.evolveum.midpoint.repo.sql.data.audit;

import com.evolveum.midpoint.audit.api.AuditEventType;

/**
 * @author lazyman
 */
public enum RAuditEventType {

    GET_OBJECT(AuditEventType.GET_OBJECT),

    ADD_OBJECT(AuditEventType.ADD_OBJECT),

    MODIFY_OBJECT(AuditEventType.MODIFY_OBJECT),

    DELETE_OBJECT(AuditEventType.DELETE_OBJECT),
    
    EXECUTE_CHANGES_RAW(AuditEventType.EXECUTE_CHANGES_RAW),

    SYNCHRONIZATION(AuditEventType.SYNCHRONIZATION),

    CREATE_SESSION(AuditEventType.CREATE_SESSION),

    TERMINATE_SESSION(AuditEventType.TERMINATE_SESSION),

    WORK_ITEM(AuditEventType.WORK_ITEM),

    WORKFLOW_PROCESS_INSTANCE(AuditEventType.WORKFLOW_PROCESS_INSTANCE);

    private AuditEventType type;

    private RAuditEventType(AuditEventType type) {
        this.type = type;
    }

    public AuditEventType getType() {
        return type;
    }


    public static RAuditEventType toRepo(AuditEventType type) {
        if (type == null) {
            return null;
        }

        for (RAuditEventType st : RAuditEventType.values()) {
            if (type.equals(st.getType())) {
                return st;
            }
        }

        throw new IllegalArgumentException("Unknown audit event type '" + type + "'.");
    }
}
