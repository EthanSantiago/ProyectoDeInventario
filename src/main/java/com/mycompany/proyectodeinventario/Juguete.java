/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodeinventario;
public class Juguete extends Producto {
    private String tipo;
    private int edadRecomendada;

    public Juguete(String nombre, double precio, int cantidad, String tipo, int edadRecomendada) {
        super(nombre, precio, cantidad);
        this.tipo = tipo;
        this.edadRecomendada = edadRecomendada;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo + ", Edad Recomendada: " + edadRecomendada + " años";
    }
}
