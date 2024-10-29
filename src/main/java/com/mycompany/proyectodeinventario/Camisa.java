/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodeinventario;
public class Camisa extends Producto {
    private String talla;
    private String color;

    public Camisa(String nombre, double precio, int cantidad, String talla, String color) {
        super(nombre, precio, cantidad);
        this.talla = talla;
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", Talla: " + talla + ", Color: " + color;
    }
}
