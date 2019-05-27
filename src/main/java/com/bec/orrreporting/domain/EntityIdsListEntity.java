/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright BEC - All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * MAY 23 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.orrreporting.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "entity_ids_list", schema = "public", catalog = "r_dev_orr_redshift")
public class EntityIdsListEntity {
    private long entityId;
    private String entityName;
    private Long currentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id", nullable = false)
    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    @Basic
    @Column(name = "entity_name", nullable = true, length = 100)
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Basic
    @Column(name = "current_id", nullable = true)
    public Long getCurrentId() {
        return currentId;
    }

    public void setCurrentId(Long currentId) {
        this.currentId = currentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityIdsListEntity that = (EntityIdsListEntity) o;
        return entityId == that.entityId &&
                Objects.equals(entityName, that.entityName) &&
                Objects.equals(currentId, that.currentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entityId, entityName, currentId);
    }
}
