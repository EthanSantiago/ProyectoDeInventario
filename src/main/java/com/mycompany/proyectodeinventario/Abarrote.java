package com.mycompany.proyectodeinventario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Abarrote extends Producto {
    private String marca;

    public Abarrote(String nombre, double precio, int cantidad, String marca) {
        super(nombre, precio, cantidad);
        this.marca = marca;
    }

    @Override
    public String toString() {
        return super.toString() + " - Marca: " + marca;
    }
}
