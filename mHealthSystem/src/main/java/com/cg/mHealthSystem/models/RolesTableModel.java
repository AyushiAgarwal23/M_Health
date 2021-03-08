package com.cg.mHealthSystem.models;

import org.springframework.stereotype.Component;

@Component
public class RolesTableModel {
	
	public class rolesTableModel{
		public Integer roleId;
		public String roleName;
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
		public rolesTableModel(Integer roleId, String roleName) {
			super();
			this.roleId = roleId;
			this.roleName = roleName;
		}
		public rolesTableModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
}
