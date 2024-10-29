package com.mycompany.proyectodeinventario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class VentanaInventario extends JFrame {
    private JTextArea areaTexto;
    private JTextField campoNombre, campoPrecio, campoCantidad, campoMarca;
    private Inventario inventario;

    public VentanaInventario() {
        inventario = new Inventario();
        setTitle("Inventario de Tienda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setLayout(new BorderLayout(10, 10)); // Margen entre componentes

        // ---------- Panel Superior: Título ----------
        JLabel titulo = new JLabel("Inventario de Tienda", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // ---------- Panel Central: Área de Texto ----------
        areaTexto = new JTextArea(15, 50);
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Productos en Inventario"));
        add(scrollPane, BorderLayout.CENTER);

        // ---------- Panel Inferior: Campos de Entrada y Botones ----------
        JPanel panelInferior = new JPanel(new GridBagLayout());
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos de Entrada
        campoNombre = new JTextField();
        campoPrecio = new JTextField();
        campoCantidad = new JTextField();
        campoMarca = new JTextField();

        // Añadir etiquetas y campos de entrada al panel
        agregarCampo(panelInferior, gbc, "Nombre:", campoNombre, 0);
        agregarCampo(panelInferior, gbc, "Precio:", campoPrecio, 1);
        agregarCampo(panelInferior, gbc, "Cantidad:", campoCantidad, 2);
        agregarCampo(panelInferior, gbc, "Marca:", campoMarca, 3);

        // Botones de Acción
        JButton botonAgregar = new JButton("Agregar");
        JButton botonEliminar = new JButton("Eliminar");
        JButton botonExportar = new JButton("Exportar");

        gbc.gridwidth = 1; // Cada botón ocupa una celda
        gbc.gridy = 4;
        panelInferior.add(botonAgregar, gbc);
        gbc.gridx = 1;
        panelInferior.add(botonEliminar, gbc);
        gbc.gridx = 2;
        panelInferior.add(botonExportar, gbc);

        add(panelInferior, BorderLayout.SOUTH);

        // ---------- Acciones de los Botones ----------
        botonAgregar.addActionListener(e -> agregarProducto());
        botonEliminar.addActionListener(e -> eliminarProducto());
        botonExportar.addActionListener(e -> exportarProductos());

        setVisible(true);
    }

    // Método para añadir etiquetas y campos de entrada al panel inferior
    private void agregarCampo(JPanel panel, GridBagConstraints gbc, String etiqueta, JTextField campo, int fila) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        panel.add(new JLabel(etiqueta), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(campo, gbc);
        gbc.gridwidth = 1; // Restablecer después de añadir el campo
    }

    // Acción para agregar un producto al inventario
    private void agregarProducto() {
        try {
            String nombre = campoNombre.getText();
            double precio = Double.parseDouble(campoPrecio.getText());
            int cantidad = Integer.parseInt(campoCantidad.getText());
            String marca = campoMarca.getText();

            Producto producto = new Abarrote(nombre, precio, cantidad, marca);
            inventario.agregarProducto(producto);
            actualizarAreaTexto();
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Datos inválidos. Inténtalo de nuevo.");
        }
    }

    // Acción para eliminar un producto del inventario
    private void eliminarProducto() {
        String nombre = campoNombre.getText();
        inventario.eliminarProducto(nombre);
        actualizarAreaTexto();
        limpiarCampos();
    }

    // Acción para exportar los productos a un archivo
    private void exportarProductos() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar inventario");

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write(areaTexto.getText());
                JOptionPane.showMessageDialog(this, "Productos exportados correctamente.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al exportar productos.");
            }
        }
    }

    // Método para actualizar el área de texto con el inventario actual
    private void actualizarAreaTexto() {
        areaTexto.setText(inventario.listarProductos());
    }

    // Método para limpiar los campos de entrada
    private void limpiarCampos() {
        campoNombre.setText("");
        campoPrecio.setText("");
        campoCantidad.setText("");
        campoMarca.setText("");
    }

    public static void main(String[] args) {
        new VentanaInventario();
    }
}
