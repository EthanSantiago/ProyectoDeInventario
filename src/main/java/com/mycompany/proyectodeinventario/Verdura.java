/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodeinventario;
public class Verdura extends Producto {
    private String fechaCaducidad;

    public Verdura(String nombre, double precio, int cantidad, String fechaCaducidad) {
        super(nombre, precio, cantidad);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return super.toString() + ", Caducidad: " + fechaCaducidad;
    }
}
