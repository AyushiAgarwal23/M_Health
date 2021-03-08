package com.cg.mHealthSystem.models;
import org.springframework.stereotype.Component;
@Component
public class UserTableModel {
	
	public class rolesTableModel{
		public Integer roleId;
		public String userId;
		public String firstName;
		public String emailId;
		public String password;
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public rolesTableModel(Integer roleId, String userId, String firstName, String emailId, String password) {
			super();
			this.roleId = roleId;
			this.userId = userId;
			this.firstName = firstName;
			this.emailId = emailId;
			this.password = password;
		}
		public rolesTableModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
}
