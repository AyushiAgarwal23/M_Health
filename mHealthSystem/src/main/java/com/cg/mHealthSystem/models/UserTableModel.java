package com.cg.mHealthSystem.models;
import org.springframework.stereotype.Component;

import com.cg.mHealthSystem.entity.Roles;
@Component
public class UserTableModel {
	
	public class rolesTableModel{
		private Roles role;
		public String userId;
		public String firstName;
		public String emailId;
		public String password;
		
		public Roles getRole() {
			return role;
		}
		public void setRole(Roles role) {
			this.role = role;
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
		
		public rolesTableModel(Roles role, String userId, String firstName, String emailId, String password) {
			super();
			this.role = role;
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
