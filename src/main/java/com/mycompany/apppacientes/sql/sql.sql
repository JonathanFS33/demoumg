/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jonathan
 * Created: Feb 10, 2024
 */

CREATE DATABASE UMG;

CREATE TABLE PACIENTES(
    id integer AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100) not null,
    direccion varchar(100) not null,
    telefono varchar(30)

)

