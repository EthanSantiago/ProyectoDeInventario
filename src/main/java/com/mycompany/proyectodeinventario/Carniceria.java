/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodeinventario;
public class Carniceria extends Producto {
    private double peso;

    public Carniceria(String nombre, double precio, int cantidad, double peso) {
        super(nombre, precio, cantidad);
        this.peso = peso;
    }

    @Override
    public String toString() {
        return super.toString() + ", Peso: " + peso + "kg";
    }
}
