package com.secutest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secutest.entity.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

    @Query(value = "SELECT permission FROM ROLE_PERMISSION WHERE role_id IN (:roleIds)", nativeQuery = true)
    List<String> permissions(@Param("roleIds") List<Long> roleIds);

}
