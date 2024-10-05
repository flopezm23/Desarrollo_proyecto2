package com.garajeideas.login.jpaLogin.dto;

public class UserDTO {
        private int id;
        private String username;
        private String password;
        private String role;
    
        // Constructor por defecto
        public UserDTO() {
        }
    
        // Getters y Setters
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
        public String getUsername() {
            return username;
        }
    
        public void setUsername(String username) {
            this.username = username;
        }
    
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }
        public String getRole() {
            return role;
        }
    
        public void setRole(String role) {
            this.role = role;
        }
    
}
